<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
  
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compose</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
    </head>
    <body>
    
    <%@ include file = "header.jsp" %>
        <div class="">
            <div class="">
                <h1> </h1>
             
            </div>
            <br>
           
            
            <form action="SendEmail" method="post">
                <table class="table table-hover">
                   
                    <tr>
                        <td>Email</td>
                        <td><input type="email" required="" placeholder="Email" name="email" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td><input type="text" required="" placeholder="Subject" name="subject" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Message</td>
                        <td><textarea name="message" required="" rows="5" cols="100" placeholder="Your Message" class="form-control"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="submit" class="btn btn-primary" value="Send"></td>
                    </tr>
                </table>
            </form>

        </div>
    </body>
</html>