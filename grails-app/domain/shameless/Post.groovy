package shameless

class Post {
	
	Date dateCreated
	String status
	byte[] picture
	String longitude
	String latitude
	
	Account account

    static constraints = {
    	status maxSize: 1024, nullable: true
    	picture maxSize: 10240000, nullable: true
    	longitude nullable: true
    	latitude nullable: true
    }
}
