package shameless

class ChangePasswordCommand {

    def passwordEncoder

    String password
    String password_new
    String password_new_2

    boolean currentPasswordCorrect(dbPassword) {

        return passwordEncoder.isPasswordValid(dbPassword, password, null /*salt*/)
    }



    static constraints = {
		password(blank:false)
		password_new(blank:false)
        password_new_2(blank:false, validator: { val, obj ->
			obj.password_new == val &&  // they new passwords match and
                    obj.password != val   // they don't match the existing password
		})
	}


}
