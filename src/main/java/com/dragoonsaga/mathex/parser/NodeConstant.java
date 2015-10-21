package com.dragoonsaga.mathex.parser;

/**
 * Interface for an constant node
 * 
 * @author Eric Brooks
 *
 */
public interface NodeConstant extends Node {

	/**
	 * The value of this constant
	 * 
	 * @return the value
	 */
	float getValue();

	/**
	 * Sets the value of this constant
	 * 
	 * @param string
	 *            the value
	 */
	void setValue(String string);

}
