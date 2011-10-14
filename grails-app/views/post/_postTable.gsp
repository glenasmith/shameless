<table id="postlist">
  <thead><tr><th>Date</th> <th>Meal</th> <th>Bad Food?</th></tr></thead>
  <g:each in="${postList}" var="post">

    <tr>
      <td>${post.dateCreated}</td>
      <td>${post.status}</td>

      <g:if test="${post.badFood}">
        <td style="bad">BAD BAD BAD</td>
      </g:if>
      <g:else>
        <td>Great choice!</td>
      </g:else>

    </tr>

  </g:each>

</table>