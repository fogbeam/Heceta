package org.fogbeam.heceta

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.queryParser.MultiFieldQueryParser
import org.apache.lucene.queryParser.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.ScoreDoc
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.util.Version

class SearchController 
{
	
	def siteConfigService;

	def doSearch = 
	{
		
		
		String queryString = params.queryString;
		println "searching Users, queryString: ${queryString}";
		
		// String indexDirLocation = "/development/projects/fogbeam/heceta/enron_tiny/index";
		String indexDirLocation = siteConfigService.getSiteConfigEntry( "indexDirLocation" );
		File indexDir = new File( indexDirLocation );
		Directory fsDir = FSDirectory.open( indexDir );
		
		IndexSearcher searcher = new IndexSearcher( fsDir );
	
		String[] searchFields = ['From', 'To', 'Subject', 'Body'];
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_30, searchFields, new StandardAnalyzer(Version.LUCENE_30));
		Query query = queryParser.parse(queryString);
		
		TopDocs hits = searcher.search(query, 400);
		
		List<String> searchResults = new ArrayList<String>();
		ScoreDoc[] docs = hits.scoreDocs;
		for( ScoreDoc doc : docs )
		{
			Document result = searcher.doc( doc.doc );
			
			searchResults.add( result.get("filename") );
		
		}
		
		println "found some results: ${searchResults.size()}";
		
		render( view:'displaySearchResults', model:[searchResults:searchResults] );
	}
	
	/* 
	def reindexAll = {
		
		sendJMSMessage("searchQueue", "REINDEX_ALL" );
		render( "<h1>DONE</h1>" );
	}
	*/
	
	
}
