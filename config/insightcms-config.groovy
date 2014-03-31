import org.apache.log4j.DailyRollingFileAppender

final String grailsEnv = System.getProperty(grails.util.Environment.KEY)
final String appName = grails.util.Metadata.current.getApplicationName()
final String defaultLogDir = '/pocspace/logs/'
final String logDir = System.getProperty('logDir', defaultLogDir)

grails {
	logging.jul.usebridge = false
}

environments {
	development {
		grails {
			serverURL = "http://localhost:8080/insightcms"
			mongo {
				host = "127.0.0.1"
				port = 27017
				databaseName = "insightcms-dev"
//				username = "sa"
//				password = "password"
			}
		}

	}
}
log4j = {
	appenders {
		appender new DailyRollingFileAppender(
			name: 'file',
			datePattern: "'.'yyyy-MM-dd",
			fileName: "${logDir}/${appName}-${grailsEnv}.log",
			layout: pattern(conversionPattern: '%d %c{2} %5p %m%n')
		)
		appender new DailyRollingFileAppender(
			name: 'stacktrace',
			datePattern: "'.'yyyy-MM-dd",
			fileName: "${logDir}/${appName}-${grailsEnv}-stacktrace.log",
			layout: pattern(conversionPattern: '%d %c{2} %5p %m%n')
		)
	}
	root { error 'file' }

	error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
		'org.codehaus.groovy.grails.web.pages', //  GSP
		'org.codehaus.groovy.grails.web.sitemesh', //  layouts
		'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
		'org.codehaus.groovy.grails.web.mapping', // URL mapping
		'org.codehaus.groovy.grails.commons', // core / classloading
		'org.codehaus.groovy.grails.plugins', // plugins
		'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
		'org.springframework',
		'org.hibernate',
		'net.sf.ehcache.hibernate'

	debug 'insightcms'

	warn 'org.mortbay.log'
}
