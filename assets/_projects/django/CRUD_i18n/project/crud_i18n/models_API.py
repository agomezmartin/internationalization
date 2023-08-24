from django.db import models
import requests
from requests.exceptions import HTTPError

# Create your models here.
class Database():
    def __init__(self):
        self.apiurl = "https://apiempleadosspgs.azurewebsites.net/api/Empleados/7839"
    def viewTable(self):

        try:
            response = requests.get(self.apiurl)
            response.raise_for_status()
            # access JSON content
            jsonResponse = response.json()

            return jsonResponse.items()

        except HTTPError as http_err:
            return print(f'HTTP error occurred: {http_err}')
        except Exception as err:
            return print(f'Other error occurred: {err}')



"""
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
"""
