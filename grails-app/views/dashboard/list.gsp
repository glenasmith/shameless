<html>
<head>
    <title>Sample Horror List</title>
    <meta name="layout" content="main"/>
</head>
<body>

<g:each in="${postList}" var="post" status="i">

    <g:if test="${i == 0}">
        Writeout Table Headers
    </g:if>
    <g:if test="${post.badFood}">
        <!-- Bad foods get stripes -->
        <g:if test="${badFoodCount > 3}">
            Us a g:createLink in here so we know it bangs on unit tests?
            <!-- All bad foods now get redder -->

        </g:if>
    </g:if>


</g:each>

</body>
</html>
