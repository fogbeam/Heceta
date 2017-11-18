
package org.fogbeam.heceta

import org.apache.solr.client.solrj.SolrQuery
import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.apache.solr.client.solrj.response.QueryResponse
import org.apache.solr.common.SolrDocumentList
import org.apache.solr.common.SolrDocument

class SolrSearchService 
{
	// String url = "http://localhost:8983/solr";
	String url = "http://34.207.30.215:8983/solr/gettingstarted";
	
	SolrServer server = new HttpSolrServer( url );
	
	
	public List<String> search( String queryString )
	{
		// Set<String> queryParams = new HashSet<String>();
		// queryParams.add("AuthenticatedUserName=admin");
		// server.setQueryParams( queryParams );
		
		List<String> results = new ArrayList<String>();

		SolrQuery query = new SolrQuery();
		query.setQuery( queryString );
		query.setParam( "AuthenticatedUserName", "admin" );
		
		// query.addSortField( "price", SolrQuery.ORDER.asc );
	
		// Query the server
	
		QueryResponse rsp = server.query( query );
	
		// Get the results
	
		SolrDocumentList docs = rsp.getResults();
		
		for( SolrDocument doc : docs )
		{
			String result = doc.getFieldValue("name");
			if( result == null || result.isEmpty() )
			{
				result = doc.getFieldValue( "title" );
			}
			
			results.add( result );
		}
		
		return results;
	}
}
