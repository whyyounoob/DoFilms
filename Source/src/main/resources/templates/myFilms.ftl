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
            <a href="/myFilms">My films</a>
            <a href="/schedule">Movie schedule</a>
            <a href="/lastFilm">Last film</a>
        </div>
    </div>
    <div class="right">
        <#if userDto??>
            <h1>${userDto.username}</h1>
        <#else>
            <a href="/login">Sign In</a>
            or
            <a href="/signUp">Sign Up</a>
        </#if>
    </div>
</div>
<br/>

<div class="container">
    <div class="right">
        <form action="/search" method="post">
            <label for='search'>Search: </label>
            <p></p>
            <input type='text' id='search' name='search'>
            <div>
                <input type="radio" id="genre" name="searchType" value="genre"
                       checked>
                <label for="genre">Genre</label>
            </div>

            <div>
                <input type="radio" id="name" name="searchType" value="name">
                <label for="name">Name</label>
            </div>

            <input type="submit" value="Search">
        </form>
    </div>
    <div class="left">
        <#list filmsFromServer as film>
            <div class="films">
                <h1>${film.getFilm().title}</h1>
                <h2>Genre: ${film.getFilm().getGenres()}</h2>
                <h2>Year: ${film.getFilm().getYear()}</h2>
                <h2><#if film.getFilm().averageRate?has_content>
                        ${film.getFilm().getAverageRate()}/10.0
                    <#else>
                        This film has no ratings yet.
                    </#if></h2>
                <a href="/${film.getFilm().id}">watch more</a>
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
