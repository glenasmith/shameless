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

                <g:each var="meal" in="${badMeals}">
                <li><a href="#">
                  <g:each var="picId" in="${meal.pictureIds}">

                    <img class="thumbnail"
                         src='<g:createLink controller="dashboard" action="renderImage" id="${picId.id}"/>'
                         title="${meal.status} ${meal.dateCreated} " style="width: 70px; height: 50px;"/>
                  </g:each>
                </a></li>

              </g:each>



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
    <input class="statusField span3" name="status" value="{{ status }}"> <br/>
    <button class="delete btn" name="Delete">Delete</button>
    <input class="toggleBad" type="checkbox" {{#if badFood}}CHECKED{{/if}}>Bad Food</input>

</a>

</script>

<script type="text/template" id="detailTemplate">
    <p><image src="${g.createLink(controller: 'dashboard', action:'renderImage')}/{{id}}" title="{{status}}" width=500 height=300/></p>
	<h2>{{ status }} <small>{{ dateCreated }}</small></h2>
    <button id="closeDetail" name="closeDetail" class="btn primary">Close</button>
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
