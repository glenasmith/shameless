package shameless

class ReportingService {

    static transactional = true

    def badFoodsByDate(String username) {

        def badFoods = Post.withCriteria {
            createAlias("account", "a")
            eq('a.username', username)


        }
        return badFoods  // list of object[]

    }
}
