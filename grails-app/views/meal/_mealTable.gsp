<table id="mealList">
  <thead><tr><th>Date</th> <th>Meal</th> <th>Bad Food?</th></tr></thead>
  <g:each in="${mealList}" var="meal">

    <tr>
      <td>${meal.dateCreated}</td>
      <td>${meal.status}</td>

      <g:if test="${meal.badFood}">
        <td style="bad">BAD BAD BAD</td>
      </g:if>
      <g:else>
        <td>Great choice!</td>
      </g:else>

    </tr>

  </g:each>

</table>