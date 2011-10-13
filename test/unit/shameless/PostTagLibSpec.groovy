package shameless

import grails.test.*
import grails.plugin.spock.UnitSpec
import grails.plugin.spock.TagLibSpec

class PostTagLibSpec extends TagLibSpec {

    def "Basic tag lib tester"() {
      given:
      def posts = [new Post(), new Post(), new Post()]


      when:
      def output = printPosts(posts : posts)

      then:
      output == "Good times"
    }
}
