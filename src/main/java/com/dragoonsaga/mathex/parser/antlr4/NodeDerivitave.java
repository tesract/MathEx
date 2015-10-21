package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserVisitor;

public class NodeDerivitave extends ANode implements
		com.dragoonsaga.mathex.parser.NodeDerivitave {
	String var;

	public NodeDerivitave(Parser parser, String var) {
		super(parser);
		setVar(var);
	}

	@Override
	public Object accept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

	@Override
	public String getVar() {
		return var;
	}

	@Override
	public void setVar(String var) {
		this.var = var;
	}

}
