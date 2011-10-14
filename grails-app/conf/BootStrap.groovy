import shameless.*
import grails.util.GrailsUtil

class BootStrap {
	
	def springSecurityService
    def fixtureLoader

    def init = { servletContext ->

    	if (Account.count() == 0) {
//    		def adminRole = new Role(authority: 'ROLE_ADMIN')
//          assert adminRole.save(flush: true)
//      	def userRole = new Role(authority: 'ROLE_USER')
//          assert userRole.save(flush: true)
//
//      	def adminUser = new Account(username: 'admin', enabled: true, password: 'admin123', realName: 'Admin User')
//      	assert adminUser.save(flush: true)
//
//      	AccountRole.create adminUser, adminRole, true

            fixtureLoader.load("accounts")

  		}

        if (PricingPlan.count() == 0) {
            fixtureLoader.load("plans")
        }

//        assert new PricingPlan(name: 'Basic', dollarsPerMonth: 0.0)
//        assert new PricingPlan(name: 'Premium', dollarsPerMonth: 10.0)
//        assert new PricingPlan(name: 'Enterprise', dollarsPerMonth: 10000.0)
        environments {
            test {
                // Test specific bootstrapping of users
            }
        }
    	
    }
    def destroy = {
    }
}
