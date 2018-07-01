package com.msmata.weather;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.msmata.weather.model.Location;
import com.msmata.weather.model.User;

public class WeatherTest {

	public static final String REST_SERVICE_URI = "http://localhost:8080/WeatherApi/api";

	private static String generateRandomString(int length) {
		Random random = new Random();
		return random.ints(48, 122).filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97)).mapToObj(i -> (char) i)
				.limit(length).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	@Test
	public void testACreateUser() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(0, generateRandomString(25));
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, User.class);
		assertTrue(uri != null);
		System.out.println("Location : " + uri.toASCIIString());
	}

	@Test
	public void testCListAllUsers() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/", List.class);
		assertTrue(usersMap != null);
		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("id") + ", Username=" + map.get("username"));
			}
		}
	}

	@Test
	public void testBGetUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", User.class);
		System.out.println(user);
		assertTrue(user != null);
	}

	@Test
	public void testDUpdateUser() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(1, "Tomy");
		restTemplate.put(REST_SERVICE_URI + "/user/1", user);
		assertTrue(true);
	}

	@Test(expected = HttpClientErrorException.class)
	public void testEDeleteUser() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/1");
		restTemplate.getForObject(REST_SERVICE_URI + "/user/1", User.class);
	}
	
	@Test
	public void testFAddLocation() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(3, "Tommy");
		Location location = new Location();
		location.setWoeid(23424747L);
		location.setName("Cordoba");
		user.getLocations().add(location);
		restTemplate.put(REST_SERVICE_URI + "/user/3", user);
		assertTrue(true);
	}
	
//	@Test
//	public void testFAddLocation(){
//		System.out.println("Testing addLocation User API----------");
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("userid", "3");
//		Location location = new Location();
//		location.setWoeid(23424747L);
//		location.setName("Cordoba");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.put(REST_SERVICE_URI + "/addLocation/", params, location);
//	}

	@Test
	public void testGDeleteAllUsers() {
		System.out.println("Testing all delete Users API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/");
	}

}
