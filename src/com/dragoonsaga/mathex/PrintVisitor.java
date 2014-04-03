package com.dragoonsaga.mathex;

import com.dragoonsaga.mathex.parser.*;

public class PrintVisitor implements MathExParserVisitor
{
	public PrintVisitor() 
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
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			String val2 = (String)node.jjtGetChild(i).jjtAccept(this, data);
			
			val += "+"+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTSub node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			String val2 = (String)node.jjtGetChild(i).jjtAccept(this, data);
			
			val += "-"+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTMul node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			String val2 = (String)node.jjtGetChild(i).jjtAccept(this, data);
			
			val += "*"+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTDiv node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			String val2 = (String)node.jjtGetChild(i).jjtAccept(this, data);
			
			val += "/"+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTExp node, Object data)
	{
		String val = (String)node.jjtGetChild(0).jjtAccept(this, data);
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			String val2 = (String)node.jjtGetChild(i).jjtAccept(this, data);
			
			val += "^"+val2;
		}
		
		return val;
	}
	
	@Override
	public Object visit(ASTConstant node, Object data)
	{
		float value = node.getValue();
		
		if (Math.floor(value)==value)
		{
			return Integer.toString((int)Math.floor(value));
		}
		
		return Float.toString(value);
	}

	@Override
	public Object visit(ASTVariable node, Object data)
	{
		return node.getName();
	}

	public Object visit(DerivitaveNode dn, Object data)
	{
		return "D["+(String)dn.jjtGetChild(0).jjtAccept(this, data)+","+dn._var+"]";
	}
	
	@Override
	public Object visit(SimpleNode node, Object data)
	{
		return null;
	}
}
