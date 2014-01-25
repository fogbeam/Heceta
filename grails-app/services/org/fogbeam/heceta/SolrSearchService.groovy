
package org.fogbeam.heceta

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer

class SolrSearchService 
{
	String url = "http://localhost:8983/solr";
	SolrServer server = new HttpSolrServer( url );
	
	
	public List<String> search( String query )
	{
		List<String> results = new ArrayList<String>();
		
		// TODO: search using Solr
		
		return results;
	}
}
