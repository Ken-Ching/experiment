$(function(){
	var cssContent = document.getElementById("cssContent");
	cssContent.onmouseover = function () {
		this.style = "color:red;";
	}
	cssContent.onmouseout = function () {
		this.style = "color:black;";
	}
	
	$("#htmlContent").click( function () {
		if (!$(this).hasClass("greenFont") && !$(this).hasClass("redFont")) {
			$(this).addClass("greenFont")
		} else {
			$(this).toggleClass("greenFont");
			$(this).toggleClass("redFont");
		}
	});
});