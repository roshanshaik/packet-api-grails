# packet-api-grails

This is a grails wrapper for the Packet Developer API

# Dependencies
grails 2.4.0
jdk 8

# How to run
cd packet-api-test
grails run-app

The above will run a embedded tomcat server at http://localhost:8080/packet-api-test

# To Create a Device
Goto Browser and type http://localhost:8080/packet-api-test/packetTest/createDevice

The response will be in JSON, note the deviceId

# To retrieve a Device
Goto Browser and type http://localhost:8080/packet-api-test/packetTest/getDevice/{deviceId}

The response will be in JSON

# To delete a Device
Goto Browser and type http://localhost:8080/packet-api-test/packetTest/deleteDevice/{deviceId}

The response will be in JSON

# To create an Organization
Goto Browser and type http://localhost:8080/packet-api-test/packetTest/createOrg

The response will be in JSON

