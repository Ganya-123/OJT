<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Login Page</title>


<style>
body{
background-image: url("images/image2.jpg");
}
.login-form {
    width: 350px;
    margin: 50px auto;
  	font-size: 15px;
  	
  	padding: 50px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 25px;
    border-radius: 0.5px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}

</style>
</head>
<body>
<div class="login-form">
    
        <h2 class="text-center" style="color: white;">Log in </h2>       
        <div class="form-group">
            <input type="text"  id="user_id" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input type="password" id="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button id="three" type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
     
    
</div>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<!-- <script src="/first/js/jquery.js"></script> --> 


<script >
$(document).ready(function() {
	

	var $user_id=$('#user_id');
	var $password=$('#password');
	$('#three').on('click',function(){
		var login={
				user_id: Number($user_id.val()),
				password: $password.val(),
		};
		if($user_id.val().trim() !="" & $password.val().trim() != "" ){
	$.ajax({
		headers: { 'Accept': 'application/json',
            'Content-Type': 'application/json' },
		type: 'POST',
		url: 'webapi/myresource/login',
		dataType : 'json',
		data: JSON.stringify(login),
		/*complete:function(data){
			var jsonData = JSON.stringify(data);
			console.log(jsonData.responseText);
			alert("dta >> : "+jsonData);
		} */
	
		success:function(data,jqXHR){
			alert(data);
		},
		error:function(jqXHR){
			alert(jqXHR.responseText);
			
		}
	});
		}
		else{
			alert("Fields should not be blank")
		}
	
});
});
</script>


</html>
</script>


</html>