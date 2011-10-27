package shameless;
import grails.plugin.spock.UnitSpec
import spock.lang.Unroll


class ChangePasswordCommandSpec extends UnitSpec {




}

//
//   @Unroll("The #oldone changed to #newone with #newone2")
//    def "Check passwords follow change rules"() {
//      given:
//      mockForConstraintsTests(ChangePasswordCommand)
//      //def cpc = new ChangePasswordCommand(password: "old", password_new: "new", password_new_2: "new" )
//      def cpc = new ChangePasswordCommand(password: oldone, password_new: newone, password_new_2: newone2 )
//
//      when:
//      def result = cpc.validate()
//
//      then:
//      result == valid
//      cpc.hasErrors() == !valid
//
//      where:
//      oldone    |   newone      |   newone2     |   valid
//       "old"    |   "new"       |   "new2"      |   false
//       "old"    |   "new"       |   "new"       |   true
//       "old"    |   "old"       |   "old"       |   false
//    }