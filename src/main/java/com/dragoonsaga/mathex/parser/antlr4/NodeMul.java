package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeMul extends ANode implements
		com.dragoonsaga.mathex.parser.NodeMul {
	public NodeMul(Parser parser) {
		super(parser);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
