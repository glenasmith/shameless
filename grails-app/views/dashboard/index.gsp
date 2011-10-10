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

		<%--
		// Step 1 Refactor: Move this logic to a template
		// Step 2 Refactor: Move this render to an ajax call with div replace of html
		// Step 3 Refactor: Look at perils of hacking JS into it
		// Step 4 Refactor: Replace all this with a backbone.js model/veiw/controller
		// Step 5 Refactor: Get fancy with routers and back button
		
      <div class="foods">
      	<g:each var="post" in="${recentPosts}">
      		
      		<g:each var="picId" in="${post.pictureIds}">
      			<img src='<g:createLink controller="dashboard" action="renderImage" id="${picId}"/>' style="width: 100px;" title="${post.status} ${post.dateCreated} "/>
      		</g:each>
      		
      	</g:each>
      </div>
      --%>
      <div id="bbToolbar">

      </div>

      <div id="bbBody">

      	
      </div>
      

      

    </div>
<script>
	var POST = {
		api: '<g:resource dir="post"/>'
	}
</script>

<script type="text/template" id="rowTemplate">	
	<td> <a href="#post/{{id}}"> {{ status }} </a>  </td> <td>  {{ dateCreated }}  </td> <td>WIN</td>  <td> <button type="button" class="delete" name="delete">Delete</button> </td> <td> <button type="button" class="edit" name="edit">Edit</button> </td>
</script>

<script type="text/template" id="mainToolbarTemplate">
  <button name="addEntry" id="addEntry">Add Entry</button>
</script>

<script type="text/template" id="detailToolbarTemplate">
    <button name="close" id="closeEntry">Close Entry</button>
</script>

<script type="text/template" id="detailTemplate">
	<p>{{ status }} {{ dateCreated }}</p>
</script>



<div id="dialog-form" title="Edit Status" style="display: none;">

	<form>
	<fieldset>
		<label for="name">Status</label>
		<input type="text" name="status" id="status" class="text ui-widget-content ui-corner-all" />
		<label for="email">Picture</label>
		<img id="thePicture"/>
	</fieldset>
	</form>
</div>

  </body>

</html>
