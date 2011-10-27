package shameless

import spock.lang.*
import grails.plugin.spock.*

class LameNavigationTagLibSpec extends IntegrationSpec {

    def "Check lame navigation generation is generating links"() {

        given:
        def lameNavTag = new LameNavigationTagLib()

        when:
        def lameOut = lameNavTag.lameNav()

        then:
        lameOut.startsWith("<div id='tabs'>")
        (lameOut =~ /a href='/).count == 3
    }
}
