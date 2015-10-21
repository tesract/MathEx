package com.dragoonsaga.mathex;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
import com.dragoonsaga.mathex.parser.ParserVisitor;

/**
 * Visitor to generate derivative tree
 * 
 * @author Eric Brooks
 *
 */
public class DeriveVisitor implements ParserVisitor {

	private Node accept(Node node, Node ret, String val) {
		for (int i = 0; i < node.numChildren(); i++) {
			Node sn = (Node) node.getChild(i).accept(this, val);

			if (sn != null)
				ret.addChild(sn, i);
		}

		if (ret.numChildren() > 0)
			return ret;

		return null;
	}

	@Override
	public Object visit(NodeRoot node, Object data) {
		// return accept(node, new ASTStart(0), (String)data);

		return node.getParser().createDerivitaveNode(node, (String) data);
	}

	@Override
	public Object visit(NodeAdd node, Object data) {
		NodeAdd val1 = (NodeAdd) accept(node, node.getParser().createNodeAdd(),
				(String) data);

		if (val1.numChildren() > 1)
			return val1;
		else
			return val1.getChild(0);
	}

	@Override
	public Object visit(NodeSub node, Object data) {
		NodeSub val1 = (NodeSub) accept(node, node.getParser().createNodeSub(),
				(String) data);

		if (val1.numChildren() > 1)
			return val1;
		else
			return val1.getChild(0);
	}

	@Override
	public Object visit(NodeNeg node, Object data) {
		NodeNeg val1 = (NodeNeg) accept(node, node.getParser().createNodeNeg(),
				(String) data);

		return val1;
	}

	@Override
	public Object visit(NodeMul node, Object data) {
		NodeMul val1 = (NodeMul) accept(node, node.getParser().createNodeMul(),
				(String) data);

		if (val1.numChildren() > 1)
			return val1;
		else
			return val1.getChild(0);
	}

	@Override
	public Object visit(NodeDiv node, Object data) {
		NodeDiv val1 = (NodeDiv) accept(node, node.getParser().createNodeDiv(),
				(String) data);

		if (val1.numChildren() > 1)
			return val1;
		else
			return val1.getChild(0);
	}

	@Override
	public Object visit(NodeExp node, Object data) {
		NodeExp val1 = (NodeExp) accept(node, node.getParser().createNodeExp(),
				(String) data);

		if (val1.numChildren() > 1) {

			return val1;
		} else
			return val1.getChild(0);
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
	public Object visit(NodeDerivitave node, Object data) {
		throw new NotImplementedException();
	}

}
