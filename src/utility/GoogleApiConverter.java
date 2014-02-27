package utility;

public class GoogleApiConverter {
	
	public static final String authKey = "AIzaSyCzgfug-6x5_JcsbKFCC684YYu6feLtGvg";
	
	
	public static String formateBookApiSearchQuery(String scanContent)
	{
		String query = "https://www.googleapis.com/books/v1/volumes?"+ "q=isbn:"+ scanContent+ "&key=" + authKey;
		return query;
	}
	
	public static boolean isScanFormatMatching(String scanContent, String scanFormat)
	{
		return scanContent!=null && scanFormat!=null && scanFormat.equalsIgnoreCase("EAN_13");
	}

}
