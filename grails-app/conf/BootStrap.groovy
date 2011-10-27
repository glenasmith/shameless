import shameless.*
import grails.util.GrailsUtil

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        if (Account.count() == 0) {
            def adminRole = new Role(authority: 'ROLE_ADMIN')
            assert adminRole.save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER')
            assert userRole.save(flush: true)

            def adminUser = new Account(username: 'admin', enabled: true, password: 'admin123',
                    realName: 'Admin User', email: 'admin@bytecode.com.au')
            assert adminUser.save(flush: true)

            AccountRole.create adminUser, adminRole, true


        }

        if (PricingPlan.count() == 0) {
            assert new PricingPlan(name: 'Basic', dollarsPerMonth: 0.0).save(flush:true)
            assert new PricingPlan(name: 'Premium', dollarsPerMonth: 10.0).save(flush:true)
            assert new PricingPlan(name: 'Enterprise', dollarsPerMonth: 10000.0).save(flush:true)
        }


        environments {
            test {
                // Test specific bootstrapping of users
            }
        }

    }
    def destroy = {
    }
}
