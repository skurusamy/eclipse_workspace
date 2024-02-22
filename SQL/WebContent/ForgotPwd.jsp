<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 2px solid #f1f1f1;}

input[type=text], input[type=password] {
 // width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: auto;
 // width: 100%;
}

button:hover {
  opacity: 0.8;
  padding: 10px 18px;
  background-color: #f44336;
}

//span.psw {
 // float: right;
  //padding-top: 16px;
//}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
}
</style>
</head>
<body>
<center>
<h2>Forgot Password</h2>

<form action="http://localhost:8080/SQL/MailServlet">

  <div>
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>
    </br>
    <button type="submit">Reset Password</button>
 <!-- <div class="container" style="background-color:#f1f1f1">-->
    </div>
    </br>
    Login..?<a href="login.html"><i>Click Me...!!!</i></a>
</form>
</br></br>



</center>
</body>
</html>

