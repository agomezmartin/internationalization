# HOW TO... ResourceBundle in Python

This module has been created in a Java-like fashion to mirror its counterpart Java **Class** ["PropertyResourceBundle"](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/PropertyResourceBundle.html).
## 1. Install ResourceBundle in your project
```
# windows
>  py -m pip install ResourceBundle

# linux / macOS
$  python3 -m pip install ResourceBundle
```

## 3. Create a resources file containing **strings**
- Create a **strings_en.properties** file and save it in your project
- Open it and include your strings in **key** and **value** format:

Example:
``` Properties
request=Please, insert a position: 
```
> File name: <br><br>
strings_en.properties <br><br>
File [here](https://github.com/agomezmartin/internationalization/blob/main/assets/python/resourceBundle/DB_Param_i18n/res/strings_en.properties)

> Format: <br><br>
**key**=value

## 3. Import module and properties file into an instance variable

``` Python
import ResourceBundle

bundle = ResourceBundle.get_bundle("res/strings", "en")
print(bundle.get("request"))
```

> The example above calls a file called **strings_en.properties** saved in **folder** res.

## 4. Use the instanced variable to view the string

- Call the **key** from the resource file (strings_en.properties)
``` Python
print(bundle.get("request"))
```
Result:
<br>
<img src="/assets/images/string_example.png">

Actual Python project example [here](DB_Param_i18n/).