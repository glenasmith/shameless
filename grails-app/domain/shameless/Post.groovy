package shameless

class Post {
	
	Date dateCreated
	String status
	
	String longitude
	String latitude
	
	Account account
	
	static hasMany = [pictures:Picture]

    static constraints = {
    	status maxSize: 1024, nullable: true
    	longitude nullable: true
    	latitude nullable: true
    }
    
    
}
