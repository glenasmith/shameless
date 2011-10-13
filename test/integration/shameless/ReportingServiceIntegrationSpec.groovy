package shameless;
import grails.plugin.spock.IntegrationSpec


class ReportingServiceIntegrationSpec extends IntegrationSpec {

    def fixtureLoader
    def reportingService


    def "bad foods returning correctly"() {
      given:
      fixtureLoader.load {
          glen(Account, username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
          post(Post, account: glen, status: 'Cake was awesome', badFood: true)
          post(Post, account: glen, status: 'Vegies soup for lunch', badFood: true)
          post(Post, account: glen, status: 'Pizza was very nice', badFood: true)
      }


      when:
      def result = reportingService.badFoodsForUser("glen")

      then:
      result.dump() == 2
    }

}