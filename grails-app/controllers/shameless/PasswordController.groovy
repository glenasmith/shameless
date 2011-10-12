package shameless

class PasswordController {

    def mailService
    def springSecurityService
    def passwordEncoder

    def forgottenPassword = {

        // find user
        // do complex calculation
        // invoke service to send password with inlined html
        // Refactor to service with methods for generatePassword

       if (params.userid) {

            def account = Account.findByUsername(params.userid)
            if (account && account.email) {

                def PW_POOL = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ"
                def genPw = ""
                8.times {

                    genPw += PW_POOL[new Random().nextInt(PW_POOL.size() -1)]

                }
                account.password = genPw
                def msg = """
		        	<h1>seefooddiet Password Reset</h1>
		        	<p>
		            Hi ${account.username}, we've reset your password to: <b>${genPw}</b>.
					You need to type in the letters in upper case.
					Once you've logged on you can change it to something you prefer
					by going into the "Account" tab.
		            </p>
					<p>
					Glen Smith - SeeFoodDiet.com
					</p>
		            """
                sendMail {
                    to account.email
                    subject "Password Reset"
                    body msg
                }
                flash.message = "A new password has been generated and emailed to your account"
                redirect(controller: 'entries')
            } else {
                flash.message = "Could not locate your account."
            }

        }
    }
    def changePassword = {

        // copy and paste spring sample here
        //String username = session['SPRING_SECURITY_LAST_USERNAME']
        String username = springSecurityService.currentUser?.username
        if (!username) {
            flash.message = 'Sorry, an error has occurred'
            redirect controller: 'login', action: 'auth'
            return
        }
        String password = params.password
        String newPassword = params.password_new
        String newPassword2 = params.password_new_2
        if (!password || !newPassword || !newPassword2 || newPassword != newPassword2) {
            flash.message = 'Please enter your current password and a valid new password'
            render view: 'passwordExpired', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        Account user = Account.findByUsername(username)
        if (!passwordEncoder.isPasswordValid(user.password, password, null /*salt*/)) {
            flash.message = 'Current password is incorrect'
            render view: 'passwordExpired', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        if (passwordEncoder.isPasswordValid(user.password, newPassword, null /*salt*/)) {
            flash.message = 'Please choose a different password from your current one'
            render view: 'passwordExpired', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        user.password = newPassword
        user.passwordExpired = false
        user.save() // if you have password constraints check them here
        flash.message = 'Password change successful'

        redirect controller: 'login', action: 'auth'


    }
}
