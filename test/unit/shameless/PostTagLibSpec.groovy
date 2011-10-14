package shameless

import grails.plugin.spock.TagLibSpec

class PostTagLibSpec extends TagLibSpec {

    def "Basic tag lib tester"() {
      given:
      def posts = [new Post(), new Post(), new Post()]


      when:
      def output = displayPostList(posts : posts)

      then:
      output == "Good times"
    }
}
