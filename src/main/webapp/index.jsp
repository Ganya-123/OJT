<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Login Page</title>

</head>
<body>
<input id="user_id" placeholder="Enter id" type="number">
<input id="password" placeholder="Enter password" type="password">
<button type="submit" id="three">validate</button>
</body>
<!-- <script type="text/javascript"></script> -->
<script src="/first/js/jquery.js"></script> 


<script  type="text/javascript">
$(document).ready(function() {
	

	var $user_id=$('#user_id');
	var $password=$('#password');
	$('#three').on('click',function(){
		var login={
				user_id: Number($user_id.val()),
				password: $password.val(),
		};
	alert("input data >> : "+JSON.stringify(login));
	$.ajax({
		headers: { 'Accept': 'application/json',
            'Content-Type': 'application/json' },
		type: 'GET',
		url: 'webapi/myresource/show',
		dataType : 'json',
		data: JSON.stringify(login),
	
		success:function(){
			alert('successful');
		},
		error:function(){
			alert('unsuccessful');
			
		}
	});
	
});
});
</script>


</html>