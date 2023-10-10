# HOW TO: Text isolation (text extraction)

Isolating text is probably the core approach in multilingual software as it enables software to be language-independant.

Altough harcoded strings might help during the very early stages of software development, the sooner **text isolation** techniques are implemented, the more efficient both i18n and l10n approaches will be.

The class **ResourceBundle** is J2SE Internationalization API's main class for **text isolation**.

This class enables extracting GUI strings out to - normally - resource key-value formatted **.properties files**.

In order to perform interpolation - the ability to pass dynamic content to otherwise completely static strings - J2SE uses **MessafeFormat Class**.

These are the two main classes for text isolation, but a third will be used so they know the language to be used: **Locale Class**.

# 1. Properties file

A **.properties** file needs to be created to store all the strings in key-value format.
As best practice, create a file called:

BUNDLE_language_code.PROPERTIES

and save it in a RES folder.

<img src="/assets/images/resource.bundle.png">


# 2. Import and create objects for all three classes

Create the objects in the order above as both ResourceBundle and MessageFormat will need to read Locale's language.
``` Java
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;



Locale locale = new Locale("es", "es");
ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
MessageFormat message = new MessageFormat("");

```
# 3. Populate .properties file
Your Java program will extract strings from this file using the key as an id.
The example below displays keys in red, values after the equals sign in black: 
``` Properties
saldo=Please, provide you bank account funds: 
saldo.actual=Your bank account funds: {0}
cuenta.menu=Please, select and option: \n\n1. Pay in\n2. Pay out\n3. Bank statement\n4. See funds\n5. Exit
saldo.ingresar=Please, input pay in amount: 
saldo.ingreso.realizado=Money has been paid in successfully.
saldo.extraer=Please, input pay out amount: 
saldo.extraccion.realizada=Money has been paid out successfully.
saldo.extraccion.sobrepasada={0} exceeds your pay out limit. {1} has been paid out.
lista.movimientos=Bank statement
tipo.ingreso=Pay in: 
tipo.extraccion=Pay out: 
lista.no.movimientos=No transactions available
cuenta.salida=Thanks for using our online banking app.
```

Populate your .properties file in order to contain all of your applications strings.

Any dynamic content that needs to be embeeded in a string can be referenced by using placeholders.
The **placeholders format** is increasing numbers enclosed in curly brackets as shown above and below:

- Your bank account funds: {0}
- {0} exceeds your pay out limit. {1} has been paid out.

These placeholders will later be handled by the MessageFormat class to dynamically insert the data.

# 4. Mark source code to import strings
Now that the content has been isolated, all we need to do is call the strings using the objects we created in Step 2.

We can alternate both ResourceBundle and MessageFormat objects as per our needs:

- ResourceBundle alone if we **do not** need to include dynamic content:
``` Properties
System.out.println(bundle.getString("saldo.actual"));
```
- MessafeFormat + ResourceBundle if we do need to pass it **dynamic content** to the strings:
``` Properties
System.out.println(message.format(bundle.getString("saldo.extraccion.sobrepasada"), cantidad, limite));
```
MessageFormat example above works by calling a STRING, then as many variables as required.


[JAVA EE: Hierchy, Currency, Data Model, Maven, Lombok and i18n	](/assets/_projects/java/BankAccount_Hierchy_Currency_i18n/)