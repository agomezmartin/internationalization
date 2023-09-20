# HOW TO: Reverse URL maps

Reversing URL maps enables to create **links** that **dinamycally** point at URL maps. The opposite to this Django-specific technique is **hard coding** links.

Reversing URL maps is a more robust approach as it is NOT pattern-dependant.

## Standard hard coded link

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