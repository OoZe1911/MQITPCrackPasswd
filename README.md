# MQITPCrackPasswd
MQITPCrackPasswd is a simple java program calling IBM MQITP libs to decode encrypted password which were encrypted via mqiptPW.

To compile MQITPCrackPasswd :
- javac -cp .:libs/com.ibm.mq.ipt.jar MQITPCrackPasswd.java

You can change the protection mode if needed :
- 0 : Use the deprecated password protection mode
- 1 : Use the IBM MQ 9.1.5 password protection mode for compatibility with versions earlier than IBM MQ 9.2.2. This is the default value in versions earlier than IBM MQ 9.2.2
- 2 : Use the latest password protection mode. This is the default value from IBM MQ 9.2.2

Usage :
```sh
java -cp .:libs/com.ibm.mq.ipt.jar MQITPCrackPasswd <protection mode> <filename of the file containing the encrypted password>
```
