from django.urls import path, include
from crud_i18n import views

urlpatterns = [
    path('', views.index, name='name'),
    path('crudOperations', views.crudOperations, name='crudOperations'),
]
