package com.dragoonsaga.mathex;

import com.dragoonsaga.mathex.parser.*;

public class ReduceVisitor implements MathExParserVisitor
{
	public ReduceVisitor() 
	{
	}
	
	private SimpleNode accept(SimpleNode node, SimpleNode ret)
	{
		for(int i=0; i<node.jjtGetNumChildren(); i++)
		{
			SimpleNode sn = (SimpleNode)node.jjtGetChild(i).jjtAccept(this, null);
			ret.jjtAddChild(sn, i);
		}
		
		return ret;
	}
	
	@Override
	public Object visit(ASTStart node, Object data)
	{
		SimpleNode ret = new ASTStart(0);
		
		for(int i=0; i<node.jjtGetNumChildren(); i++)
		{
			SimpleNode sn = (SimpleNode)node.jjtGetChild(i).jjtAccept(this, null);
			ret.jjtAddChild(sn, i);
		}
		
		return ret;
	}	

	@Override
	public Object visit(ASTAdd node, Object data)
	{
		ASTAdd val1 = (ASTAdd)accept(node, new ASTAdd(0));
		
		if (val1.jjtGetNumChildren()==1)
			return val1.jjtGetChild(0);
		else
			return val1;
	}
	
	@Override
	public Object visit(ASTSub node, Object data)
	{
		ASTSub val1 = (ASTSub)accept(node, new ASTSub(0));
		
		if (val1.jjtGetNumChildren()==1)
			return val1.jjtGetChild(0);
		else
			return val1;
	}
	
	@Override
	public Object visit(ASTMul node, Object data)
	{
		ASTMul val1 = (ASTMul)accept(node, new ASTMul(0));
		
		if (val1.jjtGetNumChildren()==1)
			return val1.jjtGetChild(0);
		else
			return val1;
	}
	
	@Override
	public Object visit(ASTDiv node, Object data)
	{
		ASTDiv val1 = (ASTDiv)accept(node, new ASTDiv(0));
		
		if (val1.jjtGetNumChildren()==1)
			return val1.jjtGetChild(0);
		else
			return val1;
	}
	
	@Override
	public Object visit(ASTExp node, Object data)
	{
		ASTExp val1 = (ASTExp)accept(node, new ASTExp(0));
		
		if (val1.jjtGetNumChildren()==1)
			return val1.jjtGetChild(0);
		else
			return val1;
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
	
	public Object visit(DerivitaveNode dn, Object data)
	{
		dn.childrenAccept(this, data);
		
		return dn;
	}
	
	@Override
	public Object visit(SimpleNode node, Object data)
	{
		return null;
	}
}
