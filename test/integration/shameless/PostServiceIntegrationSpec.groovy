package shameless;
import grails.plugin.spock.IntegrationSpec
import spock.lang.Unroll


class PostServiceIntegrationSpec extends IntegrationSpec {

    def postService


    @Unroll
    def "Test basic user retrieval"() {

      when:
      def userName = postService.getRecentPostsByUser(userId)

      then:
      userName == result

      where:
      userId | result
      "glen" | "glen"
      "joe"  | "glen"

    }

}