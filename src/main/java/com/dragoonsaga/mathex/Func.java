package com.dragoonsaga.mathex;

import java.io.PrintStream;
import java.util.HashMap;

import com.dragoonsaga.mathex.parser.Node;
import com.dragoonsaga.mathex.parser.NodeDerivitave;
import com.dragoonsaga.mathex.parser.NodeRoot;
import com.dragoonsaga.mathex.parser.ParseException;
import com.dragoonsaga.mathex.parser.ParserFactory;
import com.dragoonsaga.mathex.parser.antlr4.ParserFactoryAntlr4;

/**
 * The main entry point to MathEx
 * 
 * @author Eric Brooks
 *
 */
public class Func {
	private NodeRoot _root;

	private ParserFactory parserFactory = new ParserFactoryAntlr4();

	private HashMap<String, Float> _values = new HashMap<String, Float>();

	/**
	 * Constructs a function from an equation
	 * 
	 * @param eq
	 *            equations to generate function form
	 * @throws ParseException
	 */
	public Func(String eq) throws ParseException {
		_root = getParserFactory().createParser(eq).parse();

		System.err.println(this);

		_root = (NodeRoot) _root.accept(new ReduceVisitor(), this);

		System.err.println(this);
	}

	private Func(NodeRoot start) {
		_root = start;
	}

	/**
	 * Sets the value for a variable
	 * 
	 * @param variable
	 *            variable to set
	 * @param value
	 *            value to set
	 */
	public void set(String variable, float value) {
		_values.put(variable, value);
	}

	/**
	 * Gets the value for a variable
	 * 
	 * @param variable
	 *            variable to get
	 * @return value of the variable
	 */
	public float get(String variable) {
		return _values.get(variable);
	}

	/**
	 * @return the parserFactory
	 */
	public ParserFactory getParserFactory() {
		return parserFactory;
	}

	/**
	 * @param parserFactory
	 *            the parserFactory to set
	 */
	public void setParserFactory(ParserFactory parserFactory) {
		this.parserFactory = parserFactory;
	}

	/**
	 * Generates the derivative of this function
	 * 
	 * @param var
	 *            Variable to derive with respect to
	 * @return the derivative function
	 */
	public Func derive(String var) {

		NodeRoot root = _root.getParser().createNodeRoot();

		NodeDerivitave dNode = (NodeDerivitave) _root.accept(
				new DeriveVisitor(), var);

		root.addChild(dNode, 0);

		return new Func(root);
	}

	/**
	 * Gets the value for this function using the set variables
	 * 
	 * @return the value of this function
	 */
	public float value() {
		return (Float) _root.accept(new ValueVisitor(), this);
	}

	@Override
	public String toString() {
		return (String) _root.accept(new PrintVisitor(), this);
	}

	/**
	 * Prints the node tree to out
	 * 
	 * @param out
	 */
	public void print(PrintStream out) {
		print(_root, 0, out);
	}

	private void print(Node node, int indent, PrintStream out) {
		for (int i = 0; i < indent; i++)
			out.print("\t");

		out.println(node.getClass().getSimpleName());

		for (int i = 0; i < node.numChildren(); i++)
			print(node.getChild(i), indent + 1, out);
	}
}
