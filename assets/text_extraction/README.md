# Extracting "Resource files" text for translation with regexes

## List of REGEXES as per <ins>tecnology</ins> and <ins>file type</ins> 

| TECHNOLOGY 	| FILE TYPE		| CONTENT 								| REGEX 														| 
| ----------	|-----------	|--------								|---------														|
| Android   	|	XML			|	Main								| (?<=>)(.*?)(?=<)												|
|				|	XML			|	Attributes							| (?<=attribute_name=")(.*?)(?=">?)								|
| AngularJS		|	JSON		|	Main								| (?<="\s:\s")(.*?)(?=",?)										|
| Apple iOS 	|	STRINGS		|	Main								| (?<="\s=\s")(.*?)(?=";?)										|
| CSV			|	CSV			|	Main								| (?<=,,")(.*?)(?=",)											|
| CakePHP   	|	PO			|	msgid								| (?<=\nmsgid\s")(.*?)(?="\n)									|
|    			|	PO			|	msgstr								| (?<=\nmsgstr\s")(.*?)(?="\n?)									|
| DOCS   		|	DOCX		|										| Text extraction performed manually or with stand-alone tools	|
| Django		|	PO			|	msgid								| (?<=\nmsgid\s")(.*?)(?="\n)									|
| 				|	PO			|	msgstr								| (?<=\nmsgstr\s")(.*?)(?="\n?)									|
| Ember Intl	|	JSON		|	Main								| (?<="\s:\s")(.*?)(?="\n?)										|
| GWT			|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| Gettext PO	|	PO			|	msgid								| (?<=\nmsgid\s")(.*?)(?="\n)									|
|    			|	PO			|	msgstr								| (?<=\nmsgstr\s")(.*?)(?="\n?)									|
| Grails		|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| I18next		|	JSON		|	Main								| (?<="\s:\s")(.*?)(?=",?)										|
| IDML			|	IDML		|										| Text extraction performed manually or with stand-alone tools	|
| INI			|	INI			|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| JSON			|	JSON		|	Main								| (?<="\s:\s")(.*?)(?=",?)										|
| JAVA SPRING	|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| JAVA			|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| PROPERTIES	|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| PHP Define	|	PHP			|	Main								| (?<=",\s")(.*?)(?=")	 										|
| Play			|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| Qt			|	TS			|	Main								| (?<=\<translation\>)(.*?)(?=\</translation\>)					|
| RESJSON		|	RESJSON		|	Main								| (?<="\s:\s")(.*?)(?=",?)										|
| RESW			|	RESW		|	Main								| (?<=\<value\>)(.*?)(?=\</value\>)								|
| RESX			|	RESX		|	Main								| (?<=\<value\>)(.*?)(?=\</value\>)								|
| React Intl	|	JSON		|	Main								| (?<="\s:\s")(.*?)(?="\n?)										|
| Ruby on Rails	|	YML			|	Main								| To be fine-tuned												|
| Symfony		|	YML			|	Main								| To be fine-tuned												|
| Vaadin		|	PROPERTIES	|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| XLIFF			|	XLF			|	Target tag							| (?<=<target[^>]+>)(.*?)(?=</target>)							|
| Zend Framework|	INI			|	Main								| (?<=\s=\s)(.*?)(?=\n) 										|
| 				|	PO			|	msgid								| (?<=\nmsgid\s")(.*?)(?="\n)									|
| 				|	PO			|	msgstr								| (?<=\nmsgstr\s")(.*?)(?="\n?)									|

## Entities

| ENTITY		 												| REGEX					| 
| ----------													|--------				|
|	Block {{placeholders}}										| (\\{\\{(.*?)\\}\\})	|
|	Block escaped entities \n, \t...							| (\\\\\w)				|
|	Block % entities \\%										| (\\\\\%)				|
|	Block {{placeholders}} with % entities %{{placeholders}}	| (\%\\{\\{(.*?)\\}\\})	|

## File prepp for translation

**File prep tasks** can be found [HERE](/assets/file_prepp/README.md)
