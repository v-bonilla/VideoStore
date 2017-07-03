#!/bin/bash
echo "Installing MySQL..."
sudo apt-get -y -q update
sudo apt-get -y -q upgrade
sudo apt-get install debconf-utils -y > /dev/null
debconf-set-selections <<< "mysql-server mysql-server/root_password password root"
debconf-set-selections <<< "mysql-server mysql-server/root_password_again password root"
sudo apt-get install mysql-server -y > /dev/null

echo "Updating MySQL configs..."
sudo sed -i "s/.*bind-address.*/bind-address = 0.0.0.0/" /etc/mysql/my.cnf
echo "Restarting mysql..."
sudo service MySQL restart

echo "Creating database..."
USER=root
PASSWORD=root
DB_NAME=videostore_db
mysqladmin -u$USER -p$PASSWORD create $DB_NAME 

echo "Creating user for webapp db connection..."
mysql -uroot -proot -e "CREATE USER 'admin_videostore'@'localhost' IDENTIFIED BY 'videostore';"
mysql -uroot -proot -e "GRANT ALL PRIVILEGES ON *.* TO 'admin_videostore'@'localhost' WITH GRANT OPTION;"
mysql -uroot -proot -e "CREATE USER 'admin_videostore'@'%' IDENTIFIED BY 'videostore';"
mysql -uroot -proot -e "GRANT ALL PRIVILEGES ON *.* TO 'admin_videostore'@'%' WITH GRANT OPTION;"
mysql -uroot -proot -e "FLUSH PRIVILEGES;"