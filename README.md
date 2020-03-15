# Quarkus Conference

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your applications in dev mode that enables live coding using in every subproject module the next command:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `microservice-*-${project.version}-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar microservice-*/target/microservice-*-${project.version}-runner.jar`.

## Creating a native executable

Enter in every subproject module and you can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/microservice-*-${project.version}-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .