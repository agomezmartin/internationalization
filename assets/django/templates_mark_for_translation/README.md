# HOW TO: Mark Django templates for translation

## 1. Mark strings

In order to have string exported for translation, they need to be marked following the format **{% translate "..." %}**. Any content between the double quotes will be exported for translation into PO files.

Example:
``` HTML
<h3 class="text-center">{% translate "Please, select:" %}</h3>
```

Another option is **using variables** within the markdown to contain translations:

Same example using a variable:
``` HTML
{% translate "Please, select:" as title_header %}

<h3 class="text-center">{{title_header}}</h3>
```


## 2. Prepare the template to load translations and select language


``` HTML
<!DOCTYPE html>
{% load i18n %}
{% language 'es' %} <!-- Not required if advanced i18n configuration is performed -->

<html>
<head>
...
</head>
<body>
...
</body>
</html>
{% endlanguage %} <!-- Not required if advanced i18n configuration is performed -->
```