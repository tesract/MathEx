package com.dragoonsaga.mathex.parser.antlr4;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Assert;

import com.dragoonsaga.mathex.parser.Node;
import com.dragoonsaga.mathex.parser.ParseException;
import com.dragoonsaga.mathex.parser.impl.MathExListener;
import com.dragoonsaga.mathex.parser.impl.MathExParser;
import com.dragoonsaga.mathex.parser.impl.MathExParser.AddContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.ConstantContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.DivContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.ExpContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.MulContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.NegContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.StartContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.SubContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.UniContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.ValueContext;
import com.dragoonsaga.mathex.parser.impl.MathExParser.VariableContext;

public class MathExAdapterListener implements MathExListener {

	Parser parser;
	MathExParser mathExParser;
	com.dragoonsaga.mathex.parser.NodeRoot nodeRoot;
	Stack<Node> current = new Stack<Node>();

	public MathExAdapterListener(Parser parser, MathExParser mathExParser) {
		this.mathExParser = mathExParser;
		this.parser = parser;
	}

	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		throw new ParseException();
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
	}

	@Override
	public void enterAdd(AddContext ctx) {
		enter(new NodeAdd(parser));
	}

	@Override
	public void exitAdd(AddContext ctx) {
		close(NodeAdd.class);

	}

	@Override
	public void enterDiv(DivContext ctx) {
		enter(new NodeDiv(parser));
	}

	@Override
	public void exitDiv(DivContext ctx) {
		close(NodeDiv.class);

	}

	@Override
	public void enterSub(SubContext ctx) {
		enter(new NodeSub(parser));
	}

	@Override
	public void exitSub(SubContext ctx) {
		close(NodeSub.class);

	}

	@Override
	public void enterUni(UniContext ctx) {
	}

	@Override
	public void exitUni(UniContext ctx) {
	}

	@Override
	public void enterNeg(NegContext ctx) {
		enter(new NodeNeg(parser));
	}

	@Override
	public void exitNeg(NegContext ctx) {
		close(NodeNeg.class);

	}

	@Override
	public void enterConstant(ConstantContext ctx) {
		enter(new NodeConstant(parser, ctx.getText()));
	}

	@Override
	public void exitConstant(ConstantContext ctx) {
		close(NodeConstant.class);
	}

	@Override
	public void enterMul(MulContext ctx) {
		enter(new NodeMul(parser));
	}

	@Override
	public void exitMul(MulContext ctx) {
		close(NodeMul.class);
	}

	@Override
	public void enterStart(StartContext ctx) {
		nodeRoot = new NodeRoot(parser);
		current.push(nodeRoot);

		System.err.println(ctx.toStringTree(mathExParser));
	}

	@Override
	public void exitStart(StartContext ctx) {
		// close();
	}

	@Override
	public void enterVariable(VariableContext ctx) {
		enter(new NodeVariable(parser, ctx.getText()));
	}

	@Override
	public void exitVariable(VariableContext ctx) {
		close(NodeVariable.class);

	}

	@Override
	public void enterExp(ExpContext ctx) {
		enter(new NodeExp(parser));

	}

	@Override
	public void exitExp(ExpContext ctx) {
		close(NodeExp.class);

	}

	@Override
	public void enterValue(ValueContext ctx) {

	}

	@Override
	public void exitValue(ValueContext ctx) {
	}

	private void enter(Node n) {
		current.peek().addChild(n);
		current.push(n);
	}

	private void close(Class<? extends ANode> clazz) {
		Node curNode = current.pop();

		Assert.assertSame(curNode.getClass(), clazz);

		// current.peek().addChild(curNode);
	}

	public com.dragoonsaga.mathex.parser.NodeRoot getNodeRoot() {
		return nodeRoot;
	}
}
