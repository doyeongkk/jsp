<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<%
UserVo user = (UserVo) request.getAttribute("userInfo");
%>



<script>
$(function(){
	<%if (user != null) {%>
		var userid = "<%=user.getUserid()%>"
		var usernm = "<%=user.getUsernm()%>"
		var pass = "<%=user.getPass()%>"
		var reg_dt = "<%=user.getReg_dt_fmt()%>"
		var alias = "<%=user.getAlias()%>"
		var addr1 = "<%=user.getAddr1()%>"
		var addr2 = "<%=user.getAddr2()%>"
		var zipcode = "<%=user.getZipcode()%>"
		$('#userid').val(userid)
		$('#usernm').val(usernm)
		$('#pass').val(pass)
		$('#reg_dt').val(reg_dt)
		$('#alias').val(alias)
		$('#addr1').val(addr1)
		$('#addr2').val(addr2)
		$('#zipcode').val(zipcode)
<%}%>
	$("#addrBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					$("#addr1").val(data.roadAddress); //도로주소
					$("#zipcode").val(data.zonecode); //우편번호

					//사용자 편의성을 위해 상세주소 입력 input 태그로 focus 설정
					$("#addr2").focus();
				}
			}).open();
		});
	});
</script>

</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/common/left.jsp"%>
		</div>

		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<form class="form-horizontal" role="form" method="post"
				action="<%=request.getContextPath()%>/registUser">

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
					<div class="col-sm-10">
						<%
						String userid = request.getParameter("userid");
						userid = userid == null ? "" : userid;
						%>
						<input type="text" class="form-control" id="userid" name="userid"
							placeholder="사용자아이디" value="<%=userid%>">
					</div>
				</div>

				<div class="form-group">
					<label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
					<div class="col-sm-10">
						<%
						String usernm = request.getParameter("usernm");
						usernm = usernm == null ? "" : usernm;
						%>
						<input type="text" class="form-control" id="usernm" name="usernm"
							placeholder="사용자이름" value="<%=usernm%>">
					</div>
				</div>


				<div class="form-group">
					<label for="alias" class="col-sm-2 control-label">별명</label>
					<div class="col-sm-10">
						<%
						String alias = request.getParameter("alias");
						alias = alias == null ? "" : alias;
						%>
						<input type="text" class="form-control" id="alias" name="alias"
							placeholder="별명" value="<%=alias%>">
					</div>
				</div>


				<div class="form-group">
					<label for="pass" class="col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-10">
						<%
						String pass = request.getParameter("pass");
						pass = pass == null ? "" : pass;
						%>
						<input type="text" class="form-control" id="pass" name="pass"
							placeholder="********" value="<%=pass%>">
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">등록일시</label>
					<div class="col-sm-10">
						<%
						String reg_dt = request.getParameter("reg_dt");
						reg_dt = reg_dt == null ? "" : reg_dt;
						%>
						<input type="text" class="form-control" id="reg_dt" name="reg_dt"
							placeholder="등록일시" value="<%=reg_dt%>">
					</div>
				</div>

				<div class="form-group">
					<label for="addr1" class="col-sm-2 control-label">도로주소</label>
					<div class="col-sm-8">
						<%
						String addr1 = request.getParameter("addr1");
						addr1 = addr1 == null ? "" : addr1;
						%>
						<input type="text" class="form-control" id="addr1" name="addr1"
							placeholder="도로주소" value="<%=addr1%>" readonly>
					</div>
					<div class="col-sm-2">
						<button type="button" id="addrBtn" class="btn btn-default">주소검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="addr2" class="col-sm-2 control-label">상세주소</label>
					<div class="col-sm-10">
						<%
						String addr2 = request.getParameter("addr2");
						addr2 = addr2 == null ? "" : addr2;
						%>
						<input type="text" class="form-control" id="addr2" name="addr2"
							placeholder="상세주소" value="<%=addr2%>">
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">우편번호</label>
					<div class="col-sm-10">
						<%
						String zipcode = request.getParameter("zipcode");
						zipcode = zipcode == null ? "" : zipcode;
						%>
						<input type="text" class="form-control" id="zipcode"
							name="zipcode" placeholder="우편번호" value="<%=zipcode%>" readonly>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">사용자 등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
