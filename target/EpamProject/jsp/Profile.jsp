<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="../script/passwordView.js"></script>
</head>
<body>

<%@ include file="Header.jsp" %>
<%
    User dbUser = (User) session.getAttribute("user");
%>
<main class="my-form" style="margin:100px 0">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header"><fmt:message key="label.profile.name"/></div>
                    <div class="card-body">
                        <form name="my-form" action="/profile" method="post">
                            <div class="form-group row">
                                <label for="firstname" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.firstname"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="firstname" class="form-control" name="firstName" value="<%=user.getFirstName()%>">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="lastname" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.lastname"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="lastname" class="form-control" name="lastName" value="<%=user.getLastName()%>">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.email"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="email_address" class="form-control" name="email-address" value="<%=user.getEmail()%>">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="phone_number" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.phone"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="phone_number" class="form-control" name="phone" value="<%=user.getPhone()%>">
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4" style="margin-bottom: 20px">
                                <input type="submit" name="operation" class="btn btn-primary" value=<fmt:message key="label.profile.button.update"/>>
                            </div>

                            <div class="form-group row">
                                <label for="old_password" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.oldpassword"/></label>
                                <div class="col-md-6">
                                    <input type="password" id="old_password" class="form-control" name="old_password">
                                    <input type="checkbox" onclick="myFunctionOld()"><fmt:message key="label.login.showpassword"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.password"/></label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="new_password">
                                    <input type="checkbox" onclick="myFunction()"><fmt:message key="label.login.showpassword"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="confirm_password" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.profile.confirmpassword"/></label>
                                <div class="col-md-6">
                                    <input type="password" id="confirm_password" class="form-control" name="confirm_password">
                                    <input type="checkbox" onclick="myFunctionConfirm()"><fmt:message key="label.login.showpassword"/>
                                </div>
                            </div>


                            <div class="col-md-6 offset-md-4" style="margin-bottom: 20px">
                                <input type="submit" name="operation" class="btn btn-primary" value=<fmt:message key="label.profile.button.changepassword"/>>
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