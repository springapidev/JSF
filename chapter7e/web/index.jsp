<%@ page import="com.coderbd.domain.Countries" %>

<html>

    <head>
        <title>Professional JSP 2, 4th Edition</title>
        <link rel="stylesheet" href="projsp.css">
    </head>

    <body>

        <%@ taglib uri="/WEB-INF/tlds/ch07.tld" prefix="ch07" %>

        <%
            pageContext.setAttribute("countries", Countries.getInstance().getCountries());
        %>

        Countries :
        <table style="border:1px solid #000; width: 100%;">            
            <tr>
                <th>ID</th>
                 <th>Name</th>
            </tr>
            <ch07:iterate var="country" items="${countries}">    
                <tr>
                    <td style="border:1px solid #000"> ${country.id}</td> 
                       <td style="border:1px solid #000"> ${country.name}</td> 
                    </tr>
                </ch07:iterate>
        </table>

    </body>

</html>