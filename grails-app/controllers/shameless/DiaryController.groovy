package shameless

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class DiaryController {

    static navigation = [
		group:'tabs',
		order:30,
		title:'Reporting',
		action:'index',
		isVisible: { SpringSecurityUtils.ifAnyGranted("ROLE_USER,ROLE_ADMIN") }
	]

    def index = { }
}
