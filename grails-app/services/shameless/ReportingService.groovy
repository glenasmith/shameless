package shameless

class ReportingService {

    static transactional = true

    def badFoodsForUser(String username) {

        def badFoods = Post.withCriteria {
            createAlias("account", "a")
            and {
                eq('a.username', username)
                eq("badFood", true)
            }

        }
        return badFoods  // list of Post

    }

    def badFoodsCountByUser() {

        def badFoods = Post.withCriteria {
            createAlias("account", "a")
            eq("badFood", true)
            projections {
                groupProperty 'a.username'
                count 'a.username'
            }
            order('a.username')


        }
        return badFoods  // list of object[]
    }
}
