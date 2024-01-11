# Java Kafka Producer and Consumer Example

This is a Java application that demonstrates how to produce and consume messages using Confluent's Apache Kafka with Schema Registry. The project is built with Java 17 and managed with Maven 3.8.

## Prerequisites

Before running the code, make sure you have the following software installed:

- Java 17: You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or use a distribution like [OpenJDK](https://adoptopenjdk.net/).

- Apache Maven 3.8: You can download it from the [Maven website](https://maven.apache.org/download.cgi).

## Setup

1. Clone this repository to your local machine:

   ```bash
   git clone git@git.epam.com:vasilisa_marachkouskaya/java-advanced-backend.git -b <branch>

2. ```bash
   mvn clean install
   ```
   Repeat this step in case you are receiving "demo.kafka.event.PaymentSent not found ..."

3. Run Spring boot application
4. In Postman send POST request to http://localhost:9002/v1/payments/send.

   Body sample:
```
{
   "paymentId": "789-1115",
   "amount": 340.00,
   "currency": "USD",
   "toAccount": "Harry",
   "fromAccount": "Vasilisa"
   }
```
5. Observe console logs
6. To register new schema version update /resources/avro/payment_sent.avsc with new fields and increment the version.
Then update SendPaymentRequest class accordingly. Then run
   ```bash
   mvn schema-registry:register
   ```
   Then send POST request with updated body.

