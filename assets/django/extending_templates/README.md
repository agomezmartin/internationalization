# HOW TO: Extend templates

Extending templates help **resuse** existing code. Instead of writing the same code in every page that is needed, our browser will insert pieces of code automatically.

From an **internationalization (i18n)** point of view, extending Django templates makes sense because not only does it prevent **duplicating** boilerplate code on every page (ie. navbar, footer, title, etc.), but it **optimizes the number of language-specific instances created for page content**.

Also, extended templates help **Gettext** to extract, translate and compile content. By extending templates, Gettext will need to browse through only the _base_generic.html_ template to extract repeated content.

After compilation, Django _templating language_ will extend repeated sections and replace just the bits that are different for each specific page.

HTML comments below explain how _templating language_ is used in Django:

## Create a _Base Generic_ template

``` HTML
<!-- The template tag BLOCK is used to mark the different sections that will be replicated throughout the site. Each BLOCK receives a unique name to use as an id  -->
<!-- Sections that will have content inserted from other pages need to be left EMPTY -->
<!DOCTYPE html>
<html lang="en">
  <head>

    {% block title %}
      <title>Page title</title>
    {% endblock %}
  
  </head>
  
  <body>
  
    {% block sidebar %}
      <!-- insert default navigation text for every page -->
    {% endblock %}
  
    {% block content %}
      <!-- default content text (normally empty) -->
    {% endblock %}

  </body>
</html>
```

## Extend base template into page-specific template

``` html
<!-- The template tag below links this page's content into the base_generic template -->
{% extends "base_generic.html" %}

<!-- The template tag below sends its content into the base_generic template -->
{% block content %}

  <h1>This is the CONTENT header</h1>

  <p>This CONTENT will be inserted in the block content of the base_generic template.</p>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

{% endblock %}
```


