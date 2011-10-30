package com.trigram;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.trigram.datahandler.DataHandlerException;
import com.trigram.datahandler.MapDataHandler;

/**
 * Test class to test MapDataHandler class
 * 
 * @author Anand
 *
 */
public class MapDataHandlerTest {
	
	@Test
	public void testProcessDataWithValidInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testProcessDataWithEmptyInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("");
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Input string cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testProcessDataWithNullInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData(null);
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Input string cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testGetKeys() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNotNull(dataHandler.getKeys());
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetRandomKey() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNotNull(dataHandler.getRandomKey());
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testContainsKeyWithValidInputTrue() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertTrue(dataHandler.containsKey("I wish"));
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testContainsKeyWithValidInputFalse() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertFalse(dataHandler.containsKey("I try"));
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testContainsKeyWithEmptyInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertFalse(dataHandler.containsKey(""));
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Key cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testContainsKeyWithNullInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertFalse(dataHandler.containsKey(null));
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Key cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testGetValuesWithValidInputTrue() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertTrue(dataHandler.getValues("I wish").size() > 0);
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetValuesWithValidInputFalse() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNull(dataHandler.getValues("I try"));
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetValuesWithEmptyInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNull(dataHandler.getValues(""));
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Key cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testGetValuesWithNullInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNull(dataHandler.getValues(null));
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Key cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testGetRandomValueWithValidInputTrue() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNotNull(dataHandler.getRandomValue("I wish"));
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetRandomValueWithValidInputFalse() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNull(dataHandler.getRandomValue("I try"));
		} catch (DataHandlerException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetRandomValueWithEmptyInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNull(dataHandler.getRandomValue(""));
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Key cannot be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void testGetRandomValueWithNullInput() {
		try {
			MapDataHandler dataHandler = new MapDataHandler();
			dataHandler.processData("I wish I may I wish I might");
			Assert.assertNull(dataHandler.getRandomValue(null));
		} catch (Exception e) {
			Assert.assertEquals(DataHandlerException.class, e.getClass());
			Assert.assertEquals("Key cannot be null or empty", e.getMessage());
		}
	}
}
