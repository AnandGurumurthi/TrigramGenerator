package com.trigram.generator;

/**
 * Generates n-gram for the given user input
 * 
 * @author Anand
 *
 */
public interface NGramGenerator {

	/**
	 * Generate n-gram for the given user input
	 * 
	 * @param inputText
	 * @throws GeneratorException
	 */
	public String generateNGram(String inputText) throws GeneratorException;
}
