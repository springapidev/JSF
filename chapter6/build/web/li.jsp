<%-- 
    Document   : li
    Created on : Dec 19, 2018, 12:34:55 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/list.tld" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            Select User:  <c:myList/>          
            <input type=submit value="Submit"/>
        </form>
    </body>
</html>
