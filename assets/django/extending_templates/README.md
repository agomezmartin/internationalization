# HOW TO: Extend templates

From the **internationalization (i18n)** point of view, extending Django templates makes sense as not only prevents duplicating boilerplate code on every page (ie. navbar, footer, title, etc.), it optimizes the number of language-specific instances created for page content.

Django uses Gettext to extract, translate and compile content. By extending templates, Gettext will need to browse through only the _base_generic.html_ template to extract repeated content.

After compilation, Django _templating language_ will extend repeated sections and replace just the bits that are different for each specific page.


## Create a _Base Generic_ template

DJANGO TEMPLATE
``` HTML
<a href="/catalog/">Home</a>.
```
DJANGO APP URL
``` Python
urlpatterns = [
    path('', views.index, name='index'),
]
```

The standard hard coded link above will ALWAYS call our "catalog" URL, which is the **root URL** in this example.
In the example above, the map works because our pattern is **empty**. If we decided to add a pattern, our link would **stop** working.

## Reversed URL map

DJANGO TEMPLATE
``` HTML
<a href="{% url 'index' %}">Home</a>.
```
DJANGO APP URL
``` Python
urlpatterns = [
    path('', views.index, name='index'),
]
```

The reversed URL map allows pointing to the **name attribute** from the link instead of pointing to the pattern.
Even if we decided to add a different pattern - currently empty in this example - the link will still be able to locate our URL.

The reversed link would still be able to locate the URL in the example below, where a pattern has been added ('index'):


DJANGO APP URL
``` Python
urlpatterns = [
    path('index', views.index, name='index'),
]
```

This is because the link is pointing to the **name attribute**.