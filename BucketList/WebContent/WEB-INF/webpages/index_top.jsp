<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$('#login_modal').hide();
function login(){
    $("#logins").click(function(){
    	alert("modal!");
    	$('#login_modal').show();
        $('#login_modal').modal(
       		{
        		remote : 'account/login.jsp'
        	}
    	);
    });
}
</script>

<a class="topdiv" href="/BucketList">BucketList</a> / 와우

<a id="logins" href="joinmember.do">
<img alt="회원가입" src="resources/img/people_m2.png" id="login_img">
</a>
