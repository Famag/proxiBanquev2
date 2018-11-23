<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <jq:head/>
  <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>

<body>

<div class="container">
		<div class="row">
		<div class="panel panel-success" style="margin-top: 200px">
		<div class="panel panel-body">
  
    <div class="login-form">    
       <s:form action="login">
		<div class="avatar"><i class="material-icons">&#xE7FF;</i></div>

      <div class="form-group">      
        <input  class="form-control" placeholder="Username"  name="employe.login"  required="required"/>
      </div>
      
        <div class="form-group">
        <input  class="form-control" placeholder="Password"  name="employe.password" type="password" required="required" />
       </div>
   
        <s:submit class="btn btn-primary btn-block btn-lg" value="Login"/>
    </s:form>
    </div>
    </div>
    </div>
    </div>
    </div>
</body>
</html>