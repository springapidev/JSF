<%-- 
    Document   : searchForm
    Created on : Dec 22, 2017, 9:51:04 PM
    Author     : Rajail Islam
--%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <f:view>
         <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h:form>
      <h2>Search Flights</h2>
      <table>
        <tr><td colspan="4">Where and when do you want to travel?</td></tr>
        <tr>
          <td colspan="2">Leaving from:</td>
          <td colspan="2">Going to:</td>
        </tr>
        <tr>
          <td colspan="2">
            <h:inputText value="#{flightSearchController.flight.origination}" size="35"/>
          </td>
          <td colspan="2">
            <h:inputText value="#{flightSearchController.flight.destination}" size="35"/>
          </td>
        </tr>
        <tr>
          <td colspan="2">Departing:</td>
          <td colspan="2">Returning:</td>
        </tr>
        <tr>
          <td>
            <h:inputText value="#{flightSearchController.flight.departDate}"/>
          </td>
          <td>
            <h:inputText value="#{flightSearchController.flight.departTime}"/>
          </td>
          <td>
            <h:inputText value="#{flightSearchController.flight.returnDate}"/>
          </td>
          <td>
            <h:inputText value="#{flightSearchController.flight.returnTime}"/>
          </td>
        </tr>
      </table>
      <p>
      <h:commandButton value="Search" action="submit"/>
      </p>
    </h:form>
   </body>
    </body>
    </f:view>
   
</html>
