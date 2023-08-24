from django.db import models
import requests
from requests.exceptions import HTTPError

# Create your models here.
class Database():
    def __init__(self):
        self.apiurl = "https://api.tfl.gov.uk/Line/victoria/Route?serviceTypes=Regular"
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