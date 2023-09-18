from django.shortcuts import render
import gettext as gt
from .models import Book, Author, BookInstance, Genre
from django.views import generic

_ = gt.gettext

# Create your views here.

# Standard function view
def index(request):
    """View function for home page of site."""

    # Generate counts of some of the main objects
    num_books = Book.objects.all().count()
    num_instances = BookInstance.objects.all().count()

    # Available books (status = 'a')
    num_instances_available = BookInstance.objects.filter(status__exact='a').count()

    # The 'all()' is implied by default.
    num_authors = Author.objects.count()

    # Genres that contain a particular word (case sensitive)
    genres_search = Genre.objects.filter(name__exact='Novel').count()

    # Books that contain a particular word (case sensitive)
    books_search = Book.objects.filter(title__contains='a').count()

    context = {
        'num_books': num_books,
        'num_instances': num_instances,
        'num_instances_available': num_instances_available,
        'num_authors': num_authors,
        'genres_search': genres_search,
        'books_search' : books_search
    }

    # Render the HTML template index.html with the data in the context variable
    return render(request, 'index.html', context#=context
    )

# View (class-based)
# a class-based generic list view (ListView) — a class that inherits from an existing view.
# Because the generic view already implements most of the functionality we need and follows Django best-practice,
# we will be able to create a more robust list view with less code, less repetition,
# and ultimately less maintenance.
#
# The generic view will
# - query the database to get all records for the specified model (Book)
# - then render a template located at /locallibrary/catalog/templates/catalog/book_list.html (which we will create below).
#
# Within the template you can access the list of books with the template variable named object_list OR book_list (i.e. generically "<the model name>_list").
class BookListView(generic.ListView):
    model = Book

class AuthorListView(generic.ListView):
    model = Author

class BookDetailView(generic.DetailView):
    model = Book

class AuthorDetailView(generic.DetailView):
    model = Author