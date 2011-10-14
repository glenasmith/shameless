<html>
<head>
    <title>The List View That Gets It So Wrong...</title>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all" />
	<link rel="stylesheet" href="http://static.jquery.com/ui/css/demo-docs-theme/ui.theme.css" type="text/css" media="all" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script>
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
