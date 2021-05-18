# Artisan7_BackEnd
Pour assurer le fonctionnement du BackEnd en JEE (EJB), on doit connecter la BD https://remotemysql.com/phpmyadmin/index.php
en MySQL avec JBOSS, on suit les etapes suivants :

## 1 - Ajuster le driver MySQL à JBOSS
suivre les instructions: (2:45-->Fin) https://www.youtube.com/watch?v=33fYR-Yky5c&t=147s

Des modifications à faire : 
```
Name: Artisan7BD
JNDI: java:/Artisan7BD
Connection URL: jdbc:mysql://remotemysql.com:3306/GCDeE5JAfp
Username: GCDeE5JAfp
Password: bu4GkgPGfv
```

## 2 - Verifier Standalone.xml JBOSS
Vérifier que ce script est dans la ligne ~ 146 :
```
 <datasource jndi-name="java:/Artisan7BD" pool-name="Artisan7BD" enabled="true" use-ccm="true">
      <connection-url>jdbc:mysql://remotemysql.com:3306/GCDeE5JAfp</connection-url>
      <driver-class>com.mysql.jdbc.Driver</driver-class>
      <driver>mysql</driver>
      <security>
          <user-name>GCDeE5JAfp</user-name>
          <password>bu4GkgPGfv</password>
      </security>
      <validation>
          <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
          <background-validation>true</background-validation>
          <background-validation-millis>50000</background-validation-millis>
          <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
      </validation>
  </datasource>
```
## 3 - Connecter à la base de donnée en ligne
le site : https://remotemysql.com/phpmyadmin/index.php

Username : GCDeE5JAfp

password : bu4GkgPGfv

## 4 - Commande pour utilisation en FrontEnd
```
REST commande :
	GET : localhost:8080/Artisan7_BackEnd/Client ==> json avec tous les données clients
	GET : localhost:8080/Artisan7_BackEnd/Artisan ==> json avec tous les données Artisans

	GET : localhost:8080/Artisan7_BackEnd/Artisan/sectuer=menuisier ==> json avec tous les données des Artisans menuisier

	GET : localhost:8080/Artisan7_BackEnd/Client/id=2 ==> json avec les données clients avec id=2
	GET : localhost:8080/Artisan7_BackEnd/Artisan/id=2 ==> json avec les données Artisans avec id=2

	GET : localhost:8080/Artisan7_BackEnd/Client/isValid=1 ==> json avec un champ 'présent=true/false' selon l'existance du client 1
	GET : localhost:8080/Artisan7_BackEnd/Artisan/isValid=1 ==> json avec  un champ 'présent=true/false' selon l'existance du artisan 1

	POST : localhost:8080/Artisan7_BackEnd/Client/Ajout ==> json pour ajouter un client
	POST : localhost:8080/Artisan7_BackEnd/Artisan/Ajout ==> json pour ajouter Artisan

	DELETE : localhost:8080/Artisan7_BackEnd/Client/supprime=3 ==> supprimer client id=3
	DELETE : localhost:8080/Artisan7_BackEnd/Artisan/supprime=3 ==> supprimer Artisan id=3	
```
