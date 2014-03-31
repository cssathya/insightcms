class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		"/"(view: "/index")
		"/serverstats"(view: "/serverstats")
		"500"(view: '/error')
	}
}
