<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
    <body>
        <h2>${message}</h2>
        <h2>每页展示${pageSize}条数据，共计${total}条数据，共计${totalPage}页</h2>
        <form>
            <table border="1">
                <TR>
                    <TD>student_Id</TD>
                    <TD>create_At</TD>
                    <TD>update_At</TD>
                    <TD>student_Name</TD>
                    <TD>student_Qq</TD>
                    <TD>student_Type</TD>
                    <TD>learning_Time</TD>
                    <TD>school</TD>
                    <TD>laerning_Number</TD>
                    <TD>learning_Url</TD>
                    <TD>dream</TD>
                    <TD>teacher</TD>
                </TR>
        <c:forEach items="${list}" var="list">
            <tr>
                <TD>${list.student_Id }</TD>
                <TD>${list.create_At }</TD>
                <TD>${list.update_At }</TD>
                <TD>${list.student_Name }</TD>
                <TD>${list.student_Qq }</TD>
                <TD>${list.student_Type }</TD>
                <TD>${list.learning_Time }</TD>
                <TD>${list.school }</TD>
                <TD>${list.laerning_Number }</TD>
                <TD>${list.learning_Url }</TD>
                <TD>${list.dream }</TD>
                <TD>${list.teacher }</TD>
                <TD>
                    <a href="${pageContext.request.contextPath }/Student/deleteStudent?student_Id=${list.student_Id}" >删除</a>
                </TD>
            </tr>
        </c:forEach>
                </table>
            </form>
        <form action="${pageContext.request.contextPath}/Student/findAll" method="post">
            <tr>
                <td>当前处于第${currPage}页，你要跳转至哪一页</td>
                <td>
                    <input type="text" name="currPage"  />
                </td>
            </tr>
            <tr>
                <td>每页显示</td>
                <td>
                    <input type="text" name="pageSize" maxlength="10"  />
                </td>
            </tr>
            <input type="submit" value="查询">
        </form>
    </body>
</html>
