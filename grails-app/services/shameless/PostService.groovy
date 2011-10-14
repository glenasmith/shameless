package shameless

class PostService {

    static transactional = true

    def getRecentPostsByUser(String userId) {

        return "glen"

    }

    Post createPost(String username, String status, boolean badFood = false, long longitude = 0, long latitude = 0) {
        Account account = Account.findByUsername(username)
        if (account) {
            Post newPost = new Post(account: account, status: status, badFood: badFood, longitude: longitude, latitude: latitude)
            if (newPost.save()) {
                return newPost
            } else {
                throw new PostException(message: "Invalid post parameter", post: newPost)
            }
        } else {
            throw new PostException(message: "Could not locate account")
        }

    }
}

class PostException extends RuntimeException {

    String message
    Post post

}
