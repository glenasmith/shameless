import shameless.*
import grails.util.GrailsUtil

class BootStrap {
	
	def springSecurityService
    def fixtureLoader

    def init = { servletContext ->


//        if (GrailsUtil.environment == "test") {
//              def testUser = new Account(username: 'admin', realName: "Test Admin", password: 'test', enabled: true)
//              testUser.save(failOnError: true)
//              springSecurityService.currentUser = testUser;
//        }



    	if (Account.count() == 0) {
//    		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
//      		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
//
//      		def adminUser = new Account(username: 'admin', enabled: true, password: 'admin123', realName: 'Admin User')
//      		adminUser.save(flush: true)
//
//      		AccountRole.create adminUser, adminRole, true

            fixtureLoader.load("accounts")

  		}


    	
    	
    }
    def destroy = {
    }
}
