<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>DoFilms</title>
    <link rel="stylesheet" href="<@spring.url '/css/default.css'/>" type="text/css" media="screen">
    <link rel="stylesheet" href="<@spring.url '/css/style.css'/>" type="text/css">
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

<form method='post' class='reg-form'>

    <h1>Registration</h1>
    <br>
    <div class='form-row'>
        <label for='form_username'>Username: </label>
        <input type='text' id='form_username' name='username'>
    </div>

    <div class='form-row'>
        <label for='form_email'>Email: </label>
        <input type='email' id='form_email' name='email'>
    </div>

    <div class='form-row'>
        <label for='form_password'>Password: </label>
        <input type='password' id='form_password' name='password'>
    </div>

    <div class='form-row'>
        <label for='form_confirm'>Confirm: </label>
        <input type='password' id='form_confirm' name='confirm'>
    </div>

    <div class="form-row">
        <input type="submit" value='Sign Up'>
    </div>

</form>
</body>

</html>
