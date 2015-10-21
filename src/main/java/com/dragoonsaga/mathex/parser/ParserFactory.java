package com.dragoonsaga.mathex.parser;

/**
 * Interface for creating parsers
 * 
 * @author Eric Brooks
 *
 */
public interface ParserFactory {
	/**
	 * Creates a parser from an equations
	 * 
	 * @param eq
	 *            equations
	 * @return a parser for this equation
	 */
	Parser createParser(String eq);

}
