<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="layout" content="main"/>
    <%-- <r:require module="jqPlot"/>  --%>
    <g:javascript src="jquery.js"/>
    <g:javascript src="jquery.jqplot.js"/>
    <link rel="stylesheet" type="text/css" href="${g.resource(dir: 'css', file: 'jquery.jqplot.css')}" />
    <style>
        li { display: inline; }
        .leftcol {
            width: 720px;
            float: left;
        }
        .rightcol {
            float: right;
            width: 180px;
        }
    </style>
  </head>

  <body>

  <div class="page-header">
          <h1><sec:username/>'s Plate <small>For the last few days...</small></h1>
        </div>
        <div class="row">
          <div class="leftcol">
            <h2>Recent Eats</h2>
            <ul class="media-grid">

              <g:each var="meal" in="${recentMeals}" status="i">
                <li><a href="#">
                  <g:each var="picId" in="${meal.pictureIds}">

                    <img class="thumbnail"
                         src='<g:createLink controller="dashboard" action="renderImage" id="${picId.id}"/>'
                         title="${meal.status} ${meal.dateCreated} " style="width: 205px; height: 150px;"/>

                  </g:each>
                </a></li>

              </g:each>

            </ul>


          </div>
          <div class="rightcol">
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

            <h3>Visual Fail</h3>
            <div id="chartdiv" style="height:150px;width:150px; "></div>
          </div>
        </div>

  <script language="JavaScript">
      $(document).ready(function(){
            $.jqplot('chartdiv',  [[[1, 2],[3,5.12],[5,13.1],[7,33.6],[9,85.9],[11,219.9]]]);
      });

  </script>

  <%--
  <r:script>
      $.jqplot('chartdiv',  [[[1, 2],[3,5.12],[5,13.1],[7,33.6],[9,85.9],[11,219.9]]]);
  </r:script>
  --%>


  </body>

</html>
