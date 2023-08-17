# HOW TO: i18n with Django

This class-based API is the recommended way of internationalizing Python applications. 

## 1. Install Gettext in your project

```
$  pip install python-gettext
```
## 2. Mark strings to be translated

- [\.py files](/assets/python/gettext/README.md)
 
- templates (\.html files)

## 3. Create a "LOCALE" **folder** inside your Django **app**

## 4. In your **app**, run the following command: 
``` Console
django-admin makemessages -l es
```
Change **es** to whichever language you want to extract strings for.

FR for French, DE for German, EL for Greek and so on.

This command will browse through the entire project looking for any strings **marked for translation** AND create PO files

## 5. Translate PO files

## 6. Compile PO files with the following command:
``` Console
django-admin compilemessages
```








<!-- 






<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure_3.png">




<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure_3.png">

<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure.png">

<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure.png">


This entry has been summarized from [Phrase](https://phrase.com/blog/posts/translate-python-gnu-gettext/)

-->
