$(document).ready(function(){

	$("#login-button").click(function(){
		$("#login").css("display", "block");
		$("#content").css("opacity", "0.3");
		$("#content").css("pointer-events", "none");
	});
	
	$(".cancel").click(function(){
		$("#login").css("display", "none");
		$("#signup").css("display", "none");
		$("#content").css("pointer-events", "auto");
		$("#content").css("opacity", "1");
	});
	
	$("#rcpassword").keyup(function(){
	    var password = $("#rpassword").val();
	    var confirmPassword = $("#rcpassword").val();

	    if (password != confirmPassword)
	        $("#divCheckPasswordMatch").html("<h5 class='text-danger'>Passwords do not match!</h5>");

	    else if(!checkPassword($("#rpassword").val()))
    	{
	    	$("#divCheckPasswordMatch").html("<h5 class='text-danger'>Password must be composed of at least 1 uppercase, lowercase characters and a number!	</h5>");
    	}
	    else
	        $("#divCheckPasswordMatch").html("<h5 class='text-success'>Passwords match.</h5>");
	});
	
	$("#rpassword").keyup(function(){
	    var password = $("#rpassword").val();
	    var confirmPassword = $("#rcpassword").val();

	    if (password != confirmPassword)
    	{
	    	$("#divCheckPasswordMatch").html("<h5 class='text-danger'>Passwords do not match!</h5>");
    	}
	    else if(!checkPassword($("#rpassword").val()))
    	{
	    	$("#divCheckPasswordMatch").html("<h5 class='text-danger'>Password must be composed of at least 1 uppercase, lowercase characters and a number!	</h5>");
    	}
	    else
    	{
	        $("#divCheckPasswordMatch").html("<h5 class='text-success'>Passwords match.</h5>");
	        $("#divrcp").attr("class", "form-group");
    	}
	});
	
});

function checkform() {
    if(checkPassword($("#rpassword").val()) && $("#rpassword").val() == $("#rcpassword").val())
    {
        return true;
    }
    else
	{
    	return false;
	}
}

function checkPassword(str) {
	var regex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,}$/;
	console.log(regex.test(str));
	return regex.test(str);
}


