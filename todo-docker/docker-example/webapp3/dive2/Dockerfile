FROM ubuntu:14.04

RUN apt-get update && \
    apt-get install apache2 -y -qq --no-install-recommends && \

WORKDIR /var/www/html

ADD index.html .

EXPOSE 80

CMD apachectl -D FOREGROUND
