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
            <#if rate?has_content>
                <h2> Your rate: ${rate}</h2>
            <#else>
                <form method="post" action="/add">
                    <select size="1" name="yourRate">
                        <option disabled>Choose your rate</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                    <p></p>
                    <div class="selectbtn">
                        <input type="submit" value="Add film">
                    </div>
                </form>
                <p></p>
                <form method="post" action="/addSchedule">
                    <div class="selectbtn">
                        <input type="submit" value="Watch later">
                    </div>
                </form>
            </#if>
            <br/>
        </div>
    </div>
    <div class="right">
    </div>
</div>
</body>
</html>
