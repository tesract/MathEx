package com.dragoonsaga.mathex.parser;

/**
 * Interface for all node types
 * 
 * @author Eric Brooks
 *
 */
public interface Node {

	/**
	 * Gets the name of this node
	 * 
	 * @return this name
	 */
	public String getName();

	/**
	 * The number of child nodes
	 * 
	 * @return number of child nodes
	 */
	public int numChildren();

	/**
	 * Returns the node at the specified position of the children
	 *
	 * @param i
	 *            index of the child to return
	 * @return the child at the specified position in the children list
	 */
	public Node getChild(int i);

	/**
	 * Appends the specified node to the end of the child list.
	 *
	 * @param node
	 *            node to be appended to the child list
	 */
	public void addChild(Node node);

	/**
	 * Inserts the specified node at the specified position in the child list.
	 * Shifts the node currently at that position (if any) and any subsequent
	 * nodes to the right (adds one to their indices).
	 *
	 * @param node
	 *            node to be inserted
	 * @param i
	 *            index at which the specified node is to be inserted
	 */
	public void addChild(Node node, int i);

	/**
	 * Calls {@link ParserVisitor}.visit on the passed in visitor, used so calls
	 * resolve to correct method
	 * 
	 * @param visitor
	 *            the visitor to use during this walk
	 * @param data
	 *            extra data passed long the walk
	 * @return what ever object the visitor returns
	 */
	public Object accept(ParserVisitor visitor, Object data);

	/**
	 * Helper function to run accept on all children of this node similar to
	 * accept
	 * 
	 * @param visitor
	 *            the visitor to call .visit on for each child
	 * @param data
	 *            data to pass along
	 * @return returns the data passed in
	 */
	public Object childrenAccept(ParserVisitor visitor, Object data);

	/**
	 * Used to get the parser that created this object
	 * 
	 * @return the parser
	 */
	public Parser getParser();

	/**
	 * Sets the parser
	 * 
	 * @param parser
	 *            the parser
	 */
	public void setParser(Parser parser);

}
