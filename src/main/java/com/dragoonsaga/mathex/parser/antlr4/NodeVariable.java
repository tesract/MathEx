package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeVariable extends ANode implements
		com.dragoonsaga.mathex.parser.NodeVariable {

	public NodeVariable(Parser parser, String name) {
		super(parser);
		setName(name);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
