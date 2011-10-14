package shameless

import grails.plugin.spock.TagLibSpec

class PostTagLibSpec extends TagLibSpec {

    def "ensure populated display table is working"() {
      given:
      def posts = [
              new Post(dateCreated: new Date(), status: "Pizza Again", badFood: true),
              new Post(dateCreated: new Date(), status: "Fruit Salad", badFood: false),
              new Post(dateCreated: new Date(), status: "Nachos", badFood: true)
              ]

      when:
      def output = postTable(posts : posts)

      then:
      (output =~ /style="bad"/).count == 2
      (output =~ /Great choice!/).count == 1

    }

    def "ensure empty display table is working"() {

      when:
      def output = postTable(posts: [])

      then:
      output =~ /Sorry, no posts available right now/

    }


     def "ensure our refactored render tag is working"() {
      given:
      def posts = [
              new Post(dateCreated: new Date(), status: "Pizza Again", badFood: true),
              new Post(dateCreated: new Date(), status: "Fruit Salad", badFood: false),
              new Post(dateCreated: new Date(), status: "Nachos", badFood: true)
              ]

      when:
      def output = postTableRender(posts : posts)

      then:
      (output =~ /style="bad"/).count == 2
      (output =~ /Great choice!/).count == 1

    }


}
