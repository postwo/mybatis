<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<form action="update" method="post">
     <table>
         <tr>
             <th>아이디</th>
             <th>
                 <input type="text" name="id" readonly="readonly" value="${member.id}"/>
             </th>
         </tr>
         <tr>
             <th>비밀번호</th>
             <th>
                 <input type="text" name="pw" value="${member.pw}"/>
             </th>
         </tr>
         <tr>
             <!--공백문자-->
             <th>이&nbsp;&nbsp;&nbsp;&nbsp;름</th>
             <th>
                 <input type="text" name="name" value="${member.name}"/>
             </th>
         </tr>
         <tr>
             <th>나이</th>
             <th>
                 <input type="text" name="age" value="${member.age}"/>
             </th>
         </tr>
         <tr>
             <th>이메일</th>
             <th>
                 <input type="email" name="email" value="${member.email}"/>
             </th>
         </tr>
         <tr>
             <th>성별</th>
             <th>  			
                 <input type="radio" name="gender" value="남" 
                 <c:if test="${fn:contains(member.gender, '남')}">checked</c:if>
                 />남자
                 <input type="radio" name="gender" value="여" 
                 <c:if test="${fn:contains(member.gender, '여')}">checked</c:if>
                 />여자
             </th>
         </tr>
         <tr>
             <th colspan="2">
                 <input type="submit" value="수정"/>
             </th>
         </tr>
     </table>
 </form>
</body>
<script></script>
</html>