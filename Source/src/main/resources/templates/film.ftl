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
            <a href="/myFilm">My films</a>g
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
        <div class="films">
            <h1>${filmFromServer.title}</h1>
            <h2>Genres: ${filmFromServer.getGenres()}</h2>
            <h2>Year: ${filmFromServer.getYear()}</h2>
            <h2>Directors: ${filmFromServer.getDirectors()}</h2>
            <h2>Stars: ${filmFromServer.getStars()}</h2>
            <h2><#if filmFromServer.averageRate?has_content>
                    Rating: ${filmFromServer.getAverageRate()}/10.0
                <#else>
                    This film has no ratings yet.
                </#if></h2>
            <br/>
        </div>
    </div>
    <div class="right">
    </div>
</div>
</body>
</html>
