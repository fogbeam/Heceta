package org.fogbeam.alfresco.cms.exp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class CMISExp_ListRepo_Main1 {

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
		// Session session = factory.createSession(parameters);

		
		List<Repository> repositories = factory.getRepositories(parameters);
		for( Repository repo : repositories ) 
		{
			System.out.println( "repo: " + repo.getId() );
		}
		
		Session session = repositories.get(0).createSession();
		
		Folder rootFolder = session.getRootFolder();
		
		ItemIterable<CmisObject> items = rootFolder.getChildren();
		
		listItems( items, "" );
		
		System.out.println("done");
	}

	public static void listItems( ItemIterable<CmisObject> items, String padding )
	{
		for( CmisObject cmisObject : items )
		{
			
			if (cmisObject instanceof Document) 
			{
			    Document document = (Document) cmisObject;
			    System.out.println( "Document: " + padding + document.getName()  + ", id: "+ document.getId());
			} 
			else if (cmisObject instanceof Folder) 
			{
			    Folder folder = (Folder) cmisObject;
			    System.out.println( "Folder: " + padding + folder.getName() + ", id: " + folder.getId());
			    items = folder.getChildren();
			    listItems(items, padding + "\t");
			}
			
		}
		
	}
	
}
