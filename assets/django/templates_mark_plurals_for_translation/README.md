# HOW TO: Mark plurals for translation

A pivotal aspect of internationalization (i18n) is **pluralization**. Professionals working on programming languages and their frameworks have traditionally dedicated plenty of research to efficiently handling this important characteristic of **natural languages**.

Because natural languages have each their specific pluralization rules, technologies need to be able to reflect these nuances in a way the impact in the core functionality is reduced as much as possible.

The role of language-specific **linguists** in helping software developers create **pluralization rules** is sometimes overseen, but it is these subtle nuances that make a difference in multilingual software.

## 1. Basic Pluralization example
``` HTML
<p>
  You have visited this page {{ num_visits }} time{{ num_visits|pluralize }}.
</p>
```

Depending on the **visit numbers**, the example above will produce:

- You have visited this page 1 time.
- You have visited this page 2 times.
- You have visited this page 3 times.
- ...

Django's standard pluralization in English works by adding an 's'. Since not all plurals are constructed in this fashion, Django also enables editing how plurals are constructed.
``` HTML
<p>
  You have {{ num_child }} child{{ num_child|pluralize:"ren" }}.
</p>
```

The example above produces:

- You have 1 child.
- You have 2 children.
- You have 3 children.
- ...

**Language-specific linguists** would ideally help software developers create pluralization rules that meet the project's **requirements**.

## Marking Plurals for translation

Plurals in Django are marked for translation using the [**blocktranslate**](/assets/django/templates_mark_expressions_for_translation/README.md) tag:

``` HTML
<p> {% blocktranslate count counter=num_visits|length %}
		You have visited {{counter}} time.
		{% plural %}
		You have visited {{counter}} times.
    {% endblocktranslate %}
</p>
```

Blocktranslate works by declaring a **count** variable to which the context variable is assigned:
``` Python
count counter=num_visits|length
```
Once the singular form is created, **plural forms** are declared whithin the blocktranslate tag.