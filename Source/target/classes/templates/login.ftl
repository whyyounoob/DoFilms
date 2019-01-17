<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>DoFilms</title>
    <link rel="stylesheet" href="<@spring.url '/css/login.css'/>" type="text/css" media="screen">
</head>

<body>

<#if error??>
    <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>


<div class="wrap">
    <form class="loginForm" method='post'>
        <label class="dataLabel">Login</label>
        <input type="text" class="data" placeholder="Login" name="username">
        <label class="dataLabel">Password</label>
        <input class="data" placeholder="Password" type="password" name="password">
        <input type="submit" class="login" value="Login">
    </form>
</div>

</body>

</html>
