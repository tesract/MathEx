package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeRoot extends ANode implements
		com.dragoonsaga.mathex.parser.NodeRoot {
	public NodeRoot(Parser parser) {
		super(parser);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
