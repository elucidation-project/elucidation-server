FROM openjdk:11-jre-slim
EXPOSE 8080 8081
COPY elucidation.jar /service/
COPY config.yml /service
RUN java -jar /service/elucidation.jar db migrate /service/config.yml
CMD java -jar /service/elucidation.jar server /service/config.yml
