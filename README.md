Content 

Kafka Avro Producer & Consumer


Quickstart

Before running the examples, we must launch Zookeeper, Kafka, and Schema Registry. In what follows, we assume that Zookeeper, Kafka, and Schema Registry are started with the default settings. See the Confluent Quickstart guide for detailed instructions.


# Start Kafka, in its own terminal.
$ systemcrl start confluent-server.service

# Start the Schema Registry, also in its own terminal.
systemcrl start confluent-schema-registry.service

# Create  topic
$ kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 \
                   --partitions 2 --topic topic_name

At this point Zookeeper, Kafka, and Schema Registry are up and running.

Now we can turn our attention to the client examples in this directory.

First run the example producer in the producer sub-folder to publish 10 data records to Kafka.

$ cd producer
# Build the producer app
$ mvn clean package
# Run the producer
$ mvn exec:java -Dexec.mainClass="io.confluent.examples.producer.ProducerExample" \
  -Dexec.args="10 http://localhost:8081"

Then run the Kafka consumer application in the consumer sub-folder to read the records we just published to the Kafka cluster, and to display the records in the console.

$ cd ../consumer
# Build the consumer app
$ mvn clean package
# Run the consumer
$ mvn exec:java -Dexec.mainClass="io.confluent.examples.consumer.ConsumerGroupExample" \
  -Dexec.args="localhost:2181 group page_visits 1 http://localhost:8081"
