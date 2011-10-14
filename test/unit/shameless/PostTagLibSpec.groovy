package shameless

import grails.plugin.spock.TagLibSpec

class PostTagLibSpec extends TagLibSpec {

    def "ensure display table is working"() {
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
}
