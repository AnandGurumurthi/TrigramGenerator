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
	 * Initializes the DataHandler
	 */
	public void init();

	/**
	 * Gets a key and value and puts it in the map
	 * 
	 * @param key
	 * @param value
	 * 
	 * @throws DataHandlerException
	 */
	public void put(String key, String value) throws DataHandlerException;

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
