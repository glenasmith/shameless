package shameless

class Picture {
	
	byte[] image
	
	Date dateCreated
	
	static belongsTo = [ post : Post ]

    static constraints = {
    	image nullable: false, maxSize: 1024000
    }
}
