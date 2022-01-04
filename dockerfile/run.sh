#!/bin/bash

chown -R mysql:mysql /var/lib/mysql /var/run/mysqld
service mysql start
mysql -uroot -e "grant all privileges on *.* to 'root'@'%' identified WITH mysql_native_password by 'password';" 
mysql -uroot -e "grant all privileges on *.* to 'root'@'localhost' identified WITH mysql_native_password by 'password';"

mysql -uroot -ppassword < /home/createDB.sql
chown -R www-data:www-data /var/www
#chown -R apache2:apache2 /var/lib/apache2 /var/run/apache2
service apache2 start
service apache2 status
while true
do
	tail -f /var/log/apache2/*.log
	exit 0
done
