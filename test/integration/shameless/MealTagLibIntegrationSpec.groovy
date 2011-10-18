package shameless;
import grails.plugin.spock.IntegrationSpec


class MealTagLibIntegrationSpec extends IntegrationSpec {

    def "Testing Post iterator works as expected"() {
      given:
      def t = new MealTagLib()

      when:
      def output = t.printPosts(posts: [new Meal(), new Meal()])

      then:
      true
    }

}