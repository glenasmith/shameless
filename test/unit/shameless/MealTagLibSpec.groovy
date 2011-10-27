package shameless

import grails.plugin.spock.TagLibSpec
import spock.lang.Ignore

class MealTagLibSpec extends TagLibSpec {




}

//   def "ensure populated display table is working"() {
//      given:
//      def someMeals = [
//              new Meal(dateCreated: new Date(), status: "Pizza Again", badFood: true),
//              new Meal(dateCreated: new Date(), status: "Fruit Salad", badFood: false),
//              new Meal(dateCreated: new Date(), status: "Nachos", badFood: true)
//              ]
//
//      when:
//      def output = mealList(meals : someMeals)
//
//      then:
//      (output =~ /style="bad"/).count == 2
//      (output =~ /Great choice!/).count == 1
//
//    }
//
//    def "ensure empty display table is working"() {
//
//      when:
//      def output = mealList(meals: [])
//
//      then:
//      output =~ /Sorry, no posts available right now/
//
//    }
//
//     @Ignore
//     def "ensure our refactored render tag is working"() {
//      given:
//      def someMeals = [
//              new Meal(dateCreated: new Date(), status: "Pizza Again", badFood: true),
//              new Meal(dateCreated: new Date(), status: "Fruit Salad", badFood: false),
//              new Meal(dateCreated: new Date(), status: "Nachos", badFood: true)
//              ]
//
//      when:
//      def output = mealListRender(meals : someMeals)
//
//      then:
//      (output =~ /style="bad"/).count == 2
//      (output =~ /Great choice!/).count == 1
//
//    }
