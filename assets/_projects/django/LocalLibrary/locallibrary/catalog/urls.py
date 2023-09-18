from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    # this view .asView() will actually be implemented as a class.
    # Inheriting from an existing generic view function
    # that already does most of what we want this view function to do,
    # rather than writing our own from scratch.
    path('books/', views.BookListView.as_view(), name='books'),
    path('book/<int:pk>', views.BookDetailView.as_view(), name='book-detail'),
    path('authors/', views.AuthorListView.as_view(), name='authors'),
    path('author/<int:pk>', views.AuthorDetailView.as_view(), name='author-detail'),

]