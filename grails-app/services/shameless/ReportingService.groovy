package shameless

class ReportingService {

    static transactional = true

    def badFoodsForUser(String username) {

        def badFoods = Post.withCriteria {
            createAlias("account", "a")
            eq('a.username', username)
            eq("badFood", true)

        }
        return badFoods  // list of object[]

    }

    def badFoodsPerUser() {

        def badFoods = Post.withCriteria {
            createAlias("account", "a")
            eq("badFood", true)
            projections {
                groupProperty 'a.username'
                count 'a.username'
            }


        }
        return badFoods  // list of object[]
    }
}
