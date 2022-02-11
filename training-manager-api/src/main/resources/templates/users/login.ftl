<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <style>
        body {
            background: #f3f2f2;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100vw;
            height: 100vh;
            overflow: hidden;
            font-family: system-ui;
        }

        .form-wrapper{
            display: flex;
            height: 90%;
            width: 90%;
            max-width: 650px;
            max-height: 500px;
            background-color: #fefefe;
            box-shadow: 0px 2px 6px -1px rgb(0 0 0 / 12%);
            overflow: hidden;
            border-radius: 6px;
        }

        .form-wrapper .left{
            width: 250px;
            min-width: 250px;
            background-image: url("https://images.pexels.com/photos/114979/pexels-photo-114979.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
            background-size: cover;
        }

        .form-wrapper form{
            display: flex;
            flex-direction: column;
            width: 100%;
            padding: 20px;
        }

        .form-wrapper .form h3{
            font-size: 24px;
            color: rgba(0, 0, 0, 0.5);
        }

        .form-wrapper .form h3 span{
            color: #333333;
        }

        .form-wrapper .form p{
            font-weight: 300;
            margin-bottom: 30px;
        }

        .form-wrapper .form input{
            height: 42px;
            border-radius: 16px;
            padding: 0 15px;
            border: none;
            outline: none;
            margin-bottom: 10px;
            background: rgb(232, 240, 254);
        }

        .form-wrapper #buttons_box{
            margin-top: 30px;
        }

        .form-wrapper #register_btn{
            color: rgba(0, 0, 0, 0.4);
            font-size: 14px;
        }
        .form-wrapper #login_btn{
            height: 40px;
            padding: 0 30px;
            margin-left: 10px;
            background-color: #857cda;
            cursor: pointer;
            color: #fff;
            transition: .2s linear;
        }

        .form-wrapper #login_btn:hover{
            filter: brightness(1.2);
        }

        .form-wrapper .failure{
            font-size: 13px;
            margin: 0 !important;
            color: red;
        }
    </style>
</head>
<body>
<div class="form-wrapper">
    <div class="left"></div>

    <form name="f" action="login" class="form login" method="POST">
        <h3>We are <span>SKY Training Manager</span></h3>
        <p>Welcome back! <br> Please login to continue the journey!</p>

        <input type="text" id="username" name="username" required placeholder="Username">

        <input type="password" id="password" name="password" required placeholder="Password">

        <#if flashMessageError??>
            <p class="form_alert_message failure" role="alert">&#9888; ${flashMessageError}</p>
        </#if>

        <div id="buttons_box">
            <a href="/register" id="register_btn">Create account</a>
            <input type="submit" value="Log in!" id="login_btn">
        </div>
    </form>
</div>

</body>
</html>