package com.dragoonsaga.mathex;

import com.dragoonsaga.mathex.parser.*;

public class ReversePolishVisitor implements MathExParserVisitor
{
	public ReversePolishVisitor() 
	{
	}
	
	@Override
	public Object visit(ASTStart node, Object data)
	{
		return node.jjtGetChild(0).jjtAccept(this, data);
	}

	@Override
	public Object visit(ASTAdd node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		if (node.jjtGetNumChildren()>1)
		{
			String val2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
			
			val="+ "+val+" "+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTSub node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		if (node.jjtGetNumChildren()>1)
		{
			String val2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
			
			val="- "+val+" "+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTNeg node, Object data) 
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		return "-" + val;
	}
	
	@Override
	public Object visit(ASTMul node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		if (node.jjtGetNumChildren()>1)
		{
			String val2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
			
			val="* "+val+" "+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTDiv node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		if (node.jjtGetNumChildren()>1)
		{
			String val2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
			
			val="/ "+val+" "+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTExp node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		if (node.jjtGetNumChildren()>1)
		{
			String val2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
			
			val="^ "+val+" "+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTConstant node, Object data)
	{
		return Float.toString(node.getValue());
	}

	@Override
	public Object visit(ASTVariable node, Object data)
	{
		return node.getName();
	}
	
	public Object visit(DerivitaveNode dn, Object data)
	{
		return "D["+(String)visit((SimpleNode)dn.jjtGetChild(0), data)+","+(String)data+"]";
	}

	@Override
	public Object visit(SimpleNode node, Object data)
	{
		return null;
	}
}
