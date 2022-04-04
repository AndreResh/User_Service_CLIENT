# User Service CLIENT
Client microservice

Instruction to run application:
1) `git clone https://github.com/AndreResh/User_Service_CLIENT.git`
2) open downloaded file
3) `docker-compose run -d` 

Endpoints:
- GET /api/client - to get list of users from second microservice 
    
  - Body of person without authorities to this endpoint:
    {
         "username":"user@yandex.ru",
         "password":"user"
    }
  - Body of person with authorities to this endpoint:
    {
         "username":"admin@yandex.ru",
         "password":"admin"
    }


Link for second microservice: https://github.com/AndreResh/User_Servic