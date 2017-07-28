Config Toggle Server 

The main goal of this project is to demonstrate how can we implement
a Toggle Feature Centralized Config server having as requirement:

* Scalability
* Security
* Efficiency
* Redundancy
* Automatic updating

There are many approaches to consider, I will start with number 1.
Later i will try to explore other options  

1. Using Kafka as Broker to notify client services


* - Whenever a service is initialized the ToggleClientRepository will be synchronized
* - A new thread with kafka consumer will be lauched in background.
* - Always a toggle config is updated, the toggle config will be posted at kakfa topic
* - Whenever a new event is posted at kafka topic, the toggle values will be processed again for the consumers

toggle-config-server is the service to manage all the toggle definition
	Kafka Producer
	
toggle-config-client
	Toggle Interfaces 
	Relative URI
	Data Transfer Objects
	Represents the contract between server-toggle services and client services using it 
	
toggle-utils is a library, that provides Client repository Management:
	Rest API client 
	Kafka Consumer
	
orders-service and product-service are  test services who have a Toggle (APPLY_TAXES) dependency

postman folder has some request

To test:

Pre-requirements
Kakfa and Zookeeper are needed

To test we need:
* - Start Zookeper (sh bin/zookeeper-server-start.sh config/zookeeper.properties &)
* - Start Kafka (sh bin/kafka-server-start.sh config/server.properties &)
* - Create Topic (bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic toggle-config-general)
* - launch toggle-config-server java -jar /toggle-config-server-0.0.1-SNAPSHOT.jar --server.port=8054 &
* - launch order services	   java -jar orders-service-0.0.1-SNAPSHOT.jar --server.port=8053 &
* - launch product services   java -jar products-service-0.0.1-SNAPSHOT.jar --server.port=8053 &

If the kafka ports are needed to be reconfigures, we can pass as argument --kafka.port=???

2. Using Spring Cloud Framework (Git Repository)


3. Using Webhook


4. Using Websockets








