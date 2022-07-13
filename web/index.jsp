<%--
  Created by IntelliJ IDEA.
  User: liyan
  Date: 2022/7/6
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
  <head>
    <title>$Title$</title>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link  type="text/css" rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css"/>
      <script src="js/jquery-3.4.1.js"></script>
      <script src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
  </head>
  <body>

  <!-- 添加帖子 -->
  <a href="insertInvitation.jsp">添加帖子</a><br/>

  <!-- 帖子操作的信息 -->
  <c:if test="${!empty(mess)}">
      ${mess}
  </c:if>
  <br/>

  <!--展示帖子信息-->
  <table class="table table-bordered table-striped table-hover" style="text-align: center">

      <thead>
      <th>标题</th>
      <th>内容</th>
      <th>发帖日期</th>
      <th>操作</th>
      </thead>
      <tbody>
      <c:forEach var="invitation" items="${Map.invitations}">
          <tr>
              <td>${invitation.title}</td>
              <td>${invitation.content}</td>
              <td>${invitation.postingTime}</td>
              <td><a href="invitation?action=deleteInvitations&id=${invitation.id}">删除</a></td>

          </tr>
      </c:forEach>

      </tbody>
  </table>
  <c:forEach var="i" begin="1" end="${Map.pageCount}">

      <a href="invitation?action=showAllInvitations&&pageNum=${i}">${i}</a>

  </c:forEach>

  </body>
</html>
