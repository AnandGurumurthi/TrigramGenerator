package com.trigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Trigram {

	/**
	 * This list will store the output.
	 */
	private List<String> outputList = new ArrayList<String>();

	/**
	 * This map will be used to store the data. Using HashMap for faster retrieval since we dont worry about the order
	 */
	private Map<String, List<String>> data = new HashMap<String, List<String>>();

	public String generateTrigram(String inputString) {
		processData(inputString);
		String randomStartingPoint = getRandomStartingPoint();
		spawnSentence(randomStartingPoint);
		StringBuilder generatedTrigram = new StringBuilder();
		for (String word : outputList) {
			generatedTrigram.append(word + " ");
		}
		return generatedTrigram.toString();
	}

	/**
	 * Gets a string as an input and forms a map for the Trigram.
	 * 
	 * Look at each set of three adjacent words in a document. Use the first two words of the set as a key, and remember the fact that the
	 * third word followed that key.
	 * 
	 * @param inputData
	 */
	private void processData(String inputData) {
		inputData = inputData.replaceAll("\\p{P}+", "");
		List<String> inputWordsList = Arrays.asList(inputData.split(" "));
		for (int i = 0; i < inputWordsList.size() - 2; i++) {
			String key = inputWordsList.get(i) + " " + inputWordsList.get(i + 1);
			String value = inputWordsList.get(i + 2);
			List<String> values = new ArrayList<String>();
			if (data.containsKey(key)) {
				values = data.get(key);
			}
			values.add(value);
			data.put(key, values);
		}
	}

	/**
	 * Goes through the data and picks a random starting point.
	 * 
	 * @return randomStartingPoint
	 */
	private String getRandomStartingPoint() {
		Random generator = new Random();
		Object[] keys = data.keySet().toArray();
		String randomStartingPoint = (String) keys[generator.nextInt(keys.length)];
		outputList.addAll(Arrays.asList(randomStartingPoint.split(" ")));
		return randomStartingPoint;
	}

	/**
	 * This is a recursive method. An arbitrary word pair is chosen as a starting point. Use these to look up a random next word (using the
	 * data map) and append this new word to the text so far. This now gives you a new word pair at the end of the text, so look up a
	 * potential next word based on these. Add this to the list, and so on.
	 * 
	 * @param key
	 */
	private void spawnSentence(String key) {
		if (data.containsKey(key)) {
			List<String> values = data.get(key);
			Collections.shuffle(values);
			outputList.add(values.get(0));
			spawnSentence(outputList.get(outputList.size() - 2) + " " + outputList.get(outputList.size() - 1));
		}
	}
}
