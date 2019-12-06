# microservices-kafka-shop-app
This Microservices application is intended to demonstrate how to design and develop an event-based loosely coupled application with the devonfw framework. Unlike monolithic applications, the overall system consists of several smaller microservices and not just one executable file. Individual microservices communicate loosely coupled via Apache Kafka. 

In order to better understand the project, the difference between monolithic architecture and microservice architecture has to be understood.

## Microservices and Monoliths ##
With monolithic architecture, the entire application consists of one executable file which belongs to a single application. Thus one monolith includes all components required for the operation of the software. Microservices are nothing more than the dismantling of a monolith into small independent services.

## Kafka Module ##

### Message Sender ###
The Kafka module for devon4j serves the publication of news to Kafka. The method sendMessage(T message, String topic, String key, String partition) takes as parameter a message of any type, a topic, and optionally a key and a partition. The message will be converted by the message converter. The MessageBuilder creates a message with the required Headers, which are passed via the parameters of the function. These message is passed to the createAndSendRecord(Message message) method. Using kafkaTemplate, the message is sent asynchronously to Kafka.
