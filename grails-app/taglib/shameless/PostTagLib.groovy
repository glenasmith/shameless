package shameless

class PostTagLib {

    def displayPostList = { attrs ->

           attrs.posts?.each { post ->
               out << "glen"
           }
        out << "Good times"
    }

}
