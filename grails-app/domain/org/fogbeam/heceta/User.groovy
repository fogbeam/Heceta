package org.fogbeam.heceta

import java.util.List;

class User {

	public User()
	{
		this.uuid = java.util.UUID.randomUUID().toString();
	}
	
    static constraints = {
        userId( size:3..20, unique:true )
        password( size:6..8 )
        homepage( url:true, nullable:true )
        validator: {passwd, user -> 
                return passwd != user.userId 
            }
        userProfile(nullable:true)
        dateCreated()
    }

    
    String uuid;
    String userId;
    String password;
    String homepage;
    String fullName;
    String bio;
    String email;
    Date dateCreated;
    UserProfile userProfile;
    
    static mapping = {
    	table 'uzer'
    }

    static mappedBy = [userProfile:"owner"];

    public void setUuid( String uuid ){
    	
    	// never overwrite existing uuid value with NULL
    	if( uuid != null )
    	{
    		this.uuid = uuid;
    	}
    }

    public List geParents() 	
	{
    	return parentUserLinks.collect{it.owner}
	}  
    
    public List getChildren()
    {
    	return childUserLinks.collect{it.target}
    }
    
    // add to User Links
	List addToParentUserLinks(User user) 
	{ 
		UserToUserLink.link(this, user );
		return parents;
	}

	List removeFromParentUserLinks( User user ) 
	{ 
		UserToUserLink.unlink(this, user );
		return parents;
	}     

	List addToChildUserLinks(User user) 
	{ 
		TagEntryLink.link(this, user );
		return children;
	}

	List removeFromChildUserLinks( User user ) 
	{ 
		TagEntryLink.unlink(this, user );
		return children
	}
	
}
