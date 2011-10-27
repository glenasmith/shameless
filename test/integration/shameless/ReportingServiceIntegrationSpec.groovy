package shameless;
import grails.plugin.spock.IntegrationSpec


class ReportingServiceIntegrationSpec extends IntegrationSpec {

    def reportingService


}

//
//    def "bad foods for user filters correctly"() {
//        given:
//        def glen = new Account(username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
//        glen.save()
//        new Meal(account: glen, status: 'Cake was awesome', badFood: true).save(flush: true)
//        new Meal(account: glen, status: 'Veggies soup for lunch', badFood: false).save(flush: true)
//        new Meal(account: glen, status: 'Pizza was very nice', badFood: true).save(flush: true)
//
//        when:
//        def result = reportingService.badFoodsForUser("glen")
//
//        then:
//        Meal.list().size() == 3
//        result.size() == 2
//    }
//
//
//    def "bad foods count correctly by user"() {
//        given:
//        fixtureLoader.load {
//            glen(Account, username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
//            post1(Meal, account: glen, status: 'Cake was awesome', badFood: true)
//            post2(Meal, account: glen, status: 'Veggies soup for lunch', badFood: false)
//            post3(Meal, account: glen, status: 'Pizza was very nice', badFood: true)
//        }.load {
//            peter(Account, username: 'peter', email: 'peter@vmware.com.au', realName: 'Peter', password: 'hiya')
//            post4(Meal, account: peter, status: 'Apple for snacks', badFood: false)
//            post5(Meal, account: peter, status: 'Veggies soup for lunch', badFood: false)
//            post6(Meal, account: peter, status: 'Pizza was very nice', badFood: true)
//        }
//        when:
//        def results = reportingService.badFoodsCountByUser()
//
//        then:
//        Meal.list().size() == 6
//        results == [['glen', 2], ['peter', 1]]
//    }

