package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeConstant extends ANode implements
		com.dragoonsaga.mathex.parser.NodeConstant {

	float value;

	public NodeConstant(Parser parser, String value) {
		super(parser);
		setValue(value);
	}

	@Override
	public float getValue() {
		return value;
	}

	@Override
	public void setValue(String val) {
		value = Float.parseFloat(val);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

}
