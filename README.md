PORT DETAILES OF THE APPLICATION:
---------------------------------

LOGIN-SERVER     : http://localhost:8081 ,
EMPLOYEE-SERVER  : http://localhost:8082 ,
ADMIN-SERVER     : http://localhost:8083 ,
API-GATWAY       : http://localhost:9191 ,
SERVICE-REGISTRY : http://localhost:8761    (EUREKA) ,
CONFIG-SERVER    : http://localhost:8888    (GIT) ,


STEPS TO RUN THE APPLICTION:
----------------------------

STEP 1: Create Database

        USER-NAME   : root,
        PASSWORD    : root,
        SCHEMA NAME : boot


STEP 2: RUN ALL THE SERVER ONE BY ONE 

        1. CONFIG-SERVER,
        2. SERVICE-REGISTRY,
        3. API-GATEWAY,
        4. LOGIN-SERVER,
        5. EMPLOY-SERVER,
        6. ADMIN-SERVER.

step 3: HIT THE API IN BROWSER

        LANDING PAGE  : http://localhost:9191/                          (REGISTRATION)
                      : http://localhost:9191/register                  (REGISTRATION)

        LOGIN PAGE    : http://localhost:9191/login                     (LOGIN)

        ADMIN PAGE    : http://localhost:9191/admin                     (ADMIN)

        EMPLOYEE PAGE : http://localhost:9191/employee                  (EMPLOYEE)

        TECHICAL-FORM : http://localhost:9191/employee/register_tech    (TECHNICAL REGISTRATION)
        BEHAVOUR-FORM : http://localhost:9191/employee/register_beh     (BEHAVIOUR REGISTRATION)


