package excelDriven;
import excel.utils.BookAPI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import excel.utils.JsonPathUtil;


public class BookAPIUsingExcelDriven {
	
	@Test
	public void testBookAPI () {
		RestAssured.baseURI = "http://localhost:8088/api/";
		
		//POST
		String responseBodyPOSTString =

		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPOSTRequestBody()).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201)
			.extract()
			.asString();

		// "09567332982017"
		String createdBookId = JsonPathUtil.getRequestedKeyFromResponse(responseBodyPOSTString, 
				"bookId");
		System.out.println(createdBookId);
		
	/*	//PUT
		
		String putResponse = 
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPUTRequestBody())
			.pathParam("bookId", createdBookId).   //// "09567332982017"
		when().
			put("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.body()
			.asString();
		
		String updatedBookId = JsonPathUtil.getRequestedKeyFromResponse(putResponse, 
				"bookId");
		
		//GET
		String responseForGETRequest = 
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId)
			.queryParam("delay", 2000)
			.queryParam("sortBy", "yearPublished").
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.asString();
		
		String expectedBookID = "09567332982020";
		String actualBookID = JsonPathUtil.getRequestedKeyFromResponse(responseForGETRequest,
									"bookId");
		assertEquals(actualBookID, expectedBookID);

		// DELETE
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId).
		when()
			.delete("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(204);

		// GET
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId).
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(404);
			*/
	}
}
