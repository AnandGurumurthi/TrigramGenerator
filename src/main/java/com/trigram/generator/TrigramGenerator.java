package com.trigram.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.trigram.datahandler.DataHandler;
import com.trigram.datahandler.DataHandlerException;

/**
 * Trigram implementation of the NGramGenerator interface
 * 
 * @author Anand
 *
 */
public class TrigramGenerator implements NGramGenerator {
	
	@Autowired
	private DataHandler dataHandler;
	private static final Logger log = Logger.getLogger(TrigramGenerator.class.getName());
	private List<String> outputList;
	private static final String EMPTY_INPUT_ERROR_MSG = "Cannot function with empty text :( ";
	private static final String GENERIC_ERROR_MSG = "Exception occurred during trigram generation";

	/**
	 * Generate n-gram for the given user input
	 * 
	 * @param inputText
	 * @throws GeneratorException
	 */
	public String generateNGram(String inputText) throws GeneratorException {
		try {
			if (null == inputText || inputText.trim().length() == 0) {
				log.warning("Input string cannot be empty");
				return EMPTY_INPUT_ERROR_MSG;
			}
			outputList = new ArrayList<String>();
			dataHandler.processData(inputText);
			String randomStartingPoint = dataHandler.getRandomKey();
			outputList.addAll(Arrays.asList(randomStartingPoint.split(" ")));
			spawnSentence(randomStartingPoint);
			StringBuilder generatedTrigram = new StringBuilder();
			for (String word : outputList) {
				generatedTrigram.append(word + " ");
			}
			return generatedTrigram.toString();
		} catch (Exception e) {
			log.severe(e.getMessage());
			return GENERIC_ERROR_MSG;
		}
	}
	
	/**
	 * This is a recursive method. An arbitrary word pair is chosen as a starting point. Use these to look up a random next word (using the
	 * data map) and append this new word to the text so far. This now gives you a new word pair at the end of the text, so look up a
	 * potential next word based on these. Add this to the list, and so on.
	 * 
	 * @param key
	 * @throws DataHandlerException 
	 */
	private void spawnSentence(String key) throws DataHandlerException {
		if (dataHandler.containsKey(key)) {
			outputList.add(dataHandler.getRandomValue(key));
			spawnSentence(outputList.get(outputList.size() - 2) + " " + outputList.get(outputList.size() - 1));
		}
	}

	/**
	 * @return the dataHandler
	 */
	public DataHandler getDataHandler() {
		return dataHandler;
	}

	/**
	 * @param dataHandler the dataHandler to set
	 */
	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}

}
