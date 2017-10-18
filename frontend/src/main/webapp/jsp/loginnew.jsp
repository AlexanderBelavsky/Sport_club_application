<%--
  Created by IntelliJ IDEA.
  User: BigPc
  Date: 14.10.2017
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/jsp/blocks/header1.jsp"/>
</head>
<body>
<div class="wrapper-page animated fadeInDown">
    <div class="panel panel-color panel-primary">
        <div class="panel-heading">
            <h3 class="text-center m-t-10"> Регистрация студента на практику </h3>
        </div>

        <form class="form-horizontal m-t-40" action="/loginnew" method="post">

            <div class="form-group">
                <div class="col-xs-12">
                    <input class="form-control" type="email" required="" name="email" placeholder="Email">
                </div>
            </div>
            <div class="form-group ">

                <div class="col-xs-12">
                    <input class="form-control" type="password" name="password" placeholder="Password">
                </div>
            </div>

            <div class="form-group ">
                <div class="col-xs-12">
                    <input type="checkbox" id="test5"/>
                    <label for="test5">Запомнить меня</label>
                </div>
            </div>

            <div class="form-group text-right">
                <div class="col-xs-12">
                    <button class="btn btn-primary w-md" type="submit">Войти</button>
                </div>
            </div>
        </form>
            <form class="form-horizontal m-t-0" action="/register" method="post">
                <div class="form-group text-right">
                    <div class="col-xs-12">
                        <button class="btn btn-primary w-md" type="submit">Регистрация</button>
                    </div>
                </div>
            </form>


    </div>
</div>

</body>
</html>
