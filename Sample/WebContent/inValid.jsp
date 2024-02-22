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
  //border-color:red;
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
<@%
<center>
	int flag= response.getAttribute("flag");
    <h2>User Authentication System</h2>

<form action="http://localhost:8080/Sample/LoginServlet">

  <div>
    
    if(flag==0)
    {
    <label for="uname"><b>Username</b></label>
     <input type="text" placeholder="Enter Username" name="uname" border_color="red">
    
     <br>
     <label for="psw"><b>Password</b></label>
     <input type="password" placeholder="Enter Password" name="psw" >
     <br>
     <label for="ucode"><b>User Code</b></label>
     <input type="text" placeholder="Enter UserCode" name="uc">
     <br> 
    }
    if(flag==1)
    {
    <label for="uname"><b>Username</b></label>
     <input type="text" placeholder="Enter Username" name="uname" border_color="green">
    
     <br>
     <label for="psw"><b>Password</b></label>
     <input type="password" placeholder="Enter Password" name="psw" border_color="red">
     <br>
     <label for="ucode"><b>User Code</b></label>
     <input type="text" placeholder="Enter UserCode" name="uc">
     <br> 
    }
    if(flag==2)
    {
    <label for="uname"><b>Username</b></label>
     <input type="text" placeholder="Enter Username" name="uname" border_color="green">
    
     <br>
     <label for="psw"><b>Password</b></label>
     <input type="password" placeholder="Enter Password" name="psw" border_color="green" >
     <br>
     <label for="ucode"><b>User Code</b></label>
     <input type="text" placeholder="Enter UserCode" name="uc" border_color="red">
     <br> 
    }
    
    <button type="submit">Login</button>
 <!-- <div class="container" style="background-color:#f1f1f1">-->
    <button type="reset" class="cancelbtn">Reset</button>
    <br>
    <span class="psw">Forgot password?<a href="ForgotPwd.html">Click Me...</a></span>
  </div>
</form>
</br>
<label ><i>Invalid Credential!!! Try again</i></label>
</center>
%>
</body>
</html>

    