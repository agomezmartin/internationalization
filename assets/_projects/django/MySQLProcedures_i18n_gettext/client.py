from connection import Database
import gettext as gt

dbObject = Database()
en = gt.translation('client', localedir='locales', languages=['en'])
es = gt.translation('client', localedir='locales', languages=['es'])
languages = [en, es]

def selectLanguage():
    print("===================")
    print("1. English")
    print("2. Spanish")
    lang = 0

    try:
        lang = int(input("Please, select a language: "))
        return lang

    except ValueError as e:
        print("===================")
        print("Select either 1 or 2")
        selectLanguage()

def createDept():
    deptno = int(input(_("Please, insert department number: ")))
    deptname = input(_("Please, insert department name: "))
    deptloc = input(_("Please, insert department location: "))

    args = [deptno, deptname, deptloc]

    if dbObject.create(args) > 0:
        print("===============================")
        print("Department created succesfully.")
        print("===============================")
    else:
        print("===============================")
        print("Try again.")
        print("===============================")
        createDept()

lang = selectLanguage()-1

try:
    languages[lang].install()
except IndexError:
    print("===================")
    print("Select either 1 or 2")
    print("===================")
    selectLanguage()

_ = languages[lang].gettext

createDept()