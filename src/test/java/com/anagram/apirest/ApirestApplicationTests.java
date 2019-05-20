package com.anagram.apirest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anagram.apirest.resources.AnagramResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApirestApplicationTests
{

	@Test
	public void contextLoads() {
	}
	
	/**
	 * Test case for {@link AnagramResource#isAnagram(String, String)}.
	 */
	@Test
	public void testIsAnagram()
	{
		AnagramResource ar = new AnagramResource();
		
		Boolean isAnagram1 = ar.isAnagram("String", "Character");
		assertFalse(isAnagram1);
		
		Boolean isAnagram2 = ar.isAnagram("The Morse Code", "Here comes dot");
		assertTrue(isAnagram2);
	}
	
}
