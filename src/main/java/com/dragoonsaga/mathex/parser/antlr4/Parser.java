package com.dragoonsaga.mathex.parser.antlr4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.dragoonsaga.mathex.parser.NodeAdd;
import com.dragoonsaga.mathex.parser.NodeConstant;
import com.dragoonsaga.mathex.parser.NodeDerivitave;
import com.dragoonsaga.mathex.parser.NodeDiv;
import com.dragoonsaga.mathex.parser.NodeExp;
import com.dragoonsaga.mathex.parser.NodeMul;
import com.dragoonsaga.mathex.parser.NodeNeg;
import com.dragoonsaga.mathex.parser.NodeRoot;
import com.dragoonsaga.mathex.parser.NodeSub;
import com.dragoonsaga.mathex.parser.NodeVariable;
import com.dragoonsaga.mathex.parser.impl.MathExLexer;
import com.dragoonsaga.mathex.parser.impl.MathExParser;
import com.dragoonsaga.mathex.parser.impl.MathExParser.StartContext;

public class Parser implements com.dragoonsaga.mathex.parser.Parser {

	String eq;

	public Parser(String eq) {
		this.eq = eq;
	}

	@Override
	public NodeRoot parse() {
		MathExLexer lexer = new MathExLexer(new ANTLRInputStream(eq));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathExParser parser = new MathExParser(tokens);
		parser.removeErrorListeners();

		StartContext start = parser.start();

		MathExAdapterListener adapterListener = new MathExAdapterListener(this,
				parser);

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(adapterListener, start);

		return adapterListener.getNodeRoot();
	}

	@Override
	public NodeAdd createNodeAdd() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeAdd(this);
	}

	@Override
	public NodeConstant createNodeConstant() {
		throw new NotImplementedException();
	}

	@Override
	public NodeDiv createNodeDiv() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeDiv(this);
	}

	@Override
	public NodeExp createNodeExp() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeExp(this);
	}

	@Override
	public NodeMul createNodeMul() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeMul(this);
	}

	@Override
	public NodeNeg createNodeNeg() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeNeg(this);
	}

	@Override
	public NodeRoot createNodeRoot() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeRoot(this);
	}

	@Override
	public NodeSub createNodeSub() {
		return new com.dragoonsaga.mathex.parser.antlr4.NodeSub(this);
	}

	@Override
	public NodeVariable createNodeVariable() {
		throw new NotImplementedException();
	}

	@Override
	public NodeDerivitave createDerivitaveNode(NodeRoot node, String data) {
		com.dragoonsaga.mathex.parser.antlr4.NodeDerivitave ret;

		ret = new com.dragoonsaga.mathex.parser.antlr4.NodeDerivitave(this,
				data);

		ret.addChild(node);

		return ret;

	}

}
