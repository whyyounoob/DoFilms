<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>DoFilms</title>
    <link rel="stylesheet" href="<@spring.url '/css/default.css'/>" type="text/css" media="screen">
    <link rel="stylesheet" href="<@spring.url '/css/style.css'/>" type="text/css">
</head>
<body>
<div class="header">
    <div class="left">
        <div class="navigation">
            <a href="/top100">Top 100</a>
            <a href="/random">Random Films</a>
            <a href="/myFilm">My films</a>
            <a href="/schedule">Movie schedule</a>
            <a href="/lastFilm">Last film</a>
        </div>
    </div>
    <div class="right">
        <#if userDto??>
            <h1>${userDto.login}</h1>
        <#else>
            <a href="/logIn">Sign In</a>
            or
            <a href="/signUp">Sign Up</a>
        </#if>
    </div>
</div>
<br/>

<div class="container">
    <div class="left">
        <#list filmsFromServer as film>
            <div class="films">
                <h1>${film.title}</h1>
                <h2>Genre: ${film.getGenres()}</h2>
                <h2>Year: ${film.getYear()}</h2>
                <h2><#if film.averageRate?has_content>
                    ${film.getAverageRate()}/10.0
                <#else>
                    This film has no ratings yet.
                    </#if></h2>
                <a href="/${film.id}">watch more</a>
                <br/>
            </div>
            <br/>
        </#list>
    </div>
    <div class="right">
    </div>
</div>
</body>
</html>
