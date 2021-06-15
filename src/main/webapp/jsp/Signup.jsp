<%@ page import="utility.MessageUtil" %><%--
  Created by IntelliJ IDEA.
  User: zhassulan
  Date: 5/13/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="../script/passwordView.js"></script>
</head>

<body>

<%@ include file="Header.jsp" %>

<main class="my-form" style="margin:100px 0">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header"><fmt:message key="label.signup.register"/></div>
                    <b><span style="color: red; "> <%=MessageUtil.getErrorMessage(request)%></span></b>
                    <div class="card-body">
                        <form name="my-form" action="/signup" method="post">
                            <div class="form-group row">
                                <label for="firstname" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.signup.firstname"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="firstname" class="form-control" name="firstName">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="lastname" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.signup.lastname"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="lastname" class="form-control" name="lastName">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.signup.email"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="email_address" class="form-control" name="email">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="phone_number" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.signup.phone"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="phone_number" class="form-control" name="phone">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.signup.password"/></label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="password">
                                    <input type="checkbox" onclick="myFunction()"><fmt:message key="label.login.showpassword"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="confirm_password" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.signup.confirmpassword"/></label>
                                <div class="col-md-6">
                                    <input type="password" id="confirm_password" class="form-control" name="confirm_password">
                                    <input type="checkbox" onclick="myFunctionConfirm()"><fmt:message key="label.login.showpassword"/>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    <fmt:message key="label.signup.register"/>
                                </button>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>

</main>

<%@ include file="Footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>
