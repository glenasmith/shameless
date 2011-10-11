package shameless

import spock.lang.*
import grails.plugin.spock.*

class LameNavigationTagLibSpec extends IntegrationSpec {

    def "feature method"() {

        given:
        def lameNavTag = new LameNavigationTagLib()

        when:
        def lameOut = lameNavTag.lameNav()

        then:
        lameOut.toString().startsWith("<div id='tabs'>")

    }
}
