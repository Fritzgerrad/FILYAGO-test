FROM openjdk:18-alpine
MAINTAINER OCHIE SAMUEL CHIDERA "samuel.ochie@frzgroup.filyago.com"
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
