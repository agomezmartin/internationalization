# HOW TO: Select LANGUAGE in Python files

## 1. Create language-specific objects
``` Python
import gettext as gt

# Language-specific objects
en = gt.translation('client', localedir='locales', languages=['en'])
es = gt.translation('client', localedir='locales', languages=['es'])
```
## 2. Save each language-specific object in an array
``` Python
import gettext as gt

# Language-specific objects
en = gt.translation('client', localedir='locales', languages=['en'])
es = gt.translation('client', localedir='locales', languages=['es'])

# Object array containing all available languages
languages = [en, es]
```
## 3. Install the language to be used
``` Python
import gettext as gt

# Language-specific objects
en = gt.translation('client', localedir='locales', languages=['en'])
es = gt.translation('client', localedir='locales', languages=['es'])

# Object array containing all available languages
languages = [en, es]

# Language is installed
languages[0].install()
languages[1].install()
```
## 4. Use the language installed to get language-specific text with the gettext object
``` Python
import gettext as gt

# Language-specific objects
en = gt.translation('client', localedir='locales', languages=['en'])
es = gt.translation('client', localedir='locales', languages=['es'])

# Object array containing all available languages
languages = [en, es]

# Language is installed
languages[0].install()
languages[1].install()

# Language is applied to GETTEXT object
_ = languages[0].gettext
_ = languages[1].gettext
```

Project [example](https://github.com/agomezmartin/internationalization/blob/main/assets/_projects/django/MySQLProcedures_i18n_gettext/client.py).
This entry has been summarized from [Phrase](https://phrase.com/blog/posts/translate-python-gnu-gettext/)