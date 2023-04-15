# 5500-yihu-yitianhuang-ziweiwang

## Server Deployment

1. Update field `spring.datasource.url` in file `application.properties` in Spring boot project.  
   This project uses AWS RDS PostgreSQL database as the datasource, so the `spring.datasource.url` could be found on AWS console.
2. Already configured AWS RDS PostgreSQL instance allowing inbound from `172.31.0.0./16`. So every time deploy the server, just do:
   1. update the datasource url
   2. `mvn package`
   3. upload `.jar` into AWS EC2 instance and run it using `java -jar XXX.jar`
      Then the server should be available through "http://{IP}:8080/rank/activity/calories"
