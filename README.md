# Introduction

A hospital records management system (Manages patients records according to the department they fall under).

## About
* A total of 5 departments (Surgery, Paediatrics, Obstetrics&Gynaecology, Internal Medicine, Emergency) and a general registration point are generated.
Each of these departments and the general registration point have their service, JpaRepositry and Rest Controller implementations.

* Database was done using mysql, the file can be found in the src folder.

* Authentication and authorisation was implemented using JWT authentication. 

* Password encryption was implemented using bcrypt

## Prerequisites
* Java 17
* Maven
* Docker

## Technologies

* Java Springboot 3.3
* Spring security.
* Maven.
* JSON web tokens (JWT).
* BCrypt.



## Setup
Clone the repo
[https://github.com/EkeneU/PatientHospitalRecords.git]

Run the tests
`./mvnw clean test`

Build the application
`./mvnw clean build`

Start the application
`java -jar PatientHospitalRecords-0.0.1-SNAPSHOT.jar`

The application should start on port 8080

## Building the Docker Image
CD into the root directory of this module

Build a mysql image
`docker pull mysql`

Create a MySQL container 
`docker run -p 3307:3306 -d --name phr-db-cont -e MYSQL_ROOT_PASSWORD=Cristianocr7ronaldo! -e MYSQL_DATABASE=hospital_patient_management_records mysql`

Create a docker network
`docker network create phr-network`

Connect the MySQL container to the network
`docker network connect phr-network phr-db-cont`

Build the docker app image 
`docker build -t phr-app-image:1.0 .`

Create an app container then connect it to the docker network
` docker run -p 9090:8080 -d --name phr-app-cont --net phr-network -e MYSQL_HOST=phr-db-cont -e MYSQL_USER=root MYSQL_PASSWORD=Cristianocr7ronaldo! -e MYSQL_PORT=3306 phr-app-image:1.0`

App should run on port 9090


username = root
password = Cristianocr7ronaldo!

