# PreRequirement
this is a simple helloworld project needed for course entrance competition, written with springboot in order to ease the deployment. 
it uses Spring web and Spring Data and provides 2 simple GET API to be called. one returns "Hello World" sentence and the other takes your name and if it has your name in it's database says welcome back else will add you as a new person and thank you for visiting. in case of calling the later without parameter it will identify and welcome you as a stranger. 

# how to use?
clone it and run usig the IDE of your choice then you can make API calls. I'll leave a sample below.
curl --location 'localhost:8080/pws/greeting?name=david'
curl --location 'localhost:8080/pws/helloworld'

