package shameless

class Picture {
	
	byte[] image
	
	Date dateCreated
	
	static belongsTo = [ meal : Meal ]

    static constraints = {
    	image nullable: false, maxSize: 2048000
    }
}
