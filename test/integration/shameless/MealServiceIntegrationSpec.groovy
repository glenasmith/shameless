package shameless;
import grails.plugin.spock.IntegrationSpec
import spock.lang.Unroll


class MealServiceIntegrationSpec extends IntegrationSpec {

    def mealService


    @Unroll
    def "Test basic user retrieval"() {

      when:
      def userName = mealService.getRecentPostsByUser(userId)

      then:
      userName == result

      where:
      userId | result
      "glen" | "glen"
      "joe"  | "glen"

    }

}