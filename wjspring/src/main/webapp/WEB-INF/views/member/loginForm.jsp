<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginForm.jsp</title>
</head>
<body>
<h1>member/loginForm.jsp</h1>
<form action="${pageContext.request.contextPath}/member/loginPro" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pass"><br>
<input type="submit" value="로그인">
<input type="button" value="회원가입" onclick="location.href='${pageContext.request.contextPath}/member/insert'">
</form>


</body>
</html>