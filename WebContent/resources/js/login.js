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
	    else
    	{
	        $("#divCheckPasswordMatch").html("<h5 class='text-success'>Passwords match.</h5>");
	        $("#divrcp").attr("class", "form-group");
    	}
	});
	
});

function checkform() {
    if($("#rpassword").val() != $("#rcpassword").val()) {
        return false;
    } else {
        return true;
    }
}


