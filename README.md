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

## Available Endpoints

* Security
 * POST - http://localhost:8080/hospitalsecurity/api/auth/register (To register a user to get a token)
 * POST - http://localhost:8080/hospitalsecurity/api/auth/authenticate (To authenticate the user token)

* General
  * GET - http://localhost:8080/phr/general_patients
  * GET - http://localhost:8080/phr/general_patients/{patient_id}
  * POST - http://localhost:8080/phr/general_patient
  * DELETE - http://localhost:8080/phr/general_patient/{patient_id}
 
* Emergency
  * GET - http://localhost:8080/phr/emergency_patients
  * GET - http://localhost:8080/phr/emergency_patients/{patient_id}
  * POST - http://localhost:8080/phr/emergency_patient
  * PUT - http://localhost:8080/phr/emergency_patient
  * DELETE - http://localhost:8080/phr/emergency_patient/{patient_id}

* Emergency follow up
  * GET - http://localhost:8080/phr/efun_patients
  * GET - http://localhost:8080/phr/efun_patients/{patient_id}
  * POST - http://localhost:8080/phr/efun_patient
  * PUT - http://localhost:8080/phr/efun_patient
  * DELETE - http://localhost:8080/phr/efun_patient/{patient_id}
 
* Internal Medicine
  * GET - http://localhost:8080/phr/im_patients
  * GET - http://localhost:8080/phr/im_patients/{patient_id}
  * POST - http://localhost:8080/phr/im_patient
  * PUT - http://localhost:8080/phr/im_patient
  * DELETE - http://localhost:8080/phr/im_patient/{patient_id}
 
* Internal Medicine follow up
  * GET - http://localhost:8080/phr/imfun_patients
  * GET - http://localhost:8080/phr/imfun_patients/{patient_id}
  * POST - http://localhost:8080/phr/imfun_patient
  * PUT - http://localhost:8080/phr/imfun_patient
  * DELETE - http://localhost:8080/phr/imfun_patient/{patient_id}
 
* Obstetrics & Gynaecology
  * GET - http://localhost:8080/phr/obsgynae_patients
  * GET - http://localhost:8080/phr/obsgynae_patients/{patient_id}
  * POST - http://localhost:8080/phr/obsgynae_patient
  * PUT - http://localhost:8080/phr/obsgynae_patient
  * DELETE - http://localhost:8080/phr/obsgynae_patient/{patient_id}
 
* Obstetrics & Gynaecology follow up
  * GET - http://localhost:8080/phr/ogfun_patients
  * GET - http://localhost:8080/phr/ogfun_patients/{patient_id}
  * POST - http://localhost:8080/phr/ogfun_patient
  * PUT - http://localhost:8080/phr/ogfun_patient
  * DELETE - http://localhost:8080/phr/ogfun_patient/{patient_id}
 
* Paediatrics
  * GET - http://localhost:8080/phr/paediatrics_patients
  * GET - http://localhost:8080/phr/paediatrics_patients/{patient_id}
  * POST - http://localhost:8080/phr/paediatrics_patient
  * PUT - http://localhost:8080/phr/paediatrics_patient
  * DELETE - http://localhost:8080/phr/paediatrics_patient/{patient_id}
 
* Paediatrics follow up
  * GET - http://localhost:8080/phr/pfun_patients
  * GET - http://localhost:8080/phr/pfun_patients/{patient_id}
  * POST - http://localhost:8080/phr/pfun_patient
  * PUT - http://localhost:8080/phr/pfun_patient
  * DELETE - http://localhost:8080/phr/pfun_patient/{patient_id}
 
* Surgery
  * GET - http://localhost:8080/phr/surgery_patients
  * GET - http://localhost:8080/phr/surgery_patients/{patient_id}
  * POST - http://localhost:8080/phr/surgery_patient
  * PUT - http://localhost:8080/phr/surgery_patient
  * DELETE - http://localhost:8080/phr/surgery_patient/{patient_id}
 
* Surgery follow up
  * GET - http://localhost:8080/phr/sfun_patients
  * GET - http://localhost:8080/phr/sfun_patients/{patient_id}
  * POST - http://localhost:8080/phr/sfun_patient
  * PUT - http://localhost:8080/phr/sfun_patient
  * DELETE - http://localhost:8080/phr/sfun_patient/{patient_id}
 
  

