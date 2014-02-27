package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HttpServices{

	private final int successCode = 200;

	public StringBuilder getGoogleBookInfo(StringBuilder bookBuilder, String...bookURLs)
	{
		for (String bookSearchURL : bookURLs) {
			HttpClient bookClient = new DefaultHttpClient();
			try 
			{
				//get the data
				HttpGet bookGet = new HttpGet(bookSearchURL);
				HttpResponse bookResponse = bookClient.execute(bookGet);

				StatusLine bookSearchStatus = bookResponse.getStatusLine();
				if (bookSearchStatus.getStatusCode() == successCode) 
				{
					//we have a result
					HttpEntity bookEntity = bookResponse.getEntity();
					InputStream bookContent = bookEntity.getContent();
					InputStreamReader bookInput = new InputStreamReader(bookContent);
					BufferedReader bookReader = new BufferedReader(bookInput);

					String lineIn;
					while ((lineIn=bookReader.readLine())!=null) 
					{
						bookBuilder.append(lineIn);
					}
				}					
			}
			catch(Exception e)
			{ 
				e.printStackTrace(); 
			}
		}
		return bookBuilder;
	}	
}
