from django.shortcuts import render
from crud_i18n.models import Database

dbObject = Database()

# Create your views here.
def index(request):
    return render(request, 'index.html')
def crudOperations(request):
    create = 0
    update = 0
    delete = 0
    table = ""

    operation = request.POST['crud']

    # CREATE
    if operation == 'create':
        number = request.POST['txtNum']
        name = request.POST['txtName']
        location = request.POST['txtLoc']

        if dbObject.create(number, name, location) != None:
            create = 1
    # UPDATE
    if operation == 'update':
        number = request.POST['txtNum']
        name = request.POST['txtName']
        location = request.POST['txtLoc']

        if dbObject.update(name, location, number) != None:
            update = 1
    # DELETE
    if operation == 'delete':
        number = request.POST['txtNum']
        name = request.POST['txtName']

        if number and name:
            if dbObject.delete(number) != None:
                delete = 1
        elif number:
            if dbObject.deleteWithNumber(number) != None:
                delete = 1
        elif name:
            if dbObject.deleteWithName(name) != None:
                delete = 1

    # VIEW TABLE
    if operation == 'seeTable':
        table = dbObject.viewTable()

    context = {
        'created': create,
        'updated': update,
        'deleted': delete,
        'table' : table,
    }

    return render(request, 'index.html', context)