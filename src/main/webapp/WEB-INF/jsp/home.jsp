<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<script>
			$(function() {
				var uri = '<c:url value="/boards" />'
	
				$.ajax({
					url : uri,
					type : "GET",
					dataType : "json",
					headers: {
					      "Content-Type": "application/json",
					      "X-HTTP-Method-Override": "GET"
					 },
					 success : function(response) {
						 var boardList = JSON.parse(response.boardList);
						 $(boardList).each(function(idx, obj) {
							 console.log(obj.idx);
							 console.log(obj.title);
							 console.log("================");
						 });
// 						 console.log("===============");
// 						 console.log(response.boardList);
// 						 JSON.parse(response.board);
// 						 console.log(response.board.idx);
					 },
					 error : function(a, b, c) {
						 console.log(a);
						 console.log("===============");
						 console.log(b);
						 console.log("===============");
						 console.log(c);
					 }
				});
				// end of ajax

			});
		</script>
	</body>
</html>
