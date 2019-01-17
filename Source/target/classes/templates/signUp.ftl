<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>DoFilms</title>
    <link rel="stylesheet" href="<@spring.url '/css/login.css'/>" type="text/css" media="screen">
</head>

<body>

<#if errorUsername??>
    <div class="alert alert-danger" role="alert">Login</div>
</#if>
<#if errorEmail??>
    <div class="alert alert-danger" role="alert">Email</div>
</#if>
<#if errorPassword??>
    <div class="alert alert-danger" role="alert">Pass</div>
</#if>


<form class="loginForm" method='post'>
    <label class="dataLabel">Login</label>
    <input type="text" class="data" placeholder="Login" name="username">
    <label class="dataLabel">Email</label>
    <input type="email" class="data" placeholder="Email" name="email">
    <label class="dataLabel">Password</label>
    <input type="password" class="data" placeholder="Password" name="password">
    <label class="dataLabel">Confirm</label>
    <input class="data" placeholder="Confirm" type="password" name="confirm">
    <input type="submit" class="login" value="Sign Up">
</form>

</body>

</html>
