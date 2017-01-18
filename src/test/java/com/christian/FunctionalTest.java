package com.christian;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class FunctionalTest {

	@BeforeClass
	public static void setup() {

		System.out.print("setup\n");
		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(80);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String basePath = System.getProperty("server.base");
		if (basePath == null) {
			basePath = "/";
		}
		RestAssured.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://jsonplaceholder.typicode.com/";
		}
		RestAssured.baseURI = baseHost;
	}
}
