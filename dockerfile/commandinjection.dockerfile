FROM ubuntu

#ADD sources.list /etc/apt
ADD run.sh /home/
ADD mysql5.deb.tar /home/
ADD targets/CommandInjection/commandinjection.txt /home/password.txt
RUN apt-get update -y && apt-get upgrade -y 
#install MySQL
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y libaio1 && \
DEBIAN_FRONTEND=noninteractive apt-get install -y perl && \
DEBIAN_FRONTEND=noninteractive apt-get install -y psmisc && \
DEBIAN_FRONTEND=noninteractive apt-get install -y libsasl2-2 && \
DEBIAN_FRONTEND=noninteractive apt-get install -y libtinfo5 && \
DEBIAN_FRONTEND=noninteractive apt-get install -y libnuma1 && \
dpkg -i /home/mysql-common_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg-preconfigure /home/mysql-community-server_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg -i /home/libmysqlclient20_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg -i /home/libmysqlclient-dev_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg -i /home/libmysqld-dev_5.7.35-1ubuntu18.04_amd64.deb &&\
dpkg -i /home/mysql-community-client_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg -i /home/mysql-client_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg -i /home/mysql-common_5.7.35-1ubuntu18.04_amd64.deb && \
apt-get -f install && \
DEBIAN_FRONTEND=noninteractive apt-get install -y libmecab2 && \
dpkg -i /home/mysql-community-server_5.7.35-1ubuntu18.04_amd64.deb && \
dpkg -i /home/mysql-server_5.7.35-1ubuntu18.04_amd64.deb

#install php
RUN DEBIAN_FRONTEND=noninteractive apt-get install -y software-properties-common && \
add-apt-repository -y ppa:ondrej/php && \
apt update && \
apt install -y php5.6
RUN apt install -y php5.6-mysqli && \
apt install -y php5.6-mbstring

#install apache
RUN apt install -y apache2 && \
echo "ServerName localhost" >> /etc/apache2/apache2.conf

ADD targets/CommandInjection/commandinjection.php /var/www/html/index.php
ADD targets/CommandInjection/commandinjection.html /var/www/html/index.html
ADD php.ini /etc/php/5.6/apache2/

RUN apt install -y net-tools && \
apt install iputils-ping

RUN chmod +x /home/run.sh

EXPOSE 80

ENTRYPOINT  ["/home/run.sh"]
