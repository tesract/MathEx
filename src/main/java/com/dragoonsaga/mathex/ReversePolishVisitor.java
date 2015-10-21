package com.dragoonsaga.mathex;

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
 * Visitor to print this tree in reverse polish notation
 * 
 * @author Eric Brooks
 *
 */
public class ReversePolishVisitor implements ParserVisitor {

	@Override
	public Object visit(NodeRoot node, Object data) {
		return node.getChild(0).accept(this, data);
	}

	@Override
	public Object visit(NodeAdd node, Object data) {
		String val = (String) node.getChild(0).accept(this, data);

		if (node.numChildren() > 1) {
			String val2 = (String) node.getChild(1).accept(this, data);

			val = "+ " + val + " " + val2;
		}

		return val;
	}

	@Override
	public Object visit(NodeSub node, Object data) {
		String val = (String) node.getChild(0).accept(this, data);

		if (node.numChildren() > 1) {
			String val2 = (String) node.getChild(1).accept(this, data);

			val = "- " + val + " " + val2;
		}

		return val;
	}

	@Override
	public Object visit(NodeNeg node, Object data) {
		String val = (String) node.getChild(0).accept(this, data);

		return "-" + val;
	}

	@Override
	public Object visit(NodeMul node, Object data) {
		String val = (String) node.getChild(0).accept(this, data);

		if (node.numChildren() > 1) {
			String val2 = (String) node.getChild(1).accept(this, data);

			val = "* " + val + " " + val2;
		}

		return val;
	}

	@Override
	public Object visit(NodeDiv node, Object data) {
		String val = (String) node.getChild(0).accept(this, data);

		if (node.numChildren() > 1) {
			String val2 = (String) node.getChild(1).accept(this, data);

			val = "/ " + val + " " + val2;
		}

		return val;
	}

	@Override
	public Object visit(NodeExp node, Object data) {
		String val = (String) node.getChild(0).accept(this, data);

		if (node.numChildren() > 1) {
			String val2 = (String) node.getChild(1).accept(this, data);

			val = "^ " + val + " " + val2;
		}

		return val;
	}

	@Override
	public Object visit(NodeConstant node, Object data) {
		return Float.toString(node.getValue());
	}

	@Override
	public Object visit(NodeVariable node, Object data) {
		return node.getName();
	}

	@Override
	public Object visit(NodeDerivitave dn, Object data) {
		return "D[" + (String) dn.getChild(0).accept(this, data) + ","
				+ dn.getVar() + "]";
	}

}
