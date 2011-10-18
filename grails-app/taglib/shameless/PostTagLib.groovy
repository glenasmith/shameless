package shameless

class PostTagLib {

    def postTable = { attrs ->

        if (attrs.posts) {
            out << '''
<table id="postlist">
<thead><tr>  <th>Date</th> <th>Meal</th> <th>Bad Food?</th> </tr></thead>
'''
            attrs.posts.each { post ->
                out << """
<tr>
      <td> ${post.dateCreated}  </td>
      <td> ${post.status}  </td>
"""
                out << (post.badFood ? '<td style="bad">BAD BAD BAD</td>' : '<td>Great choice!</td>')
            }
        } else {
            out << "Sorry, no posts available right now"
        }
        out

    }


    def postTableRender = { attrs ->
         if (attrs.posts) {
            out << render(template: '/meal/mealTable', model:[posts: attrs.posts] )
        } else {
            out << "Sorry, no posts available right now"
        }
        out
    }

}
