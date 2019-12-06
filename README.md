# microservices-kafka-shop-app
This Microservices application is intended to demonstrate how to design and develop an event-based loosely coupled application with the devonfw framework. Unlike monolithic applications, the overall system consists of several smaller microservices and not just one executable file. Individual microservices communicate loosely coupled via Apache Kafka. 

In order to better understand the project, the difference between monolithic architecture and microservice architecture has to be understood.

## Microservices and Monoliths ##
With monolithic architecture, the entire application consists of one executable file which belongs to a single application. Thus one monolith includes all components required for the operation of the software. Microservices are nothing more than the dismantling of a monolith into small independent services.

## Kafka Module ##

### Message Sender ###
The Kafka module for devon4j serves the publication of news to Kafka. The method sendMessage(T message, String topic, String key, String partition) takes as parameter a message of any type, a topic, and optionally a key and a partition. The message will be converted by the message converter. The MessageBuilder creates a message with the required Headers, which are passed via the parameters of the function. These message is passed to the createAndSendRecord(Message message) method. Using kafkaTemplate, the message is sent asynchronously to Kafka.

### Retry Pattern ###
For various reasons, it is possible to use the following functions when processing messages lead to mistakes by the consumer. Often, either a service is not available or the message format was selected incorrectly. Therefore
a Retry Pattern for handling errors was created for this problem. In the following, the Retry Pattern from Fig. 4.6 is explained.

1. The application receives a message from a Topic
2. an error occurs during the processing of the message, the message is sent to a re-delivery topic
3. on successful delivery of the message, in this Topic confirmed.
4. the message is removed from the delivery list with a certain delay.Topic processed.
5 The processing of the message failed again. The message is persisted in a dead letter database.
6. the message from the re-delivery topic is confirmed.
7. messages in the dead letter database have to be confirmed by an administrator. can be processed manually. The message is then either with the message that is in the undeliverable topic
merged or deleted.
