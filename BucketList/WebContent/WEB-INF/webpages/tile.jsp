<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" 	uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bucketlist</title>

<!-- Modal을 위한 bootstrap 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">-->
<link rel="stylesheet" href="resources/css/main_all.css">

<script type="text/javascript" src="resources/js/jquery_latest_160826.js"></script>
<!-- Modal을 위한 bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.login_modal').hide();
	
    $("#login").click(function(){
    	$('.login_modal').show();
    	$('.login_modal').load('resources/login.jsp', function( response, status, xhr ) {
    		  if ( status == "error" ) {
    			    var msg = "Sorry but there was an error: ";
    			    $( ".login_modal" ).html( msg + xhr.status + " " + xhr.statusText );
    			  }
			});
    	$('.login_modal').css('top','0').css('opacity','0.5').css('display','block').css('position','fixed').css('width','100%').css('height','100%').css('z-index','100').css('background-color','#000');
    })
})
</script>

</head>
<body>
<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="menuwrap">
		<tiles:insertAttribute name="body"/>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>

<div class="login_modal">
</div>
<div class="login_modal_content">
</div>
</body>
</html>