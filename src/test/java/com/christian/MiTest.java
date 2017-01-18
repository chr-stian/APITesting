package com.christian;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.util.HashMap;
import java.util.Map;

public class MiTest extends FunctionalTest{

	    @Test
	    public void basic404Test() {
	    	System.out.print("basic404\n");
	        given().when().get("/noExiste").then().statusCode(404);
	    }
	    
	    @Test
	    public void isUp() {
	    	System.out.print("isUp\n");
	        given().when().get("/").then().statusCode(200);
	    }
	    
	    
	    @Test
	    public void firstPostTest(){
	    	System.out.print("firstPostTest\n");
	    	  given()
	          .contentType("application/json")
	          .when().post("/posts").then()
	          .statusCode(201);
	    	  //201 means resource created
	    	
	    }
	    
	    @Test
	    public void PostWithBodyTest(){
	    	System.out.print("PostWithBodyTest\n");
	    	
	    	 Map<String,Object> cuerpo = new HashMap<>();
	         cuerpo.put("userId", 8);
	         cuerpo.put("title", "titulo");
	         cuerpo.put("body", "cuerpo");
	         
	    	
	    	  given()
	          .contentType("application/json")
	          .body(cuerpo)
	          .when().post("/posts").then()
	          .body("id",equalTo(101))
	          .body("title",equalTo("titulo"))
	          .body("body",equalTo("cuerpo"))
	          .body("userId",equalTo(8))
	          .statusCode(201);
	    	  //201 means resource created
	    	
	    }

	
}
