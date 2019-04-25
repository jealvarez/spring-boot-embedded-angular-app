# **Spring Application using Angular as Markup Templating**

Basic example of how to use *spring* with *angular* as a markup templating

## **Prerequisites**

* Java 8
* MySQL 5.7
* Angular 7
* NodeJs
* Npm

## **Setup**

* Just for the first time, execute  

```sh
mysql -u root -p -h 127.0.0.1 < scripts/sql/init.sql
```

* Build the application

```sh
gradle clean
gradle build
```

* Run the application

```sh
java -jar build/libs/spring-angular-app-0.0.1-SNAPSHOT.jar
```

* Finally, [test it!](http://127.0.0.1:8080)
