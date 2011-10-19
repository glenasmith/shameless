package shameless

//TODO This should really be Meal in my thinking...
class Meal {
	
	Date dateCreated
	String status
	
	String longitude
	String latitude
	
	boolean badFood
	
	Account account
	
	Set<String> getPictureIds() {
		pictures.sort { a,b -> a <=> b} // sort in ascending ids
	}
	
	static hasMany = [pictures:Picture]

    static constraints = {
    	status maxSize: 1024, nullable: true
    	longitude nullable: true
    	latitude nullable: true
    }
    
    
}
