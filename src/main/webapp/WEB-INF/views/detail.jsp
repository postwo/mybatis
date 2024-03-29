<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
    table, th, td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px 10px;
    }
</style>
</head>
<body>
	<jsp:include page="loginBox.jsp"/>
     <table>
         <tr>
             <th>아이디</th>
             <th>${member.id}</th>
         </tr>
         <tr>
             <th>비밀번호</th>
             <th>${member.pw}</th>
         </tr>
         <tr>
             <th>이&nbsp;&nbsp;&nbsp;&nbsp;름</th>
             <th>${member.name}</th>
         </tr>
         <tr>
             <th>나이</th>
             <th>${member.age}</th>
         </tr>
         <tr>
             <th>이메일</th>
             <th>${member.email}</th>
         </tr>
         <tr>
             <th>성별</th>
             <th>${member.gender}</th>
         </tr>
         <tr>
             <th colspan="2">
                 <input type="button" value="리스트" onclick="location.href='list'"/>
                 <input type="button" value="수정" 
                 	onclick="location.href='updateForm?id=${member.id}'"/>
             </th>
         </tr>
     </table>
</body>
<script></script>
</html>