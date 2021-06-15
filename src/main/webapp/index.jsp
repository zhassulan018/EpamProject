<%--
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
            margin: 50px 0;
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
    </style>
</head>
<body>
<%@ include file="jsp/Header.jsp" %>
<div class="container">
    <div class="contain">

        <div class="product">
            <div class="img-container">
                <img src="https://images-na.ssl-images-amazon.com/images/I/51IXWZzlgSL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg">
            </div>
            <div class="product-info">
                <div class="product-content">
                    <h1>To Kill a Mockingbird</h1>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit ariatur</p>
                    <ul>
                        <li>Lorem ipsum dolor sit ametconsectetu.</li>
                        <li>adipisicing elit dlanditiis quis ip.</li>
                        <li>lorem sde glanditiis dars fao.</li>
                    </ul>
                    <div class="buttons">
                        <a class="button add" href="#">Add to Cart</a>
                        <span class="button" id="price">$59,99</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="product">
            <div class="img-container">
                <img src="https://images-na.ssl-images-amazon.com/images/I/51k1H84qiCL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg">
            </div>
            <div class="product-info">
                <div class="product-content">
                    <h1>Shakespeare Bats Cleanup</h1>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit ariatur</p>
                    <ul>
                        <li>Lorem ipsum dolor sit ametconsectetu.</li>
                        <li>adipisicing elit dlanditiis quis ip.</li>
                        <li>lorem sde glanditiis dars fao.</li>
                    </ul>
                    <div class="buttons">
                        <a class="button add" href="#">Add to Cart</a>
                        <span class="button" id="price">$30,99</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="product">
            <div class="img-container">
                <img src="https://images-na.ssl-images-amazon.com/images/I/51vRNqL61aL._SX318_BO1,204,203,200_.jpg">
            </div>
            <div class="product-info">
                <div class="product-content">
                    <h1>The Kite Runner</h1>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit ariatur</p>
                    <ul>
                        <li>Lorem ipsum dolor sit ametconsectetu.</li>
                        <li>adipisicing elit dlanditiis quis ip.</li>
                        <li>lorem sde glanditiis dars fao.</li>
                    </ul>
                    <div class="buttons">
                        <a class="button add" href="#">Add to Cart</a>
                        <span class="button" id="price">$120,99</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="jsp/Footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
