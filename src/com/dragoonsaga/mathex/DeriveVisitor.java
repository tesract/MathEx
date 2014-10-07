package com.dragoonsaga.mathex;

import com.dragoonsaga.mathex.parser.*;

public class DeriveVisitor implements MathExParserVisitor
{
	public DeriveVisitor() { }
	
	private Node accept(Node node, Node ret, String val)
	{
		for(int i=0; i<node.jjtGetNumChildren(); i++)
		{
			SimpleNode sn = (SimpleNode)node.jjtGetChild(i).jjtAccept(this, val);
			
			if (sn!=null)
				ret.jjtAddChild(sn, i);
		}
		
		if (ret.jjtGetNumChildren()>0)
			return ret;
		
		return null;
	}
	
	@Override
	public Object visit(ASTStart node, Object data)
	{
		//return accept(node, new ASTStart(0), (String)data);
		
		return new DerivitaveNode(node, (String)data);
	}	

	@Override
	public Object visit(ASTAdd node, Object data)
	{
		ASTAdd val1 = (ASTAdd)accept(node, new ASTAdd(0), (String)data);
		
		if (val1.jjtGetNumChildren()>1)
			return val1;
		else
			return val1.jjtGetChild(0);
	}
	
	@Override
	public Object visit(ASTSub node, Object data)
	{
		ASTSub val1 = (ASTSub)accept(node, new ASTSub(0), (String)data);
		
		if (val1.jjtGetNumChildren()>1)
			return val1;
		else
			return val1.jjtGetChild(0);
	}
	
	@Override
	public Object visit(ASTNeg node, Object data) 
	{
		ASTNeg val1 = (ASTNeg)accept(node, new ASTNeg(0), (String)data);
		
		Node child = val1.jjtGetChild(0);
		if (child instanceof ASTConstant)
		{
			return -((ASTConstant)child).getValue();			
		}
		else
			return val1;
	}
	
	@Override
	public Object visit(ASTMul node, Object data)
	{
		ASTMul val1 = (ASTMul)accept(node, new ASTMul(0), (String)data);
		
		if (val1.jjtGetNumChildren()>1)
			return val1;
		else
			return val1.jjtGetChild(0);
	}
	
	@Override
	public Object visit(ASTDiv node, Object data)
	{
		ASTDiv val1 = (ASTDiv)accept(node, new ASTDiv(0), (String)data);
		
		if (val1.jjtGetNumChildren()>1)
			return val1;
		else
			return val1.jjtGetChild(0);
	}
	
	@Override
	public Object visit(ASTExp node, Object data)
	{
		ASTExp val1 = (ASTExp)accept(node, new ASTExp(0), (String)data);
		
		if (val1.jjtGetNumChildren()>1)
		{
			
			return val1;
		}
		else
			return val1.jjtGetChild(0);
	}
	
	@Override
	public Object visit(ASTConstant node, Object data)
	{
		return node;
	}

	@Override
	public Object visit(ASTVariable node, Object data)
	{
		return node;
	}
	
	@Override
	public Object visit(DerivitaveNode node, Object data) {
		return null;
	}

	@Override
	public Object visit(SimpleNode node, Object data)
	{
		return null;
	}
}
