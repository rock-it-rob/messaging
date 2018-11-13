FROM openjdk:8-alpine

ARG app_version

RUN apk add --no-cache curl

COPY health-check.sh /
RUN chmod 755 /health-check.sh

HEALTHCHECK --start-period=5s --timeout=2s CMD /health-check.sh

COPY ./target/messaging-web-${app_version}.jar /
RUN ln -s /messaging-web-${app_version}.jar /messaging-web.jar

CMD [ "java", "-jar", "/messaging-web.jar" ]