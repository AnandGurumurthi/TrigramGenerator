package com.trigram.datahandler;

import java.util.List;
import java.util.Set;

/**
 * Data handler interface. Processes the input text given by the user and persists it.
 * 
 * @author Anand
 * 
 */
public interface DataHandler {

	/**
	 * Gets a string as an input and forms a map for the Trigram.
	 * 
	 * Look at each set of three adjacent words in a document. Use the first two words of the set as a key, and remember the fact that the
	 * third word followed that key.
	 * 
	 * @param inputData
	 */
	public void processData(String inputData) throws DataHandlerException;

	/**
	 * Returns the set of keys present in the data
	 * 
	 * @throws DataHandlerException
	 */
	public Set<String> getKeys() throws DataHandlerException;

	/**
	 * Returns a random key from the set of keys present in the data
	 * 
	 * @throws DataHandlerException
	 */
	public String getRandomKey() throws DataHandlerException;

	/**
	 * Checks if the given key is present in the data
	 * 
	 * @throws DataHandlerException
	 */
	public boolean containsKey(String key) throws DataHandlerException;

	/**
	 * Returns the list of values for a given string
	 * 
	 * @param key
	 * @throws DataHandlerException
	 */
	public List<String> getValues(String key) throws DataHandlerException;

	/**
	 * Returns a random value from the list of values for a given string
	 * 
	 * @param key
	 * @throws DataHandlerException
	 */
	public String getRandomValue(String key) throws DataHandlerException;
}
