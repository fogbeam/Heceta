package org.fogbeam.heceta

import java.io.BufferedInputStream
import java.io.FileInputStream

import org.apache.james.mime4j.parser.MimeEntityConfig
import org.apache.james.mime4j.parser.MimeStreamParser

import org.fogbeam.heceta.parsing.email.*;

class RenderController 
{
	def renderEmail = 
	{
		String path = params.path;
		File file = new File( path );
		FileInputStream msg = new FileInputStream( file );
		
		MyContentHandler handler = new MyContentHandler();
		MimeEntityConfig config = new MimeEntityConfig();
		config.setMaxLineLen(-1);
		MimeStreamParser parser = new MimeStreamParser( config );
		parser.setContentHandler( handler );
		parser.parse( new BufferedInputStream( msg ) );
		
		msg.close();
		
		[ to: handler.get( MyContentHandler.HEADER_TO ), 
		  from: handler.get( MyContentHandler.HEADER_FROM ), 
		  mailBody: handler.get( MyContentHandler.BODY ) ];	
	}
}
