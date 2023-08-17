# HOW TO: GETTEXT on Python files

This class-based API is the recommended way of internationalizing Python applications. 

## 1. Install Gettext in your project

```
$  pip install python-gettext
```
## 2. Folder structure

Create the following **folder structure** in your project where **source** and **target** strings will later be saved.

<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure_1.png">

## 3. Mark strings for translation
- Import gettext
- Create gettext object and assign it to the underscore
- Enclose any text to be extracted and translated using **_()**

``` Python
from connection import Database
# Import Gettext
import gettext

dbObject = Database()

# Gettext object is assigned to the underscore
_ = gettext.gettext

def displayrequest():
    sal1 = 0
    sal2 = 0

    try:
    	# strings are marked with underscore and enclosed between parentheseis _()
        sal1 = int(input(_("Please, insert first salary: ")))
        sal2 = int(input(_("Please, insert second salary: ")))

        if sal1 <= 0 or sal2 <= 0:
            print("======================")
	    	# strings are marked with underscore and enclosed between parentheseis _()
            print(_("Negative figures are not allowed."))
            print("======================")
            displayrequest()

    except ValueError:
        print("======================")
    	# strings are marked with underscore and enclosed between parentheseis _()
        print(_("Only figures allowed."))
        print("======================")
        displayrequest()

    query = dbObject.queryData(sal1, sal2)

    print("======================")

    for sur, post, sal in query:
    	# strings are marked with underscore and enclosed between parentheseis _()
        print(_("Surname: "), sur)
        print(_("Job position: "), post)
        print(_("Salary: "), sal)
        print("======================")

displayrequest()
```

## 4. Create POT template

GETTEXT utilizes a **POT template file** from which language-specific PO files are generated.

The **POT template file** is generated executing file "pygettext.py" just above the **locales** folder:

``` Commandline
$   //Library/Frameworks/Python.framework/Versions/3.7/share/doc/python3.7/examples/Tools/i18n/pygettext.py -d base -o locales/base.pot [file containing strings].py
```
<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure_2.png">


## 5. Create language-specific PO files

COPY the .POT template and PASTE it into each LC_MESSAGES folder.
**Convert** it to .PO file format by removing the T from the file name.

## 6. Translate language-specific PO files

Translate the PO files by filling the `msgstr ""` tags.

## 7. Generate MO files

Gettext works by reading binary files (.MO).
These files are created with the tool **MSGFMT.PY** below:

``` Commandline
$ cd [move to the folder containing the PO files]

$   //Library/Frameworks/Python.framework/Versions/3.7/share/doc/python3.7/examples/Tools/i18n/msgfmt.py -o base.mo [PO file]
```

Final folder structure should look as follows:

<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure_3.png">




<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure_3.png">

<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure.png">

<img src="https://github.com/agomezmartin/regexl10n/blob/main/assets/images/gettext_folder_structure.png">


This entry has been summarized from [Phrase](https://phrase.com/blog/posts/translate-python-gnu-gettext/)

