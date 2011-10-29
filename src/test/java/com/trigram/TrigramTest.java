package com.trigram;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class to test Trigram class
 * 
 * @author Anand
 *
 */
public class TrigramTest {

	/**
	 * Positive test case. Tests the program with a valid input
	 */
	@Test
	public void testWithValidInput() {
		Trigram trigram = new Trigram();
		String generatedTrigram = trigram.generateTrigram("I wish I may I wish I might");
		Assert.assertNotNull(generatedTrigram);
	}
	
	/**
	 * Negative test case. Tests the program with a null input
	 */
	@Test
	public void testWithNull() {
		Trigram trigram = new Trigram();
		String generatedTrigram = trigram.generateTrigram(null);
		Assert.assertEquals(generatedTrigram, "");
	}
	
	/**
	 * Negative test case. Tests the program with an empty input
	 */
	@Test
	public void testWithEmptyInput() {
		Trigram trigram = new Trigram();
		String generatedTrigram = trigram.generateTrigram("");
		Assert.assertEquals(generatedTrigram, "");
	}
}
