<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>값출</h4>
	${iVal }
	<br> ${lVal }
	<br> ${fVal }
	<br> ${bVal }
	<br> ${sVal }
	<br>

	<h4>객체출</h4>

	--${obj } --
	<br> ${user.id }
	<br> ${user.name }
	
	<h4>Map 객체출력</h4>
	${m.iVal } <br>
	${m.bVal } <br>
	${m.sVal } <br>
	
	<h4>Literal</h4>
	${1 } <br>
	${'Hello World' } <br>
	${true } <br>
	
	<h4>산술연산</h4>
	${1 + 2 } <br>
	${iVal + 2 } <br>
	
	<h4>관계연</h4>
	${iVal == 10 } <br>
	${iVal < 10 } <br>
	${obj == null} <br>
	${empty obj } <br>
	${not empty obj } <br>
	${obj != null} <br>
	
	<h4>논리연</h4>
	${iVal != 10 && lVal >= 10 } <br>
	${iVal != 10 || lVal >= 10 } <br>
	
	<h4>요청 파라미터</h4>
	${param.no + 10 } <br>
	${param.name } <br>
	
	<h4>Context Path</h4>
	${pageContext.request.contextPath }
</body>
</html>