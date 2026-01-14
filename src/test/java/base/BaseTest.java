package base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.restful-api.dev";
	}
}
