from django.shortcuts import render
from crud_i18n.models import Database

dbObject = Database()

# Create your views here.
def index(request):
    return render(request, 'index.html')
def crudOperations(request):
    table = ""

    operation = request.POST['crud']
    # VIEW TABLE
    if operation == 'seeTable':
        table = dbObject.viewTable()

    context = {
        'table' : table,
    }

    return render(request, 'index.html', context)