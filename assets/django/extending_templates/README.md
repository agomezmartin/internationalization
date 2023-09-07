# HOW TO: Extend templates

From an **internationalization (i18n)** point of view, extending Django templates makes sense because not only does it prevent duplicating boilerplate code on every page (ie. navbar, footer, title, etc.), it optimizes the number of language-specific instances created for page content.

Django uses Gettext to extract, translate and compile content. By extending templates, Gettext will need to browse through only the _base_generic.html_ template to extract repeated content.

After compilation, Django _templating language_ will extend repeated sections and replace just the bits that are different for each specific page.


## Create a _Base Generic_ template

(To be cotinued...)