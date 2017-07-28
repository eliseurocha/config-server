h1. Config Toggle Server 

The main goal of this project is to demonstrate how can we implement
a Toggle Feature Centralized Config server having as requirement:

* Scalability
* Security
* Efficiency
* Redundancy
* Automatic updating

There are many approaches to consider, I will start with number 1.
Later i will try to explore other options  


h2. 1. Using Kafka as Broker to notify client services


1 - Whenever a service is initialized the ToggleClientRepository will be synchronized
2 - A new thread with kafka consumer will be lauched in background.
3 - Always a toggle config is updated, the toggle config will be posted at kakfa topic
4 - Whenever a new event is posted at kafka topic, the toggle values will be processed again for the consumers

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
1 - Start Zookeper (sh bin/zookeeper-server-start.sh config/zookeeper.properties &)
2 - Start Kafka (sh bin/kafka-server-start.sh config/server.properties &)
3 - Create Topic (bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic toggle-config-general)
4 - launch toggle-config-server java -jar /toggle-config-server-0.0.1-SNAPSHOT.jar --server.port=8054 &
5 - launch order services	   java -jar orders-service-0.0.1-SNAPSHOT.jar --server.port=8053 &
6 - launch product services   java -jar products-service-0.0.1-SNAPSHOT.jar --server.port=8053 &

If the kafka ports are needed to be reconfigures, we can pass as argument --kafka.port=???


h2. 2. Using Spring Cloud Framework (Git Repository)


h2. 3. Using Webhook


h2. 4. Using Websockets








