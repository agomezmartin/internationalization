from django.db import models
import mysql.connector as db

# Create your models here.
class Database():
    def __init__(self):
        self.db_connection = db.connect(host='localhost', port='3306', user='root', password='root', database='emp')
        self.cursor = self.db_connection.cursor()
    def create(self, numParam, nameParam, locParam):

            args = (numParam, nameParam, locParam)
            query = 'INSERT INTO dept VALUES(%s, %s, %s)'

            self.cursor.execute(query, (args))
            self.db_connection.commit()

            count = self.cursor.rowcount

            return count
    def update(self, nameParam, locParam, numParam):

            args = (nameParam, locParam, numParam)
            query = 'UPDATE dept SET dname = %s, location = %s WHERE deptno = %s'

            self.cursor.execute(query, (args))
            self.db_connection.commit()

            count = self.cursor.rowcount

            return count
    def delete(self, numParam):
        num = numParam
        query = 'DELETE FROM dept WHERE deptno = %s'

        self.cursor.execute(query, (num,))
        self.db_connection.commit()

        count = self.cursor.rowcount

        return count
    def deleteWithNumber(self,numParam):
        num = numParam
        query = 'DELETE FROM dept WHERE deptno = %s'

        self.cursor.execute(query, (num,))
        self.db_connection.commit()

        count = self.cursor.rowcount

        return count
    def deleteWithName(self,nameParam):
        name = nameParam
        query = 'DELETE FROM dept WHERE dname = %s'

        self.cursor.execute(query, (name,))
        self.db_connection.commit()

        count = self.cursor.rowcount

        return count
    def viewTable(self):
        self.cursor.execute('SELECT deptno, dname, location FROM dept')

        return self.cursor