package shameless;
import grails.plugin.spock.IntegrationSpec


class PostTagLibIntegrationSpec extends IntegrationSpec {

    def "Testing Post iterator works as expected"() {
      given:
      def t = new PostTagLib()

      when:
      def output = t.printPosts(posts: [new Post(), new Post()])

      then:
      true
    }

}