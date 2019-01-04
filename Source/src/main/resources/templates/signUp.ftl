<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>DoFilms</title>
    <link rel="stylesheet" href="<@spring.url '/css/default.css'/>" type="text/css" media="screen">
    <link rel="stylesheet" href="<@spring.url '/css/style.css'/>" type="text/css">
</head>
<body>
<div class="top">
    <div class="header">
        <div class="left">
            <ul>
                <li>
                    <h2>News portal</h2>
                </li>
                <li>
                    <form method="get" action="/search">
                        <#if request??>
                            <input class="input-field" type="text" id="request" name="request"
                                   value="${request}" placeholder="Search here...">
                        <#else>
                             <input class="input-field" type="text" id="request" name="request"
                                    placeholder="Search here...">
                        </#if>
                    </form>
                </li>
            </ul>
        </div>
        <div class="right">
            <#if userDto??>
                <h3>Login: ${userDto.login}</h3>
                <h3>Name: ${userDto.firstName} ${userDto.lastName}</h3>
            <#else>
            </#if>
        </div>
    </div>
</div>
<br/>
<div class="container">
<#if userDto??>
<div class="navigation">
    <a href="/add_news">Add news</a>
    <a href="/add_user">Add user</a>
    <a href="/logout">Sign out</a>
</div>
</#if>
    <div class="main">
        <div class="add-news">
            <#if message??>
                <h2 style="color: red;">${message}</h2>
            </#if>
            <form action="/add_user" method="post">
                <br/>
                <label>Login:
                    <br/><input type="text" name="login"/>
                </label>
                <br/><br/>
                <label>Password:
                    <br/><input type="password" name="password"/>
                </label>
                <br/><br/>
                <label>First name:
                    <br/><input type="text" name="firstName"/>
                </label>
                <br/><br/>
                <label>Last name:
                    <br/><input type="text" name="lastName"/>
                </label>
                <br/> <br/>
                <div class="button"><input type="submit" value="Add user"></div>
            </form>
            <br/>
        </div>

</body>
</html>
