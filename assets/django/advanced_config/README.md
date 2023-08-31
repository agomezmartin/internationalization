# HOW TO: Advanced i18n configuration with Django settings file

The following configuration enables Django to automatically read user's local language and then switch between languages as required.
It is assumed Gettext has already been installed in the project. See [here](/assets/django/README.md) if required.

8 step configuration:

## 1. SETTINGS.PY file

**Set root language**

This is the root language Python will use if no other language is found.
It is set in LANGUAGE_CODE:
``` Python
# Internationalization
# https://docs.djangoproject.com/en/3.2/topics/i18n/

LANGUAGE_CODE = 'en' #'es'

TIME_ZONE = 'UTC'

USE_I18N = True

USE_L10N = True

USE_TZ = True

```
**Declare target languages**

This list of target languages needs to be created from scratch as it is NOT part of the settings.py file.
``` Python
# gettext_lazy is used to translate the language names instead of gettext to prevent circular imports.
# You should almost always use gettext_lazy when you're in the GLOBAL SCOPE.

from django.utils.translation import gettext_lazy as _

LANGUAGES = (
    ('en', _("English")),
    ('es', _("Spanish")),
)
```
**Add LocaleMiddleware**

This middleware allows Django to identify the target languages dinamically
``` Python
MIDDLEWARE = [
    'django.middleware.security.SecurityMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.locale.LocaleMiddleware', # added manually
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
]
```
**Add LOCALE_PATHS**

This path needs to be created from scratch as it is NOT part of the settings.py file.
``` Python
# Add a locale path directory for your application where message files will reside:

LOCALE_PATHS = [
    BASE_DIR / 'locale/',
]
```
## 2. Create a "LOCALE" **folder** inside your Django **app**

## 3. Mark strings for translation

- [Python files (\.py files)](/assets/python/gettext/README.md)
 
- [Django templates (\.html files)](/assets/django/templates_mark_for_translation/README.md)

## 4. Extract strings

In your **app**, run the following command:
``` Linux
$ django-admin makemessages --all --ignore=env
```
This command will browse through the entire project looking for any strings **marked for translation** AND extract them into language-specific **PO files**.

## 5. Translate PO files

## 6. Compile translated .PO files into .MO files
``` Linux
$ django-admin compilemessages
```
This command will generate machine-readable files.

## 7. Add language PREFIX to your **project**'s URLs (project/URLS.py)
``` Python
from django.conf.urls.i18n import i18n_patterns

urlpatterns = i18n_patterns (
	path("", include('app.urls'))
	)
```
This module will create language-specific versions of your app (/en, /es,...), hence optimizing indexation for search engines.

## 8. Display to the user switching language options
In order for the user to **switch language**, we will need to display the options in our templates.
The example below is a dropdown menu that will display as many languages as we will have set during this configuration.
``` HTML
<!-- ---------------------- I18N MENU ---------------------- -->
{% get_current_language as CURRENT_LANGUAGE %} <!-- Returns the current user’s preferred language as a string AND has it assigned to a variable name -->
{% get_available_languages as AVAILABLE_LANGUAGES %} <!-- Returns a list of tuples declared in the SETTINGS.PY file in which the first element is the language code and the second is the language name (translated into the currently active locale). A variable name is assigned. -->
{% get_language_info_list for AVAILABLE_LANGUAGES as languages %} <!-- It retrieves information about any of the available languages. -->
<div class="btn-group" style="display: flex;">

  <button type="button" style="flex:50%" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      	Select language:
  </button>

  <ul class="dropdown-menu">
    {% for language in languages %}
    <!-- i18n patterns module will read this code and execute it as URL -->
    <li><a href="/{{ language.code }}/"
           class="dropdown-item">
        {{ language.name_local }}</a></li>
    {% endfor %}
  </ul>
</div>
<!-- ---------------------- End of I18N MENU ---------------------- -->
```