package com.trigram.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trigram.generator.NGramGenerator;

@Controller  
/**
 * NGramController - handles the n-gram generate requests
 */
public class NGramController {  
  
	private static final Logger log = Logger.getLogger(NGramController.class.getName());
	private static final String sampleInput = "I wish I may I wish I might";
	
	@Autowired
	private NGramGenerator nGramGenerator;
	
    @RequestMapping(value = "/ngramgenerator.do", method = RequestMethod.POST)  
    /**
     * Handles the request when the user passes an input
     */
    public String nGramGenerator(String inputText, Model model) {  
        try {
			model.addAttribute("input", inputText);  
			model.addAttribute("output", nGramGenerator.generateNGram(inputText));  
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
        return "index";  
    }
    
    @RequestMapping(value = "/trysample.do", method = RequestMethod.GET)  
    /**
     * Handles the request when the user tries a sample 
     */
    public String trySampleGenerator(Model model) {  
        try {
			model.addAttribute("input", sampleInput);  
			model.addAttribute("output", nGramGenerator.generateNGram(sampleInput));  
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
        return "index";  
    }

	/**
	 * @return the nGramGenerator
	 */
	public NGramGenerator getnGramGenerator() {
		return nGramGenerator;
	}

	/**
	 * @param nGramGenerator the nGramGenerator to set
	 */
	public void setnGramGenerator(NGramGenerator nGramGenerator) {
		this.nGramGenerator = nGramGenerator;
	}
} 