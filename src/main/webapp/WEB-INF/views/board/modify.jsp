<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="/board/modify" method="post">
	
		<div class="form-group">
			<label>Bno</label> <input class="form-control" name="bno"
			value="<c:out value='${board.bno }' />" readonly="readonly" />
		</div>
		<div class="form-group">
			<label>Title</label>
			<input class="form-control" name="title"
			value="<c:out value='${board.title }' />" />
		</div>		
		<div class="form-group">
			<label>Text area</label>
			<textarea class="form-control" rows="3" name="content"><c:out value="${board.content }" /></textarea>
		</div>
		<div class="form-group">
			<label>Writer</label>
			<input class="form-control" name="writer"
			value='<c:out value="${board.writer }" />' readonly="readonly" />
		</div>
		<div class="form-group">
			<label>RegDate</label>
			<input class="form-control" name="regDate"
			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}" />' readonly="readonly" />
		</div>
		<div class="form-group">
			<label>Update Date</label>
			<input class="form-control" name="updateDate"
			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}" />' readonly="readonly" />
		</div>
		
		<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>	
		<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>	
		<button type="submit" data-oper="list" class="btn btn-info">List</button>	
	</form>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>