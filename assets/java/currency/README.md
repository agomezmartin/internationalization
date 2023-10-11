# HOW TO: Currency

Following from the previous entry on [**text isolation**](/assets/java/text_isolation/README.md/), locale-specific currencies follow a similar approach.

1. Class import
2. Object creation
3. Use of class methods through the specific objects

The class available in J2SE to handle currencies is:

- **NumberFormat**

NumberFormat contains a set of language-specific currency formats which can be called and applied to our numbers.
Used alongside our class **Locale**, we will be able to tell our applications which country we want to format numbers as.

For conciseness, other classes and objects have been **commented out**.
Below, Locale and NumberFormat classes are imported and instanced as objects:

``` Java
// import java.text.MessageFormat;
import java.util.Locale;
// import java.util.ResourceBundle;
import java.text.NumberFormat;



Locale locale = new Locale("en", "GB");
// ResourceBundle bundle = ResourceBundle.getBundle("res.bundle", locale);
// MessageFormat message = new MessageFormat("");
NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

```
Once the NumberFormat object has been created, **currencyFormatter**, a locale is passed through its **getCurrencyInstance** constructor to select a language.
The class is now ready to be used in our source code using its **format(double number)** method.

``` Java
System.out.println(message.format(bundle.getString("saldo.actual"), currencyFormatter.format(500)));
```
The example above displays:

- Your bank account funds: **£500.00**

NumberFormat is applying the UK's currency symbol along with its number format (dotted decimals). The string "Your bank account funds: " is being read from an isolated string in a properties file as shown in the previous entry.

If the locale passed to our NumberFormat object is changed, so will the format:
``` Java
Locale locale = new Locale("es", "ES");
```
Now, the Spanish from Spain international code is being passed, and the class will display:

- El saldo de tu cuenta es: **500,00 €**

NumberFormat applies Spain's currency symbol this time placing it after the figures along with its decimal format (comma decimals).


Example project: [JAVA EE: Inheritance, Currency, Data Model, Maven, Lombok and i18n	](/assets/_projects/java/BankAccount_Hierchy_Currency_i18n/)


Next: [Locale-specific **dates**](/assets/java/dates/README.md/)

