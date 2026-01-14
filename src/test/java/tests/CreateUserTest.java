package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.http.ContentType;
import pojo.CreateUserRequest;
import pojo.CreateUserResponse;
import pojo.Data;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {
	private String createdId;

	@Test(priority =1)
	public void testCreateUser() {
		
		Data data = new Data();
		data.setYear(2012);
		data.setPrice(2017.8);
		data.setCpuModel("intel core i5");
		data.setHardDiskSize("1 tb");
		
		CreateUserRequest request = new CreateUserRequest();
		request.setName("Apple macbook pro 18");
		request.setData(data);
		
		CreateUserResponse response =
                given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(request)          // SERIALIZATION
                .when()
                    .post("/objects")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract()
                    .as(CreateUserResponse.class); // DESERIALIZATION
		
		createdId = response.getId();
		System.out.println("Created ID: "+createdId);

        // Step 3: Assertions
       
        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getName(),"Apple macbook pro 18");
        Assert.assertEquals(response.getData().getYear(),2012);
        Assert.assertEquals(response.getData().getPrice(),2017.8);
        Assert.assertEquals(response.getData().getCpuModel(), "intel core i5");
        Assert.assertEquals(response.getData().getHardDiskSize(), "1 tb");
	}
	
	@Test(priority = 2, dependsOnMethods = "testCreateUser")
	public void testGetUser() {
		given()
		.pathParam("id", createdId)
		.when()
		.get("/objects/{id}")
		.then()
		.statusCode(200)
		.body("id", equalTo(createdId));
	}
	
	@Test(priority=3, dependsOnMethods = "testGetUser")
	public void testUpdateUser() {
				
		Data data = new Data();
		data.setYear(2026);
		data.setPrice(8889.9);
		data.setCpuModel("helo cpu model");
		data.setHardDiskSize("256 gb");
		
		CreateUserRequest request = new CreateUserRequest();	
		request.setName("Motorola edge 50 pro");
		request.setData(data);
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("id", createdId)
		.body(request)
		.when()
		.put("/objects/{id}")
		.then()
		.log().all()
		.statusCode(200)
		.body("name", equalTo("Motorola edge 50 pro"))
		.body("data.year", equalTo(2026));
		
	}
	
	@Test(priority=4, dependsOnMethods = "testUpdateUser")
	public void testDeleteUser() {
		given()
		.pathParam("id", createdId)
		.when()
		.delete("/objects/{id}")
		.then()
		.log().all()
		.statusCode(200);
	}
}
