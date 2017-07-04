#!/bin/bash
echo "Installing Oracle JDK 8..."
sudo apt-get -y -q update
sudo apt-get -y -q upgrade
sudo apt-get -y -q install software-properties-common htop
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get -y -q update
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo apt-get -y -q install oracle-java8-installer
echo "Updating Java settings..."
sudo update-java-alternatives -s java-8-oracle 

echo "Adding execute permission to script for start webapp..."
sudo chmod +x /opt/startVideostore.sh

echo "Setting up script on startup..."
sudo mv /opt/startVideostore.sh /etc/init.d/
sudo update-rc.d startVideostore.sh defaults 99

echo "Running Videostore..."
java -jar /opt/VideoStore-1.0-SNAPSHOT.jar
