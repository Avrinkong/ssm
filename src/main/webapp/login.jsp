<%--
  Created by IntelliJ IDEA.
  User: kxp6223065
  Date: 2019/5/6
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>导航页</h2>
    <form action="${pageContext.request.contextPath}/findByName" method="post">
        <table>
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="student_Name"  placeholder="姓名"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="password" name="student_Qq" maxlength="10"  placeholder="6-10位数字&字母组合登录密码"/>
                </td>
            </tr>
            <%--<tr>
                <td ><form:label path="name">姓名：</form:label></td>
                <td><form:input path="name"></form:input></td>
            </tr>
            <tr>
                <td ><jsp:text>密码：</td>
                <td><input name="password" type="password">  </td>
            </tr>--%>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录"/>
                </td>
            </tr>
        </table>
    </form>
    <form action="${pageContext.request.contextPath}/Student/addStudent" METHOD="post">
        <table>
           <%-- <tr>
                <td>学生ID：</td>
                <td>
                    <input type="text" name="student_Id"  />
                </td>
            </tr>--%>
            <tr>
                <td>创建时间：</td>
                <td>
                    <input type="text" name="create_At" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>更新时间：</td>
                <td>
                    <input type="text" name="update_At"  />
                </td>
            </tr>
            <tr>
                <td>学生姓名：</td>
                <td>
                    <input type="text" name="student_Name" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>学生密码：</td>
                <td>
                    <input type="text" name="student_Qq"  />
                </td>
            </tr>
            <tr>
                <td>学习类型：</td>
                <td>
                    <input type="text" name="student_Type" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>学习时间：</td>
                <td>
                    <input type="text" name="learning_Time"  />
                </td>
            </tr>
            <tr>
                <td>毕业学校：</td>
                <td>
                    <input type="text" name="School" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>学号：</td>
                <td>
                    <input type="text" name="laerning_Number"  />
                </td>
            </tr>
            <tr>
                <td>周报连接：</td>
                <td>
                    <input type="text" name="learning_Url" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>期望：</td>
                <td>
                    <input type="text" name="Dream"  />
                </td>
            </tr>
            <tr>
                <td>辅导师兄：</td>
                <td>
                    <input type="text" name="teacher" maxlength="10"  />
                </td>
            </tr>
        </table>
        <input type="submit" value="添加学生">
    </form>
    <form action="${pageContext.request.contextPath}/Student/deleteStudent" method="post">
        <table>
            <tr>
                <td>学生ID：</td>
                <td>
                    <input type="text" name="student_Id"/>
                </td>
            </tr>
        </table>
        <input type="submit" value="通过学生ID删除学生信息">
    </form>
    <form action="${pageContext.request.contextPath}/Student/updateStudent" METHOD="post">
        <table>
             <tr>
                 <td>学生ID（必填）：</td>
                 <td>
                     <input type="text" name="student_Id" placeholder="内容必填"  />
                 </td>
             </tr>
            <tr>
                <td>创建时间：</td>
                <td>
                    <input type="text" name="create_At" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>更新时间：</td>
                <td>
                    <input type="text" name="update_At"  />
                </td>
            </tr>
            <tr>
                <td>学生姓名：</td>
                <td>
                    <input type="text" name="student_Name" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>学生密码：</td>
                <td>
                    <input type="text" name="student_Qq"  />
                </td>
            </tr>
            <tr>
                <td>学习类型：</td>
                <td>
                    <input type="text" name="student_Type" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>学习时间：</td>
                <td>
                    <input type="text" name="learning_Time"  />
                </td>
            </tr>
            <tr>
                <td>毕业学校：</td>
                <td>
                    <input type="text" name="School" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>学号：</td>
                <td>
                    <input type="text" name="laerning_Number"  />
                </td>
            </tr>
            <tr>
                <td>周报连接：</td>
                <td>
                    <input type="text" name="learning_Url" maxlength="10"  />
                </td>
            </tr>
            <tr>
                <td>期望：</td>
                <td>
                    <input type="text" name="Dream"  />
                </td>
            </tr>
            <tr>
                <td>辅导师兄：</td>
                <td>
                    <input type="text" name="teacher" maxlength="10"  />
                </td>
            </tr>
        </table>
        <input type="submit" value="修改学生信息">
    </form>
    <form action="${pageContext.request.contextPath}/Student/findAllStudent?currentPage=500&pageSize=2" method="post">
        <input type="submit" value="查询所有学生记录">
    </form>
    <form action="${pageContext.request.contextPath}/Student/findAll?currPage=1&pageSize=30" method="post">
        <input type="submit" value="物理查询所有学生记录">
    </form>
    <form action="${pageContext.request.contextPath}/problem" method="post">
        <input type="submit" value="错误信息">
    </form>
    <form action="${pageContext.request.contextPath}/guojihua2" method="post">
        <input type="submit" value="国际化">
    </form>
</body>
</html>
