CREATE TABLE IF NOT EXISTS General (
	patient_id INT AUTO_INCREMENT,
	firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    religion VARCHAR(100),
    occupation VARCHAR (100),
    marital_status VARCHAR (100),
    PRIMARY KEY (patient_id)
);

CREATE TABLE IF NOT EXISTS emergency (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    presenting_complaint TEXT NOT NULL,
    history_of_presenting_complaint TEXT NOT NULL,
    past_medical_history TEXT NOT NULL,
    past_surgical_history TEXT NOT NULL,
    clinical_examination TEXT NOT NULL,
    provisional_diagnosis TEXT NOT NULL,
    investigations TEXT NOT NULL,
	treatment TEXT NOT NULL,
    consult TEXT,
    patient_record_id INT
);

CREATE TABLE IF NOT EXISTS emergency_follow_up_notes (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    notes TEXT
);

-- Joins emergency table to the emergency followup notes table
SELECT e.patient_id,
 e.firstName, e.age, e.sex,
 e.provisional_diagnosis,
 efn.notes
 FROM emergency e
 INNER JOIN emergency_follow_up_notes efn
 WHERE e.patient_id = efn.patient_id;

CREATE TABLE IF NOT EXISTS surgery (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    presenting_complaint TEXT NOT NULL,
    history_of_presenting_complaint TEXT NOT NULL,
    past_medical_history TEXT NOT NULL,
    past_surgical_history TEXT NOT NULL,
    clinical_examination TEXT NOT NULL,
    provisional_diagnosis TEXT NOT NULL,
    investigations TEXT NOT NULL,
	treatment TEXT NOT NULL,
    consult TEXT
);

CREATE TABLE IF NOT EXISTS surgery_follow_up_notes (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    notes TEXT
);

-- Joins surgery table to its followup table
SELECT s.patient_id,
 s.firstName, s.age, s.sex,
 s.provisional_diagnosis,
 sfn.notes
 FROM surgery s
 INNER JOIN surgery_follow_up_notes sfn
 WHERE s.patient_id = sfn.patient_id;

CREATE TABLE IF NOT EXISTS internal_medicine (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    presenting_complaint TEXT NOT NULL,
    history_of_presenting_complaint TEXT NOT NULL,
    past_medical_history TEXT NOT NULL,
    past_surgical_history TEXT NOT NULL,
    clinical_examination TEXT NOT NULL,
    provisional_diagnosis TEXT NOT NULL,
    investigations TEXT NOT NULL,
	treatment TEXT NOT NULL,
    consult TEXT
);

CREATE TABLE IF NOT EXISTS internal_medicine_follow_up_notes (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    notes TEXT
);

SELECT im.patient_id,
 im.firstName, im.age, im.sex,
 im.provisional_diagnosis,
 imfn.notes
 FROM internal_medicine im
 INNER JOIN internal_medicine_follow_up_notes imfn
 WHERE im.patient_id = imfn.patient_id;

CREATE TABLE IF NOT EXISTS obstetrics_gynaecology (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    presenting_complaint TEXT NOT NULL,
    history_of_presenting_complaint TEXT NOT NULL,
    past_medical_history TEXT NOT NULL,
    past_surgical_history TEXT NOT NULL,
    clinical_examination TEXT NOT NULL,
    provisional_diagnosis TEXT NOT NULL,
    investigations TEXT NOT NULL,
	treatment TEXT NOT NULL,
    consult TEXT
);

CREATE TABLE IF NOT EXISTS obsandgynae_follow_up_notes (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    notes TEXT
);

SELECT o_g.patient_id,
 o_g.firstName, o_g.age, o_g.sex,
 o_g.provisional_diagnosis,
 o_gfn.notes
 FROM obstetrics_gynaecology o_g
 INNER JOIN obsandgynae_follow_up_notes o_gfn
 WHERE o_g.patient_id = o_gfn.patient_id;

CREATE TABLE IF NOT EXISTS paediatrics (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    informant VARCHAR (50) NOT NULL,
    presenting_complaint TEXT NOT NULL,
    history_of_presenting_complaint TEXT NOT NULL,
    past_medical_history TEXT NOT NULL,
    past_surgical_history TEXT NOT NULL,
    clinical_examination TEXT NOT NULL,
    provisional_diagnosis TEXT NOT NULL,
    investigations TEXT NOT NULL,
	treatment TEXT NOT NULL,
    consult TEXT
);
CREATE TABLE IF NOT EXISTS paediatric_emergency_follow_up_notes (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    notes TEXT
);

CREATE TABLE IF NOT EXISTS hospital (
	_id INT PRIMARY KEY AUTO_INCREMENT,
	referring_hospital_name VARCHAR(100) NOT NULL,
    destination_hospital_name VARCHAR(100)NOT NULL,
    ref_hosp_address VARCHAR(50) NOT NULL,
    referring_unit VARCHAR (100)
);

CREATE TABLE IF NOT EXISTS patient (
	id INT PRIMARY KEY AUTO_INCREMENT,
	patient_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    clinical VARCHAR(100) NOT NULL,
    _id INT NOT NULL,
    FOREIGN KEY (_id)
    REFERENCES hospital (_id)
    
);

CREATE TABLE IF NOT EXISTS hospital_user (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(100) NOT NULL DEFAULT 'Mr NoName',
last_name VARCHAR(100) NOT NULL DEFAULT 'Unknown',
email VARCHAR(100) UNIQUE NOT NULL,
user_password VARCHAR(100) NOT NULL,
hospital_role VARCHAR(100) NOT NULL DEFAULT 'Healthcare Worker'
);

SELECT o_g.patient_id,
 p.firstName, p.age, p.sex,
 p.provisional_diagnosis,
 pefn.notes
 FROM paediatrics p
 INNER JOIN paediatric_emergency_follow_up_notes pefn
 WHERE o_g.patient_id = o_gfn.patient_id;

-- Join "general" with "emergency"
SELECT general.patient_id,
 general.firstName, general.lastName,
 general.age, general.sex,
 e.presenting_complaint,
 e.history_of_presenting_complaint,
 e.past_medical_history,
 e.past_surgical_history,
 e.clinical_examination,
 e.provisional_diagnosis,
 e.investigations,
 e.treatment,
 e.patient_record_id,
 e.consult
 FROM General
 INNER JOIN emergency AS e
 WHERE 
 general.patient_id = e.patient_id;