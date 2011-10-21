package shameless

class MealTagLib {


    def mealList = { attrs ->

        if (attrs.meals) {

            out << '''
<table id="postlist">
<thead><tr>  <th>Date</th> <th>Meal</th> <th>Bad Food?</th> </tr></thead>
'''
            attrs.meals.each { meal ->
                out << """
      <tr>
                      <td> ${meal.dateCreated}  </td>
                      <td> ${meal.status}  </td>
                  """
                out << (meal.badFood ? ' <td style="bad">BAD BAD BAD</td> ' :
                          '<td>Great choice!</td>')
                out << '</tr>'

            }
            out << '</table>'

        } else {
            out << "  Sorry, no posts available right now"
        }
        out
    }


    def mealListRender = { attrs ->
         if (attrs.meals) {
            out << render(template: '/meal/mealTable', model:[meals: attrs.meals] )
        } else {
            out << "Sorry, no posts available right now"
        }
        out
    }


}
