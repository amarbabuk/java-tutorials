# Getting Started

### Open API (Swagger)
- http://localhost:8080/v2/api-docs
- http://localhost:8080/swagger-ui-custom.html

see https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-springdoc

### Redis
- windows installer - https://github.com/MicrosoftArchive/redis/releases/download/win-3.0.504/Redis-x64-3.0.504.msi

#### redis spring cache
- https://www.baeldung.com/spring-cache-tutorial

#### redis commands
redis-server - start redis server
redis-cli - cli
redis-cli monitor - monitor server

#### redis queries
- https://redis.io/commands/keys
- keys *users*
- keys users::11

#### run spring boot app with maven
- mvn  spring-boot:run -Dspring-boot.run.arguments=--server.port=9090