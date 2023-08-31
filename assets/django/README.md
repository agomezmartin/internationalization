# HOW TO: Basic i18n configuration with Django

This class-based API is the recommended way of internationalizing Python applications. 

## 1. Install Gettext in your project

``` Linux
$  pip install python-gettext
```
## 2. Mark strings for translation

- [Python files (\.py files)](/assets/python/gettext/README.md)
 
- [Django templates (\.html files)](/assets/django/templates_mark_for_translation/README.md)

## 3. Create a "LOCALE" **folder** inside your Django **app**

## 4. Extract strings

In your **app**, run the following command:
``` Linux
$ django-admin makemessages -l es
```
Change **es** to whichever language you want to extract strings for.

FR for French, DE for German, EL for Greek and so on.

This command will browse through the entire project looking for any strings **marked for translation** AND extract them into language-specific **PO files**.

## 5. Translate PO files

## 6. Compile PO files

PO files need to be compiled for the machine to read.
The following command will compile them and convert them to machine-readable MO files:
``` Linux
$ django-admin compilemessages
```
## 7. Load translations and set language-specific code in template:
``` HTML
<!DOCTYPE html>
{% load i18n %}
{% language 'es' %}

<html>
<head>
...
</head>
<body>
...
</body>
</html>
{% endlanguage %}
```