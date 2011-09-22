<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="layout" content="main"/>
  </head>

  <body>
  	
   	  <div class="nav">
   	  	<g:lameNav/>
   	  </div>

      <div id="masthead">
        <h1>SeeFoodDiet</h1>
        <p>The Visual Food Diary that will change your life</p>
      </div>

      <div class="foods">
      	<g:each var="post" in="${recentPosts}">
      		${post.status} ${post.dateCreated}<br/>
      	</g:each>
      </div>

      

    </div>

  </body>
</html>
