package org.fogbeam.heceta

class SearchController 
{
	
	def siteConfigService;
	def solrSearchService;
	
	def doSearch = 
	{	
		String queryString = params.queryString;
		println "searching Users, queryString: ${queryString}";
		
		
		List<String> searchResults = solrSearchService.search(queryString);
		
		
		println "found some results: ${searchResults.size()}";
		
		render( view:'displaySearchResults', model:[searchResults:searchResults] );
	}	
}