package org.fogbeam.heceta;

class UserController {

    def scaffold = true;
    def userService;
    def entryService;
    def tagService;
    
    def registerUser = { UserRegistrationCommand urc -> 
    	if( urc.hasErrors() )
    	{
    		flash.user = urc;
    		redirect( action:"register2" );
    	}
    	else
    	{
    		def user = new User( urc.properties );
    		// user.profile = new Profile( urc.properties );
    		if( user.save() )
    		{
    			flash.message = "Welcome Aboard, ${urc.fullName ?: urc.userId}";
    			redirect(controller:'home', action: 'index')
    		}
    		else
    		{
    			// maybe not unique userId?
    			flash.user = urc;
    			redirect( action:"register2" );
    		}
    	}
    }

    def viewDetails = {
    	def targetUserName = params.targetUserName
    	println "Viewing details for user: ${targetUserName}";

    	User user = userService.findUserByUserId( targetUserName );
    	
    	// get all Entries for the requested user...
    	def allEntries = entryService.getAllEntries( user );
    	[targetUserName:targetUserName, allEntries:allEntries];
    
    }

}

class UserRegistrationCommand
{
    String userId;
    String password;
    String passwordRepeat;
    
    byte[] photo;
    String fullName;
    String bio;
    String homepage;
    String email;
    String timezone;
    String country;
    String jabberAddress;
    
    static constraints = {
        userId( size: 3..20)
        password( size:6..8, blank:false, validator : {password, urc -> return password != urc.userId } );
        passwordRepeat( nullable:false, validator : {password2, urc -> return password2 == urc.password } );
    
        fullName( nullable:true );
        bio( nullable:true, maxSize:1000 );
        homepage( url:true, nullable:true);
        email(email:true, nullable:true);
        photo( nullable:true);
        country( nullable:true);
        timezone( nullable:true);
        jabberAddress( email:true, nullable:true);
        
    }
}




