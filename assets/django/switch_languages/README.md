# HOW TO: Switch languages from Django HTML templates

This entry focuses on the settings required for Django HTML templates to provide language selection options to the user.
To demonstrate this, a **drop-down menu** has been created.
Unless i18n settings have been configured in our [settings.py](/assets/django/advanced_config/README.md) file, the example below will not work.

## 1. Display switching language options to the user

``` HTML
<!-- ---------------------- I18N MENU ---------------------- -->
<!DOCTYPE html>
{% load i18n %}
...
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

This entry is an adaptation from [**Samuel Torimiro**](https://testdriven.io/blog/multiple-languages-in-django/#allowing-users-to-switch-languages)'s article.