import shameless.*

def imageDir = new File("/Users/Smith/Desktop/100MEDIA")
def account = Account.findByUsername("admin")
if (!account) {
	throw Exception("Couldn't find a user to import with")
}

imageDir.eachFile { file ->
	
	if (file.name.endsWith("jpg")) {
		println "${file.name} is processing"
		def existing = Post.findByStatus(file.name)
		if (!existing) {
			def newPost = new Post(account: account, status: file.name, longitude: "", latitude: "")
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

