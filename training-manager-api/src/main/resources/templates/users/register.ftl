<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
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

        .form-wrapper {
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

        .form-wrapper .left {
            width: 250px;
            min-width: 250px;
            background-image: url("https://images.pexels.com/photos/114979/pexels-photo-114979.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
            background-size: cover;
        }

        .form-wrapper form {
            display: flex;
            flex-wrap: wrap;
            width: 100%;
            padding: 20px;
        }

        .form-wrapper .form h3 {
            margin: 15px 0 5px;
            font-size: 24px;
            color: rgba(0, 0, 0, 0.5);
        }

        .form-wrapper .form h3 span {
            color: #333333;
        }

        .form-wrapper .form p {
            font-weight: 300;
            margin-bottom: 30px;
        }

        .form-wrapper .form input {
            width: 100%;
            height: 42px;
            border-radius: 16px;
            padding: 0 15px;
            border: none;
            outline: none;
            margin-bottom: 10px;
            background: rgb(232, 240, 254);
        }

        .form-wrapper #buttons_box {
            width: 100%;
            margin-top: 30px;
        }

        .form-wrapper #back_login {
            color: rgba(0, 0, 0, 0.4);
            font-size: 14px;
            line-height: 0;
        }

        .form-wrapper #login_btn {
            height: 40px;
            padding: 0 30px;
            background-color: #857cda;
            cursor: pointer;
            color: #fff;
            transition: .2s linear;
        }

        .form-wrapper #login_btn:hover {
            filter: brightness(1.2);
        }

        .form-wrapper .failure {
            display: none;
            font-size: 13px;
            margin: 0 !important;
            color: red;
        }

        .form-wrapper .form #firstname, .form-wrapper .form #lastname {
            width: 39%;
        }

        .form-wrapper .form #lastname {
            margin-left: auto;
        }
    </style>
</head>
<body>
<div class="form-wrapper">
    <div class="left"></div>

    <form class="form login" id="form">
        <a href="/login" id="back_login">&#8249; Login</a>
        <h3>We are <span>SKY Training Manager</span></h3>
        <p>Sign up to try our application!</p>

        <input type="text" required id="firstname" name="firstname" placeholder="First name">

        <input type="text" required id="lastname" name="lastname" placeholder="Last name">

        <input type="email" required id="email" name="email" placeholder="Email">

        <input type="text" required id="username" name="username" placeholder="Username">

        <input type="password" required id="password" name="password" placeholder="Password">

        <p class="form_alert_message failure" role="alert"></p>

        <div id="buttons_box">
            <input type="submit" value="Sign up!" id="login_btn">
        </div>
    </form>
</div>
<script>
    window.addEventListener('load', () => {
        document.querySelector("#form").addEventListener("submit", (e) => {
            e.preventDefault();
            const form = e.target;

            const data = {
                firstName: form.firstname.value,
                lastName: form.lastname.value,
                email: form.email.value,
                username: form.username.value,
                password: form.password.value,
            }

            fetch('/user', {
                method: 'POST',
                mode: 'cors',
                cache: 'no-cache',
                credentials: 'same-origin',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
                redirect: 'follow',
                referrerPolicy: 'no-referrer',
            }).then(function (response) {
                if(response.ok) {
                    window.location.href = "/login";
                    return response.json();
                }

                return Promise.reject();
            }).catch(function (err) {
                showError();
            });
        })

        function showError(errorMessage = 'Something went wrong :(') {
            const error = document.querySelector('#form .failure');
            error.innerHTML = '&#9888; ' + errorMessage;
            error.style.display = 'inline';
        }
    })
</script>
</body>
</html>
