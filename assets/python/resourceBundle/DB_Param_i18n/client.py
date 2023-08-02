from connection import Database
import ResourceBundle

dbObject = Database()
bundle = ResourceBundle.get_bundle("res/strings", "en")
position = input(bundle.get("request"))

cursor = dbObject.queryDB(position)
print("============£=============")

for surname, post, sala in cursor:
    print("Surname: ", surname)
    print("Job post: ", post)
    print("Salary: ", sala)
    print("=========================")
