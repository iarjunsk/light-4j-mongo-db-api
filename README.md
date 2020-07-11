# Swagger Light Java Server

## Start server (with jar)
```
cd target
java -jar goswift-1.0-SNAPSHOT.jar
```
## Start server (with mvn)
```
mvn clean install exec:java
```

## Test server
1. Endpoint
https://localhost:8443/v1/pets 

2. Health Check
https://localhost:8443/health/com.arjunsk.goswift-1.0-SNAPSHOT

3. OAS3 
https://localhost:8443/spec.yaml

4. Swagger UI
https://localhost:8443/specui.html

5. Info
https://localhost:8443/server/info