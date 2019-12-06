# microservices-kafka-shop-app
This Microservices application is intended to demonstrate how to design and develop an event-based loosely coupled application with the devonfw framework. Unlike monolithic applications, the overall system consists of several smaller microservices and not just one executable file. Individual microservices communicate loosely coupled via Apache Kafka. 

In order to better understand the project, the difference between monolithic architecture and microservice architecture has to be understood.

## Microservices and Monoliths ##
With monolithic architecture, the entire application consists of one executable file which belongs to a single application. Thus one monolith includes all components required for the operation of the software. Microservices are nothing more than the dismantling of a monolith into small independent services.
