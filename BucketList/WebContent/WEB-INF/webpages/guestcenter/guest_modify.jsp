<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 스타일시트 적용 -->
<link rel="stylesheet" href="resources/css/guestboard.css">

<!-- JS -->
<script type="text/javascript">

/* $("button").click(function(){
    $.post("demo_test_post.asp",
    {
        name: "Donald Duck",
        city: "Duckburg"
    },
    function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
});
 */
function fileremove(brdno){
	//$(document).ready(function() {
		var brdnum = brdno;
	    $.ajax({
	          url : "fileremove.do",
	          method : "POST",
	          data : { brdno : brdnum }, 
	          //dataType: "text", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	          success : function(data) {
	                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
	                // TODO
	                //alert('통신성공 data : ' + data);
	        	  	$("#brdfilepath").html("없음");
	          },
	          complete : function(data) {
	                // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	                // TODO
	        	  	//alert('통신완료 data : ' + data.status);
	          },
	          /* error : function(xhr, status, error) {
	                alert("에러발생 - 파일이 안지워져요. status : " + status + ", xhr : " + xhr.value + ", error : "+ error);
	          } */
	          error:function(request,status,error){
	              alert("code:  "+request.status+"\n"+"message:  "+request.responseText+"\n"+"error:  "+error);
              }
	    });
	//});
}
</script>

<h1>guest_insert.jsp</h1>
<form method="post" enctype="multipart/form-data">
<table cellspacing="5" cellpadding="5" class="guesttbl_addmod">
<tr>
	<th>아이디</th>
	<td>${guestbrd.brduserid }</td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="brdsubject" placeholder="제목을 입력하세요" required="required" size="98" value="${guestbrd.brdsubject }"></td>
			<!-- INPUT TYPE의 required 속성은 HTML5 기능인 듯. -->
</tr>
<tr>
	<th>파일</th>
	<td>
		<span><input type="file" name="file" ></span>
		<c:choose>
		<c:when test="${empty guestbrd.brdfilepath }">
			업로드된 파일 없음
		</c:when>
		<c:otherwise>
			<span>업로드된 파일 : <span id="brdfilepath">${guestbrd.brdfilepath }</span></span>
			<input type="button" onclick="fileremove('${guestbrd.brdno }')" value="업로드된파일지우기">
		</c:otherwise>
		</c:choose>
	</td>
</tr>
<tr>	
	<th>내용</th>
	<td>	<textarea name="brdcontext" cols="100" rows="15" placeholder="내용을 입력하세요">${guestbrd.brdcontext }</textarea>	</td>
</tr>
<tr>
	<td colspan="2" align="right">
		<input type="hidden" name="brdno" value="${guestbrd.brdno }">
		<input type="hidden" name="brduserid" value="${guestbrd.brduserid }">
		<input type="hidden" name="brdfilepath" value="${guestbrd.brdfilepath }">
		<input type="submit" value="수정하기">
		<input type="button" value="목록으로" onclick="location.href='guestcenter.do'">
	</td>
</tr>
</table>
</form>