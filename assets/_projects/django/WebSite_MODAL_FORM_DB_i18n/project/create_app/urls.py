from django.urls import path
from create_app import views

urlpatterns = [
    path('', views.index, name="index"),
    path('index', views.index, name="index"),
    path('mainForm', views.mainForm, name="mainForm"),
    path('sendForm', views.sendForm, name="sendForm"),
    path('viewTable', views.viewTable, name="viewTable"),
    path('deleteClient', views.deleteClient, name="deleteClient"),
]
