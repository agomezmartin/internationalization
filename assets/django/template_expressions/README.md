# HOW TO: Translate template expressions</br>(sentences with variables)

Template expressions in Django allow to **display data** to the user fetched from databases, modules, external files or any content we pass it.

The example below is a **pagination** expression.
``` HTML
Page {{ page_obj.number }} of {{ page_obj.paginator.num_pages }}
```
The object attributes in **between double curly brackets** will be replaced by numbers as the user moves pages to visualize all list elements. 

<img src="/assets/images/pagination_en.png">

## Blocktranslate Template Tag
The blocktranslate template tag enables to extract for translation complex sentences containing both literal AND variable content.
``` HTML
{% blocktranslate %}

Page {{ page_obj.number }} of {{ page_obj.paginator.num_pages }}

{% blocktranslate %}
```
The example above will **NOT** work correctly just yet. It still needs further fine-tuning

## Blocktranslate placeholders

Blocktranslate handles variable content by having it assigned to **placeholders** as shown below.
``` HTML
{% blocktranslate with
	number=page_obj.number|title
	total=page_obj.paginator.num_pages|title
%}

Page {{ number }} of {{ total }}

{% endblocktranslate %}
```
Placeholders are created within the blocktranslate block, **before** the **equals sign**, then they are used as **variables** in the sentence itself.

After executing the **makemessages** command, this example will be **extracted** to the language-specific PO file for translation:

``` PO
msgid "Page %(number)s of %(total)s"
msgstr ""
```

After translating the content and executing the **compilemessages** command, the pagination will display correctly:
``` PO
msgid "Page %(number)s of %(total)s"
msgstr "Página %(number)s de %(total)s"
```
<img src="/assets/images/pagination_es.png">
