package com.dragoonsaga.mathex.parser;

/**
 * Interface for a deriviate node
 * 
 * @author Eric Brooks
 *
 */
public interface NodeDerivitave extends Node {
	/**
	 * The variable for this node
	 * 
	 * @return the variable
	 */
	public String getVar();

	/**
	 * Sets the variable for the node
	 * 
	 * @param var
	 *            the variable
	 */
	public void setVar(String var);
}
