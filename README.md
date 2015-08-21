# [CSR-System](http://csr-ticketing-system.herokuapp.com/)
Customers often have complaints which call the customer service representatives and talk to. The CSR  then logs the information by choosing the available areas to which the issue is related to, into the   system. This record is called as a ticket.

This is a classic CSR-System application, backed by a JDBC database. It demonstrates:
- Handling asynchronous results, Handling time-outs
- Achieving, Futures to use more idiomatic error handling.
- Accessing a JDBC database, using Anorm.
- Achieving, table pagination and sorting functionality.
- Replaced the embedded JS & CSS libraries with [WebJars](http://www.webjars.org/).
- Play and Scala-based template engine implementation
- Integrating with a CSS framework (Twitter Bootstrap). Twitter Bootstrap requires a different form layout to the default one that the Play form helper generates, so this application also provides an example of integrating a custom form input constructor.
- [AdminLTE](https://almsaeedstudio.com/themes/AdminLTE/index2.html) Control Panel Template with Twitter Bootstrap to improve the look and feel of the application

-----------------------------------------------------------------------
###Instructions
-----------------------------------------------------------------------
* The live application is currently hosted at : [CSR-System](http://csr-ticketing-system.herokuapp.com/)
* The GitHub code for the project is at : [CSR-System](https://github.com/anand-singh/csr-ticketing-system)
* Clone the project into local system
* To run the Play framework 2.4.x, you need JDK 8
* Install Typesafe Activator if you do not have it already. You can get it from here: [download](http://www.playframework.com/download)
* Execute `activator clean compile` to build the product
* Execute `activator run` to execute the product
* [CSR-System](http://csr-ticketing-system.herokuapp.com/) should now be accessible at [localhost:9000](http://localhost:9000/)
