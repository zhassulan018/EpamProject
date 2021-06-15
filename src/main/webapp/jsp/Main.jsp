<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="static utility.Const.*" %><%--
  Created by IntelliJ IDEA.
  User: zhassulan
  Date: 5/13/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .contain {
            display: flex;
            flex-wrap: wrap;
            margin: 10px 0;
        }

        .product {
            flex-basis: 48%;
            justify-content: center;
            width: 100%;
            height: 250px;
            display: flex;
            margin: 1em 0;
            border-radius: 5px;
            overflow: hidden;
            cursor: pointer;
            box-shadow: 0px 0px 21px 3px rgba(0, 0, 0, 0.15);
            transition: all .1s ease-in-out;
            margin-left: 20px;
        }

        .product:hover {
            box-shadow: 0px 0px 21px 3px rgba(0, 0, 0, 0.11);
        }

        .img-container {
            flex: 2;
        }

        .img-container img {
            object-fit: contain;
            width: 100%;
            height: 100%;
        }

        .product-info {
            background: #fff;
            flex: 3;
        }

        .product-content {
            padding: .2em 0 .2em 1em;
        }

        .product-content h1 {
            font-size: 1.5em;
        }

        .product-content p {
            color: #636363;
            font-size: .9em;
            font-weight: bold;
            width: 90%;
        }

        .product-content ul li {
            color: #636363;
            font-size: .9em;
            margin-left: 0;
        }

        .buttons {
            padding-top: .4em;
        }

        .button {
            text-decoration: none;
            color: #5e5e5e;
            font-weight: bold;
            padding: .3em .65em;
            border-radius: 2.3px;
            transition: all .1s ease-in-out;
        }

        .add {
            border: 1px #5e5e5e solid;
        }

        .add:hover {
            border-color: #6997b6;
            color: #6997b6;
        }

        #price {
            margin-left: 4em;
            color: #5e5e5e;
            font-weight: bold;
            border: 1px solid rgba(137, 137, 137, 0.2);
            background: rgba(137, 137, 137, 0.04);
        }

        .form-control-borderless {
            border: none;
        }

        .form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {
            outline: none;
            box-shadow: none;
        }
    </style>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
    <br/>
    <div class="row justify-content-center">
        <div class="col-12 col-md-10 col-lg-8">
            <form class="card card-sm" action="/main" method="post">
                <div class="card-body row no-gutters align-items-center">
                    <h4><fmt:message key="label.searchbar"/> </h4>
                    <div class="col">
                        <input class="form-control form-control-sm form-control-borderless" type="search" placeholder=<fmt:message key="label.placeholder.search"/> name="search_bar">
                    </div>
                    <div class="col-auto">
                        <button class="btn btn-sm btn-primary" type="submit" style="margin-left: 10px" name="operation" value="search"><fmt:message key="label.button.search"/></button>
                    </div>

                </div>
            </form>
        </div>
        <!--end of col-->
    </div>

    <div class="contain">

        <%
            List books = (List) request.getAttribute("books");
            Iterator<Book> it = books.iterator();
            Book book = null;
            while(it.hasNext()){

                book = it.next();
        %>
            <div class="product">
                <div class="img-container">
                    <img src=<%=book.getUrl()%>>
                </div>
                <div class="product-info">
                    <div class="product-content">
                        <h1><%=book.getName()%></h1>
                        <p><%=book.getBriefInfo()%></p>
                        <div class="buttons">
                            <form action="/main" method="post">
                                <input type="hidden" name="book_id" value="<%=book.getId()%>">
                                <button class="button add" type="submit" name="operation" value="add_book_basket"><fmt:message key="label.button.addtocart"/></button>
                                <span class="button" id="price">$<%=book.getCost()%></span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <%} %>
    </div>
</div>
<%@ include file="Footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
