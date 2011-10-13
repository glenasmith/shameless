package shameless

class PostTagLib {

    def printPosts = { attrs ->

           attrs.posts?.each { post ->
               out << "glen"
           }
        out << "Good times"
    }

}
