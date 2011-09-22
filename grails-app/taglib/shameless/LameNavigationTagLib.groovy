package shameless

class LameNavigationTagLib {
	
	def lameNav = {
		
		def headings = [ 'Dashboard', 'Post', 'Account']
		
		out << "<div id='tabs'>\n<ul>\n"
		headings.each { heading ->
			def link = heading.toLowerCase()
			out << "<li class='"
			if (request.forwardURI.indexOf(link) > -1) {
				out << "active"
			} else {
				out << "passive"
			}
			out << "'>"
			out << "<a href='" + g.createLink(controller: link) + "'>${heading}</a>"
			out << "</li>\n"
			
		}
		out << "</ul></div>\n"
		
	}

}
