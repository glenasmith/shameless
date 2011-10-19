<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="layout" content="seefoodapp"/>
    <r:require module="backboneDashboard"/>
  </head>

  <body>

  <div class="page-header">
          <h1><sec:username/>'s Plate <small>For the last few days...</small></h1>
        </div>
        <div class="row">
          <div class="span12">
            <h2>Recent Eats</h2>

            <ul id="mealList" class="media-grid" >

            </ul>


          </div>
          <div class="span3">
            <h3>Recent Fails</h3>
            <ul class="media-grid">



            </ul>
          </div>
        </div>


<script>
	var MEAL = {
		api: '<g:resource dir="meal"/>'
	}
</script>


<script type="text/template" id="mealTemplate">

<a href="#meal/{{id}}">

    <img class="thumbnail"
         src='<g:createLink controller="dashboard" action="renderImage"/>/{{pictures.0.id}}'
         title="{{status}} {{ dateCreated }} " style="width: 205px; height: 150px;"/>
    <input type="checkbox">Bad Foods</input>

</a>

</script>

<script type="text/template" id="detailTemplate">
    <p><image src="${g.createLink(controller: 'dashboard', action:'renderImage')}/{{id}}" title="{{status}}" width=500 height=300/></p>
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
