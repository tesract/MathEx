package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeNeg extends ANode implements
		com.dragoonsaga.mathex.parser.NodeNeg {
	public NodeNeg(Parser parser) {
		super(parser);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
