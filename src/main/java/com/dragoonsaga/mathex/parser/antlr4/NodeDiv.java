package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeDiv extends ANode implements
		com.dragoonsaga.mathex.parser.NodeDiv {
	public NodeDiv(Parser parser) {
		super(parser);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
