package com.dragoonsaga.mathex;

import com.dragoonsaga.mathex.parser.Node;
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
import com.dragoonsaga.mathex.parser.Parser;
import com.dragoonsaga.mathex.parser.ParserVisitor;

/**
 * Visitor to reduce the size of trees
 * 
 * @author Eric Brooks
 *
 */
public class ReduceVisitor implements ParserVisitor {
	private Node accept(Node node, Node ret) {
		for (int i = 0; i < node.numChildren(); i++) {
			Node sn = (Node) node.getChild(i).accept(this, null);
			ret.addChild(sn, i);
		}

		return ret;
	}

	@Override
	public Object visit(NodeRoot node, Object data) {
		Parser parser = node.getParser();

		Node ret = parser.createNodeRoot();

		for (int i = 0; i < node.numChildren(); i++) {
			Node sn = (Node) node.getChild(i).accept(this, null);
			ret.addChild(sn, i);
		}

		return ret;
	}

	@Override
	public Object visit(NodeAdd node, Object data) {
		NodeAdd val1 = (NodeAdd) accept(node, node.getParser().createNodeAdd());

		if (val1.numChildren() == 1)
			return val1.getChild(0);
		else
			return val1;
	}

	@Override
	public Object visit(NodeSub node, Object data) {
		NodeSub val1 = (NodeSub) accept(node, node.getParser().createNodeSub());

		if (val1.numChildren() == 1)
			return val1.getChild(0);
		else
			return val1;
	}

	@Override
	public Object visit(NodeNeg node, Object data) {
		NodeNeg val1 = (NodeNeg) accept(node, node.getParser().createNodeNeg());

		Node child = val1.getChild(0);
		if (child instanceof NodeConstant) {
			NodeConstant c = (NodeConstant) child;
			c.setValue(Float.toString(-c.getValue()));
			return c;
		} else
			return val1;
	}

	@Override
	public Object visit(NodeMul node, Object data) {
		NodeMul val1 = (NodeMul) accept(node, node.getParser().createNodeMul());

		if (val1.numChildren() == 1)
			return val1.getChild(0);
		else
			return val1;
	}

	@Override
	public Object visit(NodeDiv node, Object data) {
		NodeDiv val1 = (NodeDiv) accept(node, node.getParser().createNodeDiv());

		if (val1.numChildren() == 1)
			return val1.getChild(0);
		else
			return val1;
	}

	@Override
	public Object visit(NodeExp node, Object data) {
		NodeExp val1 = (NodeExp) accept(node, node.getParser().createNodeExp());

		if (val1.numChildren() == 1)
			return val1.getChild(0);
		else
			return val1;
	}

	@Override
	public Object visit(NodeConstant node, Object data) {
		return node;
	}

	@Override
	public Object visit(NodeVariable node, Object data) {
		return node;
	}

	@Override
	public Object visit(NodeDerivitave dn, Object data) {
		dn.childrenAccept(this, data);

		return dn;
	}
}
