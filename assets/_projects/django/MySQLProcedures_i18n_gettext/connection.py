import mysql.connector as db

class Database:
    def __init__(self):
        self.db_connection = db.connect(host='localhost', user='root', password='root', database='emp')
        self.cursor = self.db_connection.cursor()

    def create(self, args):
        self.cursor.callproc('InsertarDEPT', (args))
        control = self.cursor.rowcount
        self.db_connection.commit()
        return control