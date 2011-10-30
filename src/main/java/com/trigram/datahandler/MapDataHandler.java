package com.trigram.datahandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Implements the DataHandler interface.
 * 
 * Uses a map to persist the data.
 * 
 * @author Anand
 * 
 */
public class MapDataHandler implements DataHandler {

	private Map<String, List<String>> data = new HashMap<String, List<String>>();
	private static final Logger log = Logger.getLogger(MapDataHandler.class.getName());
	
	/**
	 * Initializes the DataHandler - in this case initialize the Map
	 */
	public void init() {
		data = new HashMap<String, List<String>>();
	}

	/**
	 * Gets a key and value and puts it in the map
	 * 
	 * @param key
	 * @param value
	 * 
	 * @throws DataHandlerException
	 */
	public void put(String key, String value) throws DataHandlerException {
		if (key != null && key.trim().length() > 0 && value != null && value.trim().length() > 0) {
			List<String> values = new ArrayList<String>();
			if (data.containsKey(key)) {
				values = data.get(key);
			}
			values.add(value);
			data.put(key, values);
		} else {
			log.warning("Key or value cannot be null or empty");
			throw new DataHandlerException("Key or value cannot be null or empty");
		}
	}

	/**
	 * Returns the set of keys present in the data
	 * 
	 * @throws DataHandlerException
	 */
	public Set<String> getKeys() throws DataHandlerException {
		try {
			return data.keySet();
		} catch (Exception e) {
			log.severe("Error occurred during getKeys");
			throw new DataHandlerException("Error occurred during getKeys");
		}
	}

	/**
	 * Returns a random key from the set of keys present in the data
	 * 
	 * @throws DataHandlerException
	 */
	public String getRandomKey() throws DataHandlerException {
		try {
			Random generator = new Random();
			Object[] keys = data.keySet().toArray();
			return (String) keys[generator.nextInt(keys.length)];
		} catch (Exception e) {
			log.severe("Error occurred during getRandomKey");
			throw new DataHandlerException("Error occurred during getRandomKey");
		}
	}

	/**
	 * Checks if the given key is present in the data
	 * 
	 * @throws DataHandlerException
	 */
	public boolean containsKey(String key) throws DataHandlerException {
		if (key != null && key.trim().length() > 0) {
			if (data.containsKey(key)) {
				return true;
			}
		} else {
			log.warning("Key cannot be null or empty");
			throw new DataHandlerException("Key cannot be null or empty");
		}
		return false;
	}

	/**
	 * Returns the list of values for a given string
	 * 
	 * @param key
	 * @throws DataHandlerException
	 */
	public List<String> getValues(String key) throws DataHandlerException {
		if (key != null && key.trim().length() > 0) {
			if (data.containsKey(key)) {
				return data.get(key);
			} else {
				return null;
			}
		} else {
			log.warning("Key cannot be null or empty");
			throw new DataHandlerException("Key cannot be null or empty");
		}
	}

	/**
	 * Returns a random value from the list of values for a given string
	 * 
	 * @param key
	 * @throws DataHandlerException
	 */
	public String getRandomValue(String key) throws DataHandlerException {
		if (key != null && key.trim().length() > 0) {
			if (data.containsKey(key)) {
				List<String> values = data.get(key);
				Collections.shuffle(values);
				return values.get(0);
			} else {
				return null;
			}
		} else {
			log.warning("Key cannot be null or empty");
			throw new DataHandlerException("Key cannot be null or empty");
		}
	}
}
