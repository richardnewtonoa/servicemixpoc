FROM ubuntu:20.04

WORKDIR /tmp

RUN mkdir /servicemix \
 && apt-get update -y \
 && apt-get install -y unzip wget openjdk-8-jdk-headless \
 && wget --no-check-certificate -O servicemix.zip https://mirrors.ukfast.co.uk/sites/ftp.apache.org/servicemix/servicemix-7/7.0.1/apache-servicemix-7.0.1.zip \
 && unzip servicemix.zip -d /servicemix \
 && rm servicemix.zip

WORKDIR /servicemix/apache-servicemix-7.0.1

# root SSH port
EXPOSE 8101

ENTRYPOINT ["bin/servicemix"]
 