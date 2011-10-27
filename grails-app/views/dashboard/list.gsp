<html>
<head>
    <title>The List View That Gets It So Wrong...</title>
    <meta name="layout" content="main"/>
    <g:javascript src="jquery.js"/>
    <g:javascript src="jquery.jqplot.js"/>
    <g:javascript src="jqplot-plugins/jqplot.barRenderer.min.js"/>
    <g:javascript src="jqplot-plugins/jqplot.categoryAxisRenderer.min.js"/>
    <g:javascript src="jqplot-plugins/jqplot.pointLabels.min.js"/>
    <link rel="stylesheet" type="text/css" href="${g.resource(dir: 'css', file: 'jquery.jqplot.css')}" />
   </head>
<body>

<h2>Recently On Your Plate</h2>

It's time to get accountable with yourself. Here's what's been in your diet lately....

<g:if test="${postList}">
  <table id="postlist">
  <g:each in="${postList}" var="post" status="i">

      <g:if test="${i == 0}">
        <thead><tr>  <th>Date</th> <th>Meal</th> <th>Bad Food?</th> </tr></thead>
      </g:if>

      <tr>
      <td> ${post.dateCreated}  </td>
      <td> ${post.status}  </td>

      <g:if test="${post.badFood}">
        <td style="bad">BAD BAD BAD</td>
      </g:if>
      <g:else>
        <td>Great choice!</td>
      </g:else>

      </tr>

  </g:each>

  </table>
</g:if>
<g:else>
  Sorry, no posts available right now
</g:else>

</body>
</html>
