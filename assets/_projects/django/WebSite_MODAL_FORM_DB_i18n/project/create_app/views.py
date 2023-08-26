from django.shortcuts import render
from create_app.models import Database
import gettext as gt

_ = gt.gettext
dbObject = Database()

# Create your views here.
def index(request):
    return render(request, 'index.html')
def mainForm(request):

    # --------- personalDetails --------- #
    name = request.POST['txtName']
    firstSurname = request.POST['txtFirstSurname']
    secondSurname = request.POST['txtSecondSurname']

    # --------- TUPLES --------- #
    personalDetails = (name, firstSurname, secondSurname)
    citylist = (_("Madrid"), _("Barcelona"), _("Valencia"), _("Sevilla"), _("Zaragoza"), _("Málaga"), _("Murcia"), _("Palma de Mallorca"), _("Las Palmas de Gran Canaria"), _("Bilbao"), _("Alicante"), _("Córdoba"), _("Valladolid"), _("Vitoria"), _("La Coruña"), _("Granada"), _("Oviedo"), _("Santa Cruz de Tenerife"), _("Pamplona"), _("Almería"), _("San Sebastián"), _("Burgos"), _("Albacete"), _("Santander"), _("Castellón de la Plana"), _("Logroño"), _("Badajoz"), _("Salamanca"), _("Huelva"), _("Lérida"), _("Tarragona"), _("León"), _("Cádiz"), _("Jaén"), _("Orense"), _("Gerona"), _("Lugo"), _("Cáceres"), _("Melilla"), _("Guadalajara"), _("Toledo"), _("Ceuta"), _("Pontevedra"), _("Palencia"), _("Ciudad Real"), _("Zamora"), _("Ávila"), _("Cuenca"), _("Huesca"), _("Segovia"), _("Soria"), _("Teruel"))

    # --------- DICTIONARY --------- #
    context = {
        'personalDetails' : personalDetails,
        'citylist' : citylist
    }

    return render(request, 'mainForm.html', context)
def sendForm(request):

    # --------- personalDetails --------- #
    name = request.POST['txtName']
    firstSurname = request.POST['txtFirstSurname']
    secondSurname = request.POST['txtSecondSurname']

    # --------- poastaladdress --------- #
    address = request.POST['txtAddress']
    city = request.POST['slctCity']

    # --------- genderdetails --------- #
    gender = request.POST['chkGender']

    # --------- itdetails --------- #
    operatingSystem = request.POST.getlist('chkOS')
    comments = request.POST['txtComments']

    # --------- TUPLES --------- #
    personalDetails = (name, firstSurname, secondSurname)
    fullname = " ".join(personalDetails)

    os = ";".join(operatingSystem)

    createUser = (fullname, address, city, gender, os, comments)

    # --------- DATABASE CREATE --------- #
    entry_result = dbObject.createUser(createUser)

    context = {
        'entry_result' : entry_result,
    }

    return render(request, 'form_confirmation.html', context)
def viewTable(request):

    # --------- VIEW TABLE --------- #
    table = dbObject.viewTableData()

    context = {
        'entry_result': -1,
        'table' : table
    }
    return render(request, 'form_confirmation.html', context)

def deleteClient(request):

    # --------- DELETE CLIENT --------- #
    id = request.GET['id_user']
    table = dbObject.delete(id)

    context = {
        'entry_result': -1,
        'table' : table
    }
    return render(request, 'form_confirmation.html', context)