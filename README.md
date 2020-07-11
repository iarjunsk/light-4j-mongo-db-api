# Swagger Light Java Server

## Start server (with jar)
```
cd target
java -jar goswift-1.0-SNAPSHOT.jar
```
## Start server (with mvn)
```
mvn package exec:java
```

## Endpoints
1. HTTP or HTTP endpoint (enable in server.yml)
```
https://localhost:8443/v1/pets 
http://localhost:8080/v1/pets
```

2. Health Check (1.5x)
https://localhost:8443/health/com.arjunsk.goswift-1.0-SNAPSHOT

3. OAS3 (1.5x)
https://localhost:8443/spec.yaml

4. Swagger UI (1.5x)
https://localhost:8443/specui.html

5. Info (1.5x)
https://localhost:8443/server/info


## Done
1. Connected to Mongo and retrieved data.
2. Ran with proper logging config.
3. Implemented all the endpoint.

## TODO
1. Error handling
2. Running in debug mode
3. Upgrade to 1.6x
4. Dynamic Content Loading using Json Placeholder