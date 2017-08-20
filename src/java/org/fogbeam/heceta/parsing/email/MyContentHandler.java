package org.fogbeam.heceta.parsing.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.descriptor.BodyDescriptor;
import org.apache.james.mime4j.parser.Field;

/* 
Header field detected: Message-ID: <21766620.1075859982951.JavaMail.evans@thyme>
Header field detected: Date: Mon, 17 Jan 2000 08:45:00 -0800 (PST)
Header field detected: From: paul.simons@enron.com
Header field detected: To: raislerk@sullcrom.com
Header field detected: Subject: Confidentiality procedures
Header field detected: Cc: bryan.seyfried@enron.com, mark.haedicke@enron.com, mark.taylor@enron.com
Header field detected: Mime-Version: 1.0
Header field detected: Content-Type: text/plain; charset=us-ascii
Header field detected: Content-Transfer-Encoding: 7bit
Header field detected: Bcc: bryan.seyfried@enron.com, mark.haedicke@enron.com, mark.taylor@enron.com
Header field detected: X-From: Paul Simons
Header field detected: X-To: raislerk@sullcrom.com
Header field detected: X-cc: Bryan Seyfried, Mark E Haedicke, Mark Taylor
Header field detected: X-bcc: 
Header field detected: X-Folder: \Mark_Taylor _Dec_2000\Notes Folders\Notes inbox
Header field detected: X-Origin: Taylor-M
Header field detected: X-FileName: mtaylor.nsf

*/

public class MyContentHandler implements org.apache.james.mime4j.parser.ContentHandler {

	public static final String HEADER_MESSAGE_ID = "Message-ID";
	public static final String HEADER_MESSAGE_DATE = "Date";
	public static final String HEADER_FROM = "From";
	public static final String HEADER_TO = "To";
	public static final String HEADER_SUBJECT = "Subject";
	public static final String HEADER_CC = "Cc";
	public static final String HEADER_MIME_VERSION = "Mime-Version";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HEADER_CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
	public static final String HEADER_BCC = "Bcc";
	public static final String HEADER_X_FROM = "X-From";
	public static final String HEADER_X_TO = "X-To";
	public static final String HEADER_X_CC = "X-cc";
	public static final String HEADER_X_BCC = "X-bcc";
	public static final String HEADER_X_FOLDER = "X-Folder";
	public static final String HEADER_X_ORIGIN = "X-Origin";
	public static final String HEADER_X_FILENAME = "X-FileName";
	
	public static final String BODY = "Body";
	
	private final Map<String, String> fields = new HashMap<String,String>();
	
	public String get( String field ) 
	{
		return fields.get(field);
	}
	
	public Set<String> getNames()
	{
		return fields.keySet();
	}
	
	
	public static String convertStreamToString(InputStream is) 
	{
		StringBuilder sb = new StringBuilder("");
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    
			String line = null;
			while ((line = reader.readLine()) != null) 
			{
				sb.append(line + "\n");
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	    return sb.toString();
	}		
	
	public void body(BodyDescriptor bd, InputStream is) throws MimeException, IOException 
	{
        // System.out.println("Body detected, contents = "
        //    + is + ", header data = " + bd);
		
		System.out.println( "body: " + is.toString() );
		fields.put(MyContentHandler.BODY, convertStreamToString(is) );
    }
    
    public void field(String fieldData) throws MimeException 
    {
        // System.out.println("Header field detected: "
        //    + fieldData);
    }
    
    public void startMultipart(BodyDescriptor bd) throws MimeException 
    {
        // System.out.println("Multipart message detexted, header data = "
        //    + bd);
    }

	@Override
	public void endBodyPart() throws MimeException 
	{
		// System.out.println( "End Bodypart." );
	}

	@Override
	public void endHeader() throws MimeException 
	{
		// System.out.println( "End Header." );
	}

	@Override
	public void endMessage() throws MimeException 
	{
		// System.out.println( "End Message." );
	}

	@Override
	public void endMultipart() throws MimeException 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void epilogue(InputStream arg0) throws MimeException, IOException 
	{
		// System.out.println( "epilogue: " + arg0 );
	}

	@Override
	public void field(Field arg0) throws MimeException 
	{
        /*
         System.out.println("Header field detected: "
                + arg0 );
         */
        String name = arg0.getName();
        String value = arg0.getBody();
        // System.out.println( "Name: " + name );
        // System.out.println( "Value: " + value );
        
        fields.put(name, value);
	}

	@Override
	public void preamble(InputStream arg0) throws MimeException, IOException 
	{
		// System.out.println( "preamble: " + arg0 );
	}

	@Override
	public void raw(InputStream arg0) throws MimeException, IOException 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void startBodyPart() throws MimeException 
	{	
		// System.out.println( "Start Bodypart: " );	
	}

	@Override
	public void startHeader() throws MimeException 
	{	
		// System.out.println( "Start Header: " );	
	}

	@Override
	public void startMessage() throws MimeException 
	{
		// System.out.println( "Start Message: " );	
	}
}