package excel.utils;

public class BookAPI {
	
	public static String getPOSTRequestBody () {
		
		// "09567332982017"
		return "{\n"
				+ "        \"authorName\": \"Alan John Richardson\",\n"
				+ "        \"bookTitle\": \"Automating and Testing a REST API\",\n"
				+ "        \"yearPublished\": 2017,\n"
				+ "        \"genre\": \"Education\",\n"
				+ "        \"isbn\": \"095673329856\"\n"
				+ "    }";
	}
	
	public static String getPUTRequestBody () {
		
		// "09567332982020"
		return "{\n"
				+ "    \"yearPublished\" : 2020\n"
				+ "}";
	}
	
	public static String getPUTRequestBody(String isbn) {
		
		return "{\n"
				+ "    \"isbn\" : \"" + isbn + "\"\n"
				+ "}";
	}
	
	public static String getPOSTRequestBody (String authorName, String title, Integer yearPublished, 
			String genre, String isbn) {
		
		return "{\n"
				+ "        \"authorName\": \"" + authorName +  "\",\n"
				+ "        \"bookTitle\": \"" + title + "\",\n"
				+ "        \"yearPublished\":" + yearPublished + ",\n"
				+ "        \"genre\": \"" + genre + "\",\n"
				+ "        \"isbn\": \"" + isbn + "\"\n"
				+ "    }";
	}
	
	public static String getPOSTRequestBody (String isbn) {
		
		// "09567332982017"
		return "{\n"
				+ "        \"authorName\": \"Alan John Richardson\",\n"
				+ "        \"bookTitle\": \"Automating and Testing a REST API\",\n"
				+ "        \"yearPublished\": 2017,\n"
				+ "        \"genre\": \"Education\",\n"
				+ "        \"isbn\": \"" + isbn + "\"\n"
				+ "    }";
	}

}
