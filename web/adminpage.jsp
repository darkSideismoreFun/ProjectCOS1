<%-- 
    Document   : adminpage
    Created on : Apr 20, 2016, 12:49:45 PM
    Author     : Plamen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You are now logged in!</h1>
        
        <form name="Form2" action="UIServlet" method="post">
            <input type="hidden" name="origin" value="customerlist">
            <input type="submit" name="Blistingpage" value="List Customers"/>
        <form/>
        
        <form name="Form2" action="UIServlet" method="post">
            <input type="hidden" name="origin" value="editpadmin">
            <input type="submit" name="Blistingpage" value="Edit Profile"/>
        <form/>
        
        
    </body>
</html>
