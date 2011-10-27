package shameless;
import grails.plugin.spock.*


class PasswordControllerSpec extends ControllerSpec {



}


//
//   def "check email is reset on forgotten password"() {
//      given:
//        mockDomain(Account, [new Account(username: 'glen', email: 'glen@bytecode.com.au')])
//        controller.params.userid = 'glen'
////        controller.passwordService = [ generatePassword : { "sssss "},
////                                        sendForgottenEmail : { newPw, account -> } ]
////        boolean emailWasCalled = false
//        controller.mailService = [ sendMail : { args ->  }]
//
//        when:
//        def model = controller.forgottenPassword()
//
//        then:
//        controller.flash.message == "A new password has been generated and emailed to your account"
//        controller.redirectArgs.controller == 'login'
//        controller.redirectArgs.action== 'auth'
////        emailWasCalled
//    }
//
//    def "test our new command object love"() {
//      given:
//      mockDomain(Account, [ new Account(username: 'glen', password: 'help')])
//      mockCommandObject(ChangePasswordCommand)
//      ChangePasswordCommand cpc = new ChangePasswordCommand(
//              password: 'help',
//              password_new: 'glen2',
//              password_new_2: 'glen2')
//      cpc.validate()
//      controller.springSecurityService = [ currentUser: [ username: 'glen']]
//      controller.passwordEncoder = [ isPasswordValid : { a,b,c -> a == b }]
//      cpc.passwordEncoder = controller.passwordEncoder
//
//      when:
//      def model = controller.changePassword(cpc)
//
//      then:
//      controller.flash.message == 'Password change successful'
//    }