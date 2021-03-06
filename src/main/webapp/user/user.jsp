<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${cp }/css/bootstrap.min.css"
   rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${cp }/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${cp }/css/dashboard.css"
   rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">
<script>
//문서 로딩이 완료 되었을 때
$(function(){
   $("#modifyBtn").on("click", function(){
      $("#frm").attr("method", "get");
      $("#frm").attr("action", "${cp }/userModify");
      $("#frm").submit();
   });
   
   $("#deleteBtn").on("click", function(){
      $("#frm").attr("method", "post");
      $("#frm").attr("action", "${cp }/deleteUser");
      $("#frm").submit();
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
         <form class="form-horizontal" id="frm" role="form">
            <input type="hidden" name="userid" value="${user.userid }"/>
            
            <div class="form-group">
               <label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
               <div class="col-sm-10">
                  <!--  <img src="${cp }/profile/${user.userid }.png"/>-->
                  <a href ="/profileDownload?userid=${user.userid }">  
                        <img src="/profile?userid=${user.userid }"/>    
                  </a>
               </div>
            </div>
            
            <div class="form-group">
               <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
               <div class="col-sm-10">
                  <label class="control-label">${user.userid }</label>
               </div>
            </div>

            <div class="form-group">
               <label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
               <div class="col-sm-10">
                  <label class="control-label">${user.usernm }</label>
               </div>
            </div>

            <div class="form-group">
               <label for="userNm" class="col-sm-2 control-label">별명</label>
               <div class="col-sm-10">
                  <label class="control-label">${user.alias }</label>
               </div>
            </div>
            <div class="form-group">
               <label for="userNm" class="col-sm-2 control-label">비밀번호</label>
               <div class="col-sm-10">
                  <label class="control-label">******</label>
               </div>
            </div>
            <div class="form-group">
               <label for="pass" class="col-sm-2 control-label">등록일시</label>
               <div class="col-sm-10">
                  <label class="control-label"><fmt:formatDate value="${user.reg_dt }" pattern="yyyy.MM.dd" /></label>
               </div>
            </div>

            <div class="form-group">
               <label for="pass" class="col-sm-2 control-label">도로주소</label>
               <div class="col-sm-10">
                  <label class="control-label">${user.addr1 }</label>
               </div>
            </div>

            <div class="form-group">
               <label for="pass" class="col-sm-2 control-label">상세주소</label>
               <div class="col-sm-10">
                  <label class="control-label">${user.addr2 }</label>
               </div>
            </div>

            <div class="form-group">
               <label for="pass" class="col-sm-2 control-label">우편번호</label>
               <div class="col-sm-10">
                  <label class="control-label">${user.zipcode } </label>
               </div>
            </div>

            <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
                  <button type="button" id="modifyBtn" class="btn btn-default">사용자 수정</button>
                  <button type="button" id="deleteBtn" class="btn btn-default">사용자 삭제</button>
               </div>
            </div>
         </form>
      </div>
   </div>
</body>
</html>