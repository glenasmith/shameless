import shameless.*

def imageDir = new File("test/images")
def account = Account.findByUsername("admin")
if (!account) {
	throw RuntimeException("Couldn't find a user to import with")
}

imageDir.eachFile { file ->
	
	if (file.name.endsWith("jpg")) {
		println "${file.name} is processing"
		def existing = Post.findByStatus(file.name)
		if (!existing) {
            def lastModified = new Date(file.lastModified())
			def newPost = new Post(account: account, status: file.name, longitude: "", latitude: "", dateCreated: lastModified)
			if (!newPost.save()) {
				println "Errors saving post: ${newPost.errors}"
			} else {
				def newPic = new Picture(image: file.readBytes())
				newPost.addToPictures(newPic)

				if (!newPost.save()) {
					println "Errors saving picture on post: ${newPost.errors}"
				} else {
					println "${file.name} is saved ok"
				}
			}
			
		} else {
			println "${file.name} is SKIPPED"
		}
	}
	
}

