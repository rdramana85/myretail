# myretail

Install maven - https://maven.apache.org/install.html

Install any Git client and clone the repository

Within the Project dirctory, use command "mvn spring-boot:run" to start app

The application will start an embedded cassandra and insert some seed data. Seed data and schema definition are available in myretail/src/main/resources/initCassandra.cql

Sample GET URL - http://localhost:8080/myretail/v1/products/13860428

Sample GET Response - {"productId":13860428,"name":"BIG LEBOWSKI, THE Blu-ray","current_price":{"value":21.0,"currency_code":"USD"}}

Sample PUT URL - http://localhost:8080/myretail/v1/products/13860428

Sample PUT Request Bode - {"price":46.0,"currencyCode":"USD"}

If Handshake exception occurs, import target api's certificate to java cacerts. Steps are available in this thread - http://stackoverflow.com/questions/9619030/resolving-javax-net-ssl-sslhandshakeexception-sun-security-validator-validatore

Unit Test and Automation tests are pending




