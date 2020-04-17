# ============================================================================
#!/usr/bin/python3
# Name: sqliteEx.py
# ============================================================================

# ----------------------------------------------------------------------------
# IMPORT MODULES
# ----------------------------------------------------------------------------

import sqlite3

# ----------------------------------------------------------------------------
# CREATE A DATABASE 
# ----------------------------------------------------------------------------

sqlPathDB = "C:\pythonExamples\SQLite\pySQLite.db"

sqlConnect = sqlite3.connect(sqlPathDB)

# ----------------------------------------------------------------------------
# CONNECT TO A DATABASE 
# ----------------------------------------------------------------------------

sqlCursor = sqlConnect.cursor()

# ----------------------------------------------------------------------------
# CREATE A TABLE 
# ----------------------------------------------------------------------------

sqlTableName = "stocks"

sqlTableColumns = "id int PRIMARY KEY, " + \
                  "date varchar(10), "   + \
                  "trans varchar(4), "   + \
                  "symbol varchar(4), "  + \
                  "qty real, "           + \
                  "price real"

sqlDropTable = "DROP TABLE IF EXISTS " + sqlTableName

sqlCursor.execute(sqlDropTable)

sqlCreateTable = "CREATE TABLE " + \
                 sqlTableName    + \
                 "("             + \
                 sqlTableColumns + \
                 ")"

sqlCursor.execute(sqlCreateTable)

# ----------------------------------------------------------------------------
# CREATE AN INDEX 
# ----------------------------------------------------------------------------

sqlIndexName = "index_stoks_price" 

sqlIndexColumns = "stocks(price)"

sqlCreateIndex = "CREATE INDEX " + \
                 sqlIndexName    + \
                 " ON "          + \
                 sqlIndexColumns

sqlCursor.execute(sqlCreateIndex)

# ----------------------------------------------------------------------------
# INSERT ROWS IN A TABLE 
# ----------------------------------------------------------------------------

sqlDataRows = [ (1, '2006-01-05', 'BUY', 'RHAT', 100, 35.14), 
 		(2, '2006-03-28', 'BUY', 'IBC', 1000, 45.00),               
		(3, '2006-04-05', 'BUY', 'MSFT', 300, 72.00),               
		(4, '2006-04-06', 'SELL', 'IBC', 500, 53.00),               
		(5, '2006-05-06', 'BUY', 'MSFT', 600, 51.00),               
		(6, '2006-05-09', 'SELL', 'SUM', 150, 13.00),               
		(7, '2006-06-12', 'SELL', 'SUM', 200, 73.00),               
		(8, '2006-06-21', 'SELL', 'RHAT', 1500, 25.00)
    ]

sqlValues = "(?,?,?,?,?,?)" 

sqlInsertInto = "INSERT INTO " + \
                sqlTableName   + \
                " VALUES "     + \
                sqlValues

sqlCursor.executemany(sqlInsertInto, sqlDataRows)

# ----------------------------------------------------------------------------
# COMMIT ALL CHANGES 
# ----------------------------------------------------------------------------

sqlConnect.commit()

# ----------------------------------------------------------------------------
# SELECT ROWS 
# ----------------------------------------------------------------------------

sqlWhere = "symbol = 'RHAT'"

sqlOrderBy = "price"

sqlSelectFrom = "SELECT * FROM " + \
                sqlTableName     + \
                " WHERE "        + \
                sqlWhere         + \
                " ORDER BY "     + \
                sqlOrderBy

print ('\n---------------------------------------------------------')

for sqlRow in sqlCursor.execute(sqlSelectFrom):
    print (sqlRow)

print ('---------------------------------------------------------')

# ----------------------------------------------------------------------------
# CLOSE CONNECTION
# ----------------------------------------------------------------------------

sqlCursor.close()

# ----------------------------------------------------------------------------
# END PROGRAM
# ----------------------------------------------------------------------------

