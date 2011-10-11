package shameless

// Lucas Ward's example
// from http://www.lucasward.net/2011/03/disabling-spring-security-for-grails.html

class StubSpringSecurityService {

    def currentUser

    Object getCurrentUser() {
        return currentUser
    }

    String encodePassword(String password, salt = null) {
        return password
    }

}
