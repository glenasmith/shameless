package shameless

class ChangePasswordCommand {

    String password
    String password_new
    String password_new_2

    static constraints = {
		password(blank:false)
		password_new(blank:false, validator: { val, obj ->
			obj.password_new_2 == val &&  // they don't match or
                    obj.password != val   // they match the existing password
		})
        password_new_2(blank:false)
	}


}
