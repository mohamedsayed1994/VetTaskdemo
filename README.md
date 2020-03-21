# VetTaskdemo
small Task

Consider that we’re implementing a Vet Clinic System, defined below are system entities:

-Pet and it has fields (name, gender, date of birth, animal kind and weight).
-Owner (pet owner) and it has fields (name, email, phone, gender and address).
-Clinic and it has fields (name, address, phone, working days and hours, email and social networks URLs).
-Doctor and it has fields (name, phone and bio).
-Visit and it has fields (pet, doctor, clinic and date)

Each owner may have multiple pets and each doctor works for only one clinic.
An owner could post a clinic visit to a clinic and he could choose a specific doctor.
Using MVC design pattern, implement the above system using Spring Framework (MVC or Boot) 
and Hibernate (using annotations) and provide REST APIs for the below:

1.	Creating entities. 
2.	Getting above entities by id. 
3.	List all owner’s pets by owner id. 
4.	List all clinic’s doctors by clinic id.
5.	Search for clinics by phone number or address.
6.	Assign/de-assign doctor to clinic.

Also perform all necessary validations for above all of entities fields taking into consideration DB unique constraints. 
You may use any IDE (although IntelliJ IDEA is preferred).
