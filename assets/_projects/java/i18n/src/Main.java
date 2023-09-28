import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Creación de un ARRAYLIST que contenga todas las cadenas de cada idioma
		 */
//		ArrayList <Object> MultilingualStrings;
//		MultilingualStrings = new ArrayList<Object>();
		
		/*
		 *  Se crea un OBJETO por idioma con el contenido de la clase LOCALE que permite
		 *  establecer el CÓDIGO del idioma que se va a usar
		 */
		Locale locale = new Locale("");		
		Locale locale_fr_FR = new Locale("fr", "FR");		
		Locale locale_it_IT = new Locale("it", "IT");		
		Locale locale_de_DE = new Locale("de", "DE");		
		Locale locale_es_ES = new Locale("es", "ES");		
		
		/*
		 * Con resourceBundle se selecciona el archivo PROPERTIES + código de idioma
		 */
		ResourceBundle resourceBundle = ResourceBundle.getBundle("res.bundle");
		ResourceBundle resourceBundle_fr_FR = ResourceBundle.getBundle("res.bundle", locale_fr_FR);
		ResourceBundle resourceBundle_it_IT = ResourceBundle.getBundle("res.bundle", locale_it_IT);
		ResourceBundle resourceBundle_de_DE = ResourceBundle.getBundle("res.bundle", locale_de_DE);
		ResourceBundle resourceBundle_es_ES = ResourceBundle.getBundle("res.bundle", locale_es_ES);

		/*
		 * Añadimos los objectos al ARRAYLIST para poder usarlos indiscriminadamente
		 */
		
		//		MultilingualStrings.add(resourceBundle_fr_FR);
		//		MultilingualStrings.add(resourceBundle_it_IT);
		//		MultilingualStrings.add(resourceBundle_de_DE);
		//		MultilingualStrings.add(resourceBundle_es_ES);		
		
		/*
		 * imprime por pantalla el contenido usando las llaves		
		 */

		System.out.println(resourceBundle_de_DE.getString("hello"));
		
		
		
	}

}
