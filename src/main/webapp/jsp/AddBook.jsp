<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<%@ include file="Header.jsp" %>

<main class="my-form" style="margin:100px 0">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header"><fmt:message key="label.addbook.name"/></div>
                    <div class="card-body">
                        <form name="my-form" action="/addbook" method="post">
                            <div class="form-group row">
                                <label for="name" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.addbook.bookname"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="name" class="form-control" name="name">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="cost" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.addbook.cost"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="cost" class="form-control" name="cost">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="url" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.addbook.imagelink"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="url" class="form-control" name="url">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="briefInfo" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.addbook.briefInfo"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="briefInfo" class="form-control" name="briefInfo">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="amount" class="col-md-4 col-form-label text-md-right"><fmt:message key="label.addbook.amount"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="amount" class="form-control" name="amount">
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    <fmt:message key="label.addbook.button.addbook"/>
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