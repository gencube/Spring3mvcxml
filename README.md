# Spring3mvcxml
Spring3mvcxml
====
Legacy Spring3mvc with XML configuration. Jetty ready and enabled.


Build instructions
-------------------

```
git clone https://github.com/gencube/resteasysample.git
cd resteasysample
mvn clean package
```

Run the Service
----------------
```
# with run goals: clean package jetty:run
mvn
....  # clean dand building war
[INFO] Logging initialized @9403ms
[INFO] Configuring Jetty for project: Spring3mvcxml
[INFO] webAppSourceDirectory not set. Trying src/main/webapp
[INFO] Reload Mechanic: automatic
[INFO] Classes = /home/mattong/wkspc-git/Spring3mvcxml/target/classes
[INFO] Context path = /Spring3mvcxml
[INFO] Tmp directory = /home/mattong/wkspc-git/Spring3mvcxml/target/tmp
[INFO] Web defaults = org/eclipse/jetty/webapp/webdefault.xml
[INFO] Web overrides =  none
[INFO] web.xml file = file:///home/mattong/wkspc-git/Spring3mvcxml/src/main/webapp/WEB-INF/web.xml
[INFO] Webapp directory = /home/mattong/wkspc-git/Spring3mvcxml/src/main/webapp
[INFO] jetty-9.3.0.v20150612
...  # Spring stuff
2015-07-01-15:16:29:044 - INFO  - HibernateTransactionManager - Using DataSource [org.apache.commons.dbcp.BasicDataSource@452ec287] of Hibernate SessionFactory for HibernateTransactionManager
2015-07-01-15:16:29:068 - INFO  - FrameworkServlet - FrameworkServlet 'spring': initialization completed in 3200 ms
[INFO] Started ServerConnector@a240452{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
[INFO] Started @17733ms
[INFO] Started Jetty Server
```


Test the Service
-----------------
```
curl http://localhost:8080/Spring3mvcxml/api/persons/init
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Added Person</title>
    </head>
    <body>
        <H2>initialized Persons</H2>
    </body>
</html>
curl http://localhost:8080/Spring3mvcxml/api/persons
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>List Employee</title>
    </head>
    <body>
        <div id="content">
            <table border="1px">
                <tr bgcolor="gray">
                    <td>ID</td>
                    <td>Name</td>
                    <td>Age</td>				
                    <td>Email</td>
                </tr>

                
                    
                        <tr>
                            <td>1</td>
                            <td>Name0</td>					
                            <td>11</td>
                            <td></td>
                        </tr>
...
```

