package com.dragoonsaga.mathex.parser.antlr4;

import java.util.ArrayList;

import com.dragoonsaga.mathex.parser.Node;
import com.dragoonsaga.mathex.parser.Parser;
import com.dragoonsaga.mathex.parser.ParserVisitor;

public abstract class ANode implements Node {

	private String name;
	protected ArrayList<Node> children;
	private Parser parser;

	public ANode(Parser parser) {
		this.parser = parser;
		children = new ArrayList<Node>();
	}

	protected void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int numChildren() {
		return children.size();
	}

	@Override
	public Node getChild(int i) {
		return children.get(i);
	}

	@Override
	public void addChild(Node node) {
		children.add(node);
	}

	@Override
	public void addChild(Node node, int i) {
		children.add(i, node);
	}

	@Override
	abstract public Object accept(ParserVisitor visitor, Object data);

	@Override
	public Object childrenAccept(ParserVisitor visitor, Object data) {
		if (children != null) {
			for (Node child : children)
				child.accept(visitor, data);
		}

		return data;
	}

	@Override
	public Parser getParser() {
		return parser;
	}

	@Override
	public void setParser(Parser parser) {
		this.parser = parser;
	}

}
