package com.dragoonsaga.mathex.parser;

/**
 * Interface for a parser visitor.
 * 
 * @author Eric Brooks
 *
 */
public interface ParserVisitor {

	Object visit(NodeRoot node, Object data);

	Object visit(NodeAdd node, Object data);

	Object visit(NodeSub node, Object data);

	Object visit(NodeMul node, Object data);

	Object visit(NodeDiv node, Object data);

	Object visit(NodeExp node, Object data);

	Object visit(NodeNeg node, Object data);

	Object visit(NodeConstant node, Object data);

	Object visit(NodeVariable node, Object data);

	Object visit(NodeDerivitave node, Object data);

}
