<%--
  Created by IntelliJ IDEA.
  User: tao Date: 2019/2/18 Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery发送ajax请求</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <%--以当前页面index.jsp为坐标在当前文件夹中查找--%>
    <script>
        $(document).ready(function () {
            $('button').click(function () {
                ajaxTest()
            })
        })
        function ajaxTest() {
            // alert("aaaaaaa");
            //获取数据
            var username = $('#username').val();
            var password = $('#password').val();

            //Ajax提交数据
            $.ajax({
                url: "admin/check_login",
                type: "post",
                data: {"username": username, "password": password},
                dataType: "json",
                success: function (data) {
                    console.log(data)
                    if(data.status == 200){
                        // alert("你好，" + data.user.name);
                        alert("你好，" + data.data[0].username);
                    }else{
                        alert("失败")
                    }
                }
            })
        }
    </script>
</head>
<body>
    <input  type="text" id="username" name="username"/><br/>
    <input type="password" id="password" name="password"/><br/>

    <button type="button" style="text-align: center">登陆</button>
<script>

</script>
</body>
</html>
