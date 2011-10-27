package shameless;
import grails.plugin.spock.IntegrationSpec


class MealTagLibIntegrationSpec extends IntegrationSpec {

    def fixtureLoader

    def "Fine grain render testing"() {
      given:
      fixtureLoader.load {
               glen(Account, username: 'glen', email: 'glen@bytecode.com.au', realName: 'Glen', password: 'hiya')
               meal1(Meal, account: glen, status: 'Cake was awesome', badFood: true)
               meal2(Meal, account: glen, status: 'Veggies soup for lunch', badFood: false)
               meal3(Meal, account: glen, status: 'Pizza was very nice', badFood: true)
      }
      def mealTagLib = new MealTagLib()

      when:
      def output = mealTagLib.mealListRender(meals: Meal.list())

      then:
      (output =~ /style="bad"/).count == 2
      (output =~ /Great choice!/).count == 1
    }

}