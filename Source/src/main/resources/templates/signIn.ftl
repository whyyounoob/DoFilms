<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>DoFilms</title>
    <link rel="stylesheet" href="<@spring.url '/css/default.css'/>" type="text/css" media="screen">
    <link rel="stylesheet" href="<@spring.url '/css/style.css'/>" type="text/css">
</head>

<body>


<form method='post' class='reg-form'>

    <h1>Log In</h1>
    <br>
    <div class='form-row'>
        <label for='form_username'>Username: </label>
        <input type='text' id='form_username' name='username'>
    </div>

    <div class='form-row'>
        <label for='form_password'>Password: </label>
        <input type='password' id='from_password' name='password'>
    </div>

    <div class="form-row">
        <input type="submit" value='Sign In'>
    </div>

</form>
</body>

</html>
