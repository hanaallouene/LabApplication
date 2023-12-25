FROM openjdk:8
COPY --from=build /opt/app/target/*.jar  RegistryServer.jar
ENTRYPOINT ["java", "-jar","RegistryServer.jar"]
EXPOSE 8080