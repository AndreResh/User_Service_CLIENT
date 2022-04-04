# User Service CLIENT
Client microservice

Instruction to run application:
1) `git clone https://github.com/AndreResh/User_Service_CLIENT.git`
2) open downloaded file
3) `docker-compose run -d` 

Body of person with role - USER:
{
    "username":"user@yandex.ru",
    "password":"user"
}

Body of person with role - ADMIN:
{
    "username":"admin@yandex.ru",
    "password":"admin"
}

Endpoints:
- GET /api/client - to get list of users from second microservice
- 
Link for second microservice: https://github.com/AndreResh/User_Service_MAIN