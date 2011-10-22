import shameless.*

def imageDir = new File("test/images/small")
def account = Account.findByUsername("admin")
if (!account) {
	throw RuntimeException("Couldn't find a user to import with")
}

imageDir.eachFile { file ->
	
	if (file.name.endsWith("jpg")) {
		println "${file.name} is processing"
		def existing = Meal.findByStatus(file.name)
		if (!existing) {
            def lastModified = new Date(file.lastModified())
			def newMeal = new Meal(account: account, status: file.name, longitude: "", latitude: "")
			if (!newMeal.save()) {
				println "Errors saving post: ${newMeal.errors}"
			} else {
				def newPic = new Picture(image: file.readBytes())
				newMeal.addToPictures(newPic)
                newMeal.dateCreated = lastModified

				if (!newMeal.save(flush: true)) {
					println "Errors saving picture on meal: ${newMeal.errors}"
				} else {
					println "${file.name} is saved ok"
				}
			}
			
		} else {
			println "${file.name} is SKIPPED"
		}
	}
	
}

