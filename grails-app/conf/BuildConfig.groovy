grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// uncomment to disable ehcache
		// excludes 'ehcache'
	}
	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
		// grailsCentral()
		//         grailsPlugins()
		// grailsHome()

		// uncomment the below to enable remote dependency resolution
		// from public Maven repositories
		mavenLocal()
		mavenCentral()
		// mavenRepo "http://snapshots.repository.codehaus.org"
		// mavenRepo "http://repository.codehaus.org"
		mavenRepo "http://download.java.net/maven/2/"
		mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://maven.restlet.org/"
		mavenRepo "https://repo.grails.org/grails/plugins"
	}
	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		// runtime 'mysql:mysql-connector-java:5.1.5'
		compile "org.grails:grails-webflow:$grailsVersion"
		compile "antlr:antlr:2.7.7"
		compile "commons-logging:commons-logging:1.1.1"
		compile "org.grails:grails-webflow:$grailsVersion"

		compile 'com.google.api-client:google-api-client:1.22.0'
		compile 'com.google.oauth-client:google-oauth-client-jetty:1.22.0'
		compile 'com.google.apis:google-api-services-gmail:v1-rev65-1.22.0'
		compile 'commons-codec:commons-codec:1.6'
		compile 'org.apache.httpcomponents:httpclient:4.1.2'
		compile 'javax.mail:javax.mail-api:1.5.5'
		compile 'com.sun.mail:javax.mail:1.5.5'	
		compile 'org.apache.james:apache-mime4j:0.7.2'

	}
	plugins {

		compile ':webflow:2.0.0', { exclude 'grails-webflow' }

		runtime( ":shiro:1.1.4" ){ exclude 'quartz'; }

		runtime( ":jaxrs:0.8" )
		{
			//                exclude group:"org.restlet.gae", name:'org.restlet.ext.json'
			//               exclude group:"org.restlet.gae", name:'org.restlet.ext.servlet'
			//	       exclude group:"org.restlet.gae", name:'org.restlet'
		}

	}
}
