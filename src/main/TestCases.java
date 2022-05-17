package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class TestCases {
	
	@Test(priority=1)
	public void Post() throws IOException {
		
		
		FileInputStream fs= new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/Data/data.json"));
		
		Response res=BaseClass.BaseClassMethod(IOUtils.toString(fs),"POST","/user","");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Assert.assertEquals(res.jsonPath().getInt("code"), 200);
		
	}
	
	
	@Test(priority=2)
	public void Get() throws IOException {
		
		
		Response res=BaseClass.BaseClassMethod("Payal","GET","/user","");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
		
	}
	
	@Test(priority=3)
	public void Put() throws IOException {
		
		FileInputStream fs= new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/Data/dataForPUT.json"));
		
		Response res=BaseClass.BaseClassMethod(IOUtils.toString(fs),"PUT","/user","Payal");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
		Assert.assertEquals(res.jsonPath().getInt("code"), 200);
		
	}
	
	@Test(priority=4)
	public void Delete() throws IOException {
		
		Response res=BaseClass.BaseClassMethod("","DELETE","/user","Payal");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
		Assert.assertEquals(res.jsonPath().getInt("code"), 200);
		
	}
	
	@Test(priority=5)
    public void DeleteNegativeScenario() throws IOException {
		
		Response res=BaseClass.BaseClassMethod("","DELETE","/user","Anything");
		
		Assert.assertEquals(res.getStatusCode(), 404);
		
		
		
	}
	
}
