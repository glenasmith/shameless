<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="layout" content="main"/>
    <r:require module="dashboard"/>
  </head>

  <body>
  	
   	  <div class="nav">
   	  	<g:lameNav/>
   	  </div>

      <div id="masthead">
        <h1>SeeFoodDiet</h1>
        <p>We are what you eat!</p>
      </div>

      <div class="foods">
      	<g:each var="post" in="${recentPosts}">
      		
      		<g:each var="picId" in="${post.pictureIds}">
      			<!-- <img src='<g:createLink controller="dashboard" action="renderImage" id="${picId}"/>' style="width: 100px;" title="${post.status} ${post.dateCreated} "/> -->
      		</g:each>
      		
      	</g:each>
      </div>
      
      <input type="button" name="Refresh" value="Refresh" id="bbRefresh"/>
      <div id="bbfoods">
      	
      </div>
      

      

    </div>
<script>
	var POST = {
		create: '<g:createLink controller="post" action="create"/>',
		read: '<g:createLink controller="post" action="read"/>',
		update: '<g:createLink controller="post" action="update"/>',
		delete: '<g:createLink controller="post" action="delete"/>'
	}
</script>
  </body>

</html>
