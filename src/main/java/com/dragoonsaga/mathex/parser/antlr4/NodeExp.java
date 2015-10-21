package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeExp extends ANode implements
		com.dragoonsaga.mathex.parser.NodeExp {
	public NodeExp(Parser parser) {
		super(parser);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
