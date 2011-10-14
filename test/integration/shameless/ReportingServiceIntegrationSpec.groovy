package shameless;
import grails.plugin.spock.IntegrationSpec


class ReportingServiceIntegrationSpec extends IntegrationSpec {

    def fixtureLoader
    def reportingService

    def "bad foods for user filters correctly"() {
        given:
        def glen = new Account(username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
        glen.save()
        new Post(account: glen, status: 'Cake was awesome', badFood: true).save(flush: true)
        new Post(account: glen, status: 'Veggies soup for lunch', badFood: false).save(flush: true)
        new Post(account: glen, status: 'Pizza was very nice', badFood: true).save(flush: true)

        when:
        def result = reportingService.badFoodsForUser("glen")

        then:
        Post.list().size() == 3
        result.size() == 2
    }

// A nicer way of sparking the test data above...
//fixtureLoader.load {
//    glen(Account, username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
//    post1(Post, account: glen, status: 'Cake was awesome', badFood: true)
//    post2(Post, account: glen, status: 'Veggies soup for lunch', badFood: false)
//    post3(Post, account: glen, status: 'Pizza was very nice', badFood: true)
//}


    def "bad foods count correctly by user"() {
        given:
        fixtureLoader.load {
            glen(Account, username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
            post1(Post, account: glen, status: 'Cake was awesome', badFood: true)
            post2(Post, account: glen, status: 'Veggies soup for lunch', badFood: false)
            post3(Post, account: glen, status: 'Pizza was very nice', badFood: true)
        }.load {
            peter(Account, username: 'peter', email: 'peter@vmware.com.au', realName: 'Peter', password: 'hiya')
            post4(Post, account: peter, status: 'Apple for snacks', badFood: false)
            post5(Post, account: peter, status: 'Veggies soup for lunch', badFood: false)
            post6(Post, account: peter, status: 'Pizza was very nice', badFood: true)
        }
        when:
        def results = reportingService.badFoodsCountByUser()

        then:
        Post.list().size() == 6
        results == [['glen', 2], ['peter', 1]]
    }
}

