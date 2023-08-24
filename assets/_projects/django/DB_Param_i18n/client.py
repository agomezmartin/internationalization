from connection import Database
import ResourceBundle

dbObject = Database()
bundle = ResourceBundle.get_bundle("res/strings", "en")
position = input(bundle.get("request"))

cursor = dbObject.queryDB(position)
print("=========================")

for surname, post, sala in cursor:
    print(bundle.get("surname"), surname)
    print(bundle.get("job"), post)
    print(bundle.get("salary"), sala)
    print("=========================")
