package com.dragoonsaga.mathex.parser;

/**
 * Interface for parser
 * 
 * @author Eric Brooks
 *
 */
public interface Parser {

	/**
	 * Returns the root node of a parse tree
	 * 
	 * @return the root node
	 */
	NodeRoot parse();

	/**
	 * creates an add node
	 * 
	 * @return add node
	 */
	NodeAdd createNodeAdd();

	/**
	 * creates a constant node
	 * 
	 * @return constant node
	 */
	NodeConstant createNodeConstant();

	/**
	 * creates a divide node
	 * 
	 * @return divide node
	 */
	NodeDiv createNodeDiv();

	/**
	 * creates an exponent node
	 * 
	 * @return exponent node
	 */
	NodeExp createNodeExp();

	/**
	 * creates a multiply node
	 * 
	 * @return multiply node
	 */
	NodeMul createNodeMul();

	/**
	 * creates a negative node
	 * 
	 * @return negative node
	 */
	NodeNeg createNodeNeg();

	/**
	 * creates a root node
	 * 
	 * @return root node
	 */
	NodeRoot createNodeRoot();

	/**
	 * creates a subtrace node
	 * 
	 * @return sub node
	 */
	NodeSub createNodeSub();

	/**
	 * creates a variable node
	 * 
	 * @return variable node
	 */
	NodeVariable createNodeVariable();

	/**
	 * creates a derivative node
	 * 
	 * @param node
	 *            The root node to generate a derivate from
	 * @param var
	 *            The variable to derive from
	 * @return A derivative node
	 */
	NodeDerivitave createDerivitaveNode(NodeRoot node, String var);
}
