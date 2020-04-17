# -*- coding: utf-8 -*-

"""

SIMPLE FLASK REST PYTHON APPLICATION:
gamesys.py

Directory Path Project: 
C:\pythonExamples\FLASK\ 

Run application:
cd  C:\pythonExamples\FLASK
python gamesys.py

Application URL Examples:
http://127.0.0.1:5002/REVENUE_ANALYSIS/1001
http://127.0.0.1:5002/REVENUE_ANALYSIS/1001/201701
http://127.0.0.1:5002/REVENUE_ANALYSIS/1001/201701/1320

"""
# -----------------------------------------------------------------------------
# IMPORT Modules
# -----------------------------------------------------------------------------
from flask import Flask, request
from flask_restful import Resource, Api
from sqlalchemy import create_engine
from json import dumps
from flask import jsonify

import sqlite3

# -----------------------------------------------------------------------------
# CONNECT SQLite 
# -----------------------------------------------------------------------------
db_connect = create_engine('sqlite:///gamesys.db')
app = Flask(__name__)
api = Api(app)

# -----------------------------------------------------------------------------
# ROUTE 1: Search MEMBER_ID data
# -----------------------------------------------------------------------------
class Revenue_Member(Resource):
    def get(self, member_input):
        
        conn = db_connect.connect()
        
        query = conn.execute('SELECT MEMBER_ID, \
                             ROUND(SUM(WIN_AMOUNT), 2) AS TOTAL_WIN_AMOUNT, \
                             ROUND(SUM(WAGER_AMOUNT), 2) AS TOTAL_WAGER_AMOUNT, \
                             SUM(NUMBER_OF_WAGERS) AS NUMBER_OF_WAGERS \
                             FROM REVENUE_ANALYSIS \
                             WHERE MEMBER_ID = ?', \
                             (member_input))

        result = {'data': [dict(zip(tuple (query.keys()) ,i)) for i in query.cursor]}
        
        return jsonify(result)

# -----------------------------------------------------------------------------
# ROUTE 2: Search MEMBER_ID + ACTIVITY_YEAR_MONTH data
# -----------------------------------------------------------------------------
class Revenue_Member_Month(Resource):
    def get(self, member_input, month_par):
        
        conn = db_connect.connect()
                 
        query = conn.execute('SELECT MEMBER_ID, \
                             ACTIVITY_YEAR_MONTH, \
                             ROUND(SUM(WIN_AMOUNT), 2) AS TOTAL_WIN_AMOUNT, \
                             ROUND(SUM(WAGER_AMOUNT), 2) AS TOTAL_WAGER_AMOUNT, \
                             SUM(NUMBER_OF_WAGERS)  AS NUMBER_OF_WAGERS \
                             FROM REVENUE_ANALYSIS \
                             WHERE MEMBER_ID = ? \
                             AND ACTIVITY_YEAR_MONTH = ?', \
                             (member_input, month_par))
        
        result = {'data': [dict(zip(tuple (query.keys()) ,i)) for i in query.cursor]}
          
        return jsonify(result)

# -----------------------------------------------------------------------------
# ROUTE 3: Search MEMBER_ID + ACTIVITY_YEAR_MONTH + GAME_ID data
# -----------------------------------------------------------------------------
class Revenue_Member_Game(Resource):
    def get(self, member_input, month_par, game_par):
        
        conn = db_connect.connect()
                 
        query = conn.execute('SELECT MEMBER_ID, \
                             ACTIVITY_YEAR_MONTH, \
                             GAME_ID, \
                             ROUND(SUM(WIN_AMOUNT),2) AS TOTAL_WIN_AMOUNT, \
                             ROUND(SUM(WAGER_AMOUNT), 2) AS TOTAL_WAGER_AMOUNT, \
                             SUM(NUMBER_OF_WAGERS)  AS NUMBER_OF_WAGERS \
                             FROM REVENUE_ANALYSIS \
                             WHERE MEMBER_ID = ? \
                             AND ACTIVITY_YEAR_MONTH = ? \
                             AND GAME_ID = ?',
                             (member_input, month_par, game_par))
        
        result = {'data': [dict(zip(tuple (query.keys()) ,i)) for i in query.cursor]}
        
        return jsonify(result)

# -----------------------------------------------------------------------------
# ADD API RESOURCES
# -----------------------------------------------------------------------------
api.add_resource(Revenue_Member, '/REVENUE_ANALYSIS/<member_input>') # Route_1
api.add_resource(Revenue_Member_Month, '/REVENUE_ANALYSIS/<member_input>/<month_par>') # Route 2
api.add_resource(Revenue_Member_Game, '/REVENUE_ANALYSIS/<member_input>/<month_par>/<game_par>') # Route 3

# -----------------------------------------------------------------------------
# RUN FLASK APPLICATION 
# -----------------------------------------------------------------------------
if __name__ == '__main__':
     app.run(port='5002')
