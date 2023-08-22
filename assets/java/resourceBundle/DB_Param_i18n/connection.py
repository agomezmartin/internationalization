import mysql.connector as db

class Database:
    def __init__(self):
        self.db_connection = db.connect(host='localhost', user='root', password='root', port='3306', database='emp')
        self.cursor = self.db_connection.cursor()

    def queryDB(self, position):

        try:
            post = position
            query = ('SELECT ename, job, sal FROM emp WHERE job=%s')
            self.cursor.execute(query, (post,))

        except db.connector.Error as error:
            print("Error: ", error)

        return self.cursor