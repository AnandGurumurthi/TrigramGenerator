package com.trigram;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.trigram.datahandler.MapDataHandler;
import com.trigram.generator.TrigramGenerator;

/**
 * Test class to test TrigramGenerator class
 * 
 * @author Anand
 *
 */
public class TrigramGeneratorTest {

	@Test
	public void testGenerateNGramWithValidInput() {
		try {
			TrigramGenerator trigramGenerator = new TrigramGenerator();
			MapDataHandler dataHandler = new MapDataHandler();
			trigramGenerator.setDataHandler(dataHandler);
			Assert.assertNotNull(trigramGenerator.generateNGram("I wish I may I wish I might"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGenerateNGramWithLessThanMinimumWords() {
		try {
			TrigramGenerator trigramGenerator = new TrigramGenerator();
			MapDataHandler dataHandler = new MapDataHandler();
			trigramGenerator.setDataHandler(dataHandler);
			Assert.assertEquals(trigramGenerator.generateNGram("I wish"), TrigramGenerator.MINIMUM_WORDS_ERROR_MSG);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGenerateNGramWithEmptyInput() {
		try {
			TrigramGenerator trigramGenerator = new TrigramGenerator();
			MapDataHandler dataHandler = new MapDataHandler();
			trigramGenerator.setDataHandler(dataHandler);
			Assert.assertEquals(trigramGenerator.generateNGram(""), TrigramGenerator.EMPTY_INPUT_ERROR_MSG);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGenerateNGramWithNullInput() {
		try {
			TrigramGenerator trigramGenerator = new TrigramGenerator();
			MapDataHandler dataHandler = new MapDataHandler();
			trigramGenerator.setDataHandler(dataHandler);
			Assert.assertEquals(trigramGenerator.generateNGram(null), TrigramGenerator.EMPTY_INPUT_ERROR_MSG);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
