$(document).ready(function(){

	$("#purchase").click(function(){
	    $("#confirmMessage").text('You are purchasing ' + $("#quantity").val() + ' Shoes 1 for ' + $("#quantity").val() * $("#price").val() + ' php')
	});
	
});