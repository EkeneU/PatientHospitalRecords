# Introduction

A hospital records management system (Manages patients records according to the department they fall under).

## About
A total of 5 departments (Surgery, Paediatrics, Obstetrics&Gynaecology, Internal Medicine, Emergency) and a general registration point are generated.
Each of these departments and the general registration point have their service, JpaRepositry and Rest Controller implementations.

Database was done using mysql, the file can be found in the src folder.

Basic security was removed during development as it was interferring was POST request implementation.

## Prerequisites
Java 17
Maven
Docker


## Setup
Clone the repo
[https://github.com/EkeneU/PatientHospitalRecords.git]

Run the tests
`./mvnw clean test`

Build the application
`./mvnw clean build`

Start the application
`java -jar PatientHospitalRecords-0.0.1-SNAPSHOT.jar`

The applicatio should start on port 8080

## Building the Docker Image
CD into the root directory of this module

Build a mysql image
docker pull mysql




username = root
password = Cristianocr7ronaldo!

