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
 * Visitor to generate value from a tree
 * 
 * @author Eric Brooks
 *
 */
public class ValueVisitor implements ParserVisitor {

	@Override
	public Object visit(NodeRoot node, Object data) {
		Float val = (Float) node.getChild(0).accept(this, data);

		return val;
	}

	@Override
	public Object visit(NodeAdd node, Object data) {
		float ret = (Float) node.getChild(0).accept(this, data);

		for (int i = 1; i < node.numChildren(); i++) {
			ret += (Float) node.getChild(i).accept(this, data);
		}

		return ret;
	}

	@Override
	public Object visit(NodeSub node, Object data) {
		float ret = (Float) node.getChild(0).accept(this, data);

		for (int i = 1; i < node.numChildren(); i++) {
			ret -= (Float) node.getChild(i).accept(this, data);
		}

		return ret;
	}

	@Override
	public Object visit(NodeNeg node, Object data) {
		float ret = (Float) node.getChild(0).accept(this, data);

		return -ret;
	}

	@Override
	public Object visit(NodeMul node, Object data) {
		float ret = (Float) node.getChild(0).accept(this, data);

		for (int i = 1; i < node.numChildren(); i++) {
			ret *= (Float) node.getChild(i).accept(this, data);
		}

		return ret;
	}

	@Override
	public Object visit(NodeDiv node, Object data) {
		float ret = (Float) node.getChild(0).accept(this, data);

		for (int i = 1; i < node.numChildren(); i++) {
			ret /= (Float) node.getChild(i).accept(this, data);
		}

		return ret;
	}

	@Override
	public Object visit(NodeExp node, Object data) {
		float ret = (Float) node.getChild(0).accept(this, data);

		for (int i = 1; i < node.numChildren(); i++) {
			ret = (float) Math.pow(ret,
					(Float) node.getChild(i).accept(this, data));
		}

		return ret;
	}

	@Override
	public Object visit(NodeConstant node, Object data) {
		return node.getValue();
	}

	@Override
	public Object visit(NodeVariable node, Object data) {
		Func func = (Func) data;

		return func.get(node.getName());
	}

	@Override
	public Object visit(NodeDerivitave dn, Object data) {
		Func func = (Func) data;

		float tmp = func.get(dn.getVar());

		func.set(dn.getVar(), tmp - 0.0001f);

		float value = (Float) visit((NodeRoot) dn.getChild(0), data);

		func.set(dn.getVar(), tmp + 0.0001f);

		float value1 = (Float) visit((NodeRoot) dn.getChild(0), data);

		func.set(dn.getVar(), tmp);

		return (value1 - value) / 0.0002f;
	}

}
