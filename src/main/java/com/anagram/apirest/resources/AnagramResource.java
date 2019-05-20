package com.anagram.apirest.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class AnagramResource
{

	/**
	 * Method that verify whether the two given strings are an anagram or not.
	 * 
	 * @param str1 the first string.
	 * @param str2 the second string.
	 * @return whether the two given strings are an anagram or not.
	 */
	@GetMapping("/isAnagram")
	public Boolean isAnagram(@RequestParam(name="str1") String str1, @RequestParam(name="str2") String str2)
	{
		str1 = str1.toLowerCase().trim().replaceAll("\\s", "");
		str2 = str2.toLowerCase().trim().replaceAll("\\s", "");
		
		if (str1.length() != str2.length())
		{
			return false;
		}
		
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for (Character c1 : str1.toCharArray())
		{
			if (map1.get(c1) == null)
			{
				map1.put(c1, charAmount(str1, c1));
			}
		}
		
		for (Character c2 : str2.toCharArray())
		{
			if (map2.get(c2) == null)
			{
				map2.put(c2, charAmount(str2, c2));
			}
		}
		
		return map1.equals(map2);
	
	}
	
	/**
	 * Method that verify and return the characters amount into the given string.
	 * 
	 * @param str the string.
	 * @param chr the character.
	 * @return the characters amount.
	 */
	private static int charAmount(String str, Character chr)
	{
		int count = 0;
		for (Character c : str.toCharArray())
		{
			if (chr.equals(c))
				count++;
		}
		return count;
	}
	
}
