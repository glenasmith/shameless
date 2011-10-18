package shameless

class MealService {

    static transactional = true

    def getRecentPostsByUser(String userId) {

        return "glen"

    }

    Meal createPost(String username, String status, boolean badFood = false, long longitude = 0, long latitude = 0) {
        Account account = Account.findByUsername(username)
        if (account) {
            Meal newPost = new Meal(account: account, status: status, badFood: badFood, longitude: longitude, latitude: latitude)
            if (newPost.save()) {
                return newPost
            } else {
                throw new MealException(message: "Invalid post parameter", post: newPost)
            }
        } else {
            throw new MealException(message: "Could not locate account")
        }

    }
}

class MealException extends RuntimeException {

    String message
    Meal post

}
