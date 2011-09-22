package shameless

class Post {
	
	Date dateCreated
	String status
	
	String longitude
	String latitude
	
	Account account
	
	Set<String> getPictureIds() {
		(pictures*.id).sort { a,b -> a <=> b} // sort in ascending ids
	}
	
	static hasMany = [pictures:Picture]

    static constraints = {
    	status maxSize: 1024, nullable: true
    	longitude nullable: true
    	latitude nullable: true
    }
    
    
}
