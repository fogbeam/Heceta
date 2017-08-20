package org.fogbeam.alfresco.cms.exp;

import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.Action;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class CMISExp_ACL_Main1 {

	public static void main(String[] args) {

		// default factory implementation
		SessionFactory factory = SessionFactoryImpl.newInstance();
		Map<String, String> parameters = new HashMap<String, String>();

		// user credentials
		parameters.put(SessionParameter.USER, "admin");
		parameters.put(SessionParameter.PASSWORD, "admin");

		// connection settings
		parameters.put(SessionParameter.ATOMPUB_URL, "https://cmis.alfresco.com/api/-default-/public/cmis/versions/1.0/atom");
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameters.put(SessionParameter.REPOSITORY_ID, "-default-");

		// create session
		Session session = factory.createSession(parameters);

		// retrieve an object...
		CmisObject cmisObject = session.getObject("99cb2789-f67e-41ff-bea9-505c138a6b23;1.0");
		// check if the current user can access it.
		if( cmisObject.hasAllowableAction( Action.CAN_GET_CONTENT_STREAM ) ) 
		{
		    System.out.println( "Yes, has access");
		}
		else
		{
			System.out.println( "No, access denied!");
		}
		
		System.out.println("done");
	}

	
	
	
}
