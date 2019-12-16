mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create -DprojectGroupId=org.acme.conference -DprojectArtifactId=microservice-vote -Dextensions="resteasy-jsonb" -DclassName="org.acme.conference.vote.VoteResource" -DoutputDirectory=. 


[Running mongodb database](https://quarkus.io/guides/mongodb#running-a-mongodb-database)

podman  run -ti --rm -p 27017:27017 mongo:4.0