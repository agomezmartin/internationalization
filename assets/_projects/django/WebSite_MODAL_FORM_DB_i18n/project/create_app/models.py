from django.db import models
import mysql.connector as db

# Create your models here.
class Database:
    def __init__(self):
        self.db_connection = db.connect(host='localhost', port='3306', user='root', password='root', database='emp')
        self.cursor = self.db_connection.cursor()
    def createUser(self, data):
        try:
            args = data
            query = ('INSERT INTO Ejercicio75 (NAME_USER, ADDRESS, CITY, GENDER, OPERATING_SYSTEM, COMMENTS) VALUES (%s, %s, %s, %s, %s, %s)')

            self.cursor.execute(query,(args))
            entryNum = self.cursor.rowcount

            self.db_connection.commit()

        except self.db_connection.Error as error:
            print("Error: ", error)
            entryNum = error

        return entryNum
    def viewTableData(self):

        self.cursor.execute('SELECT id_user, NAME_USER, ADDRESS, CITY, GENDER, OPERATING_SYSTEM, COMMENTS FROM Ejercicio75')

        return self.cursor
    def delete(self, userId):
        try:
            id = userId
            query = ('DELETE FROM Ejercicio75 WHERE id_user=%s')
            self.cursor.execute(query,(id,))
            entryNum = self.cursor.rowcount

            self.db_connection.commit()

            self.cursor.execute('SELECT id_user, NAME_USER, ADDRESS, CITY, GENDER, OPERATING_SYSTEM, COMMENTS FROM Ejercicio75')

        except self.db_connection.Error as error:
            print("Error: ", error)

        return self.cursor