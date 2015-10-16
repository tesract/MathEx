package com.dragoonsaga.mathex;

import com.dragoonsaga.mathex.parser.*;

public class ValueVisitor implements MathExParserVisitor
{
	public ValueVisitor() 
	{
	}
	
	@Override
	public Object visit(ASTStart node, Object data)
	{
		Float val = (Float)node.jjtGetChild(0).jjtAccept(this, data);
		
		return val;
	}

	@Override
	public Object visit(ASTAdd node, Object data)
	{
		float ret=(Float)node.jjtGetChild(0).jjtAccept(this, data);;
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			ret += (Float)node.jjtGetChild(i).jjtAccept(this, data);			
		}
		
		return ret;
	}
	
	@Override
	public Object visit(ASTSub node, Object data)
	{
		float ret=(Float)node.jjtGetChild(0).jjtAccept(this, data);;
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			ret -= (Float)node.jjtGetChild(i).jjtAccept(this, data);			
		}
		
		return ret;
	}
	
	@Override
	public Object visit(ASTNeg node, Object data) 
	{
		float ret=(Float)node.jjtGetChild(0).jjtAccept(this, data);;
		
		return -ret;
	}
	
	@Override
	public Object visit(ASTMul node, Object data)
	{
		float ret=(Float)node.jjtGetChild(0).jjtAccept(this, data);;
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			ret *= (Float)node.jjtGetChild(i).jjtAccept(this, data);
		}
		
		return ret;
	}
	
	@Override
	public Object visit(ASTDiv node, Object data)
	{
		float ret=(Float)node.jjtGetChild(0).jjtAccept(this, data);;
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			ret /= (Float)node.jjtGetChild(i).jjtAccept(this, data);			
		}
		
		return ret;
	}
	
	@Override
	public Object visit(ASTExp node, Object data)
	{
		float ret=(Float)node.jjtGetChild(0).jjtAccept(this, data);;
		
		for(int i=1; i<node.jjtGetNumChildren(); i++)
		{
			ret = (float)Math.pow(ret, (Float)node.jjtGetChild(i).jjtAccept(this, data));			
		}
		
		return ret;
	}
	
	@Override
	public Object visit(ASTConstant node, Object data)
	{
		return node.getValue();
	}

	@Override
	public Object visit(ASTVariable node, Object data)
	{
		Func func = (Func)data;
		
		return func.get(node.getName());
	}
	
	public Object visit(DerivitaveNode dn, Object data)
	{
		Func func = (Func)data;
		
		float tmp = func.get(dn._var);
		
		func.set(dn._var, tmp-0.0001f);

		float value = (Float)visit((ASTStart)dn.jjtGetChild(0), data);
		
		func.set(dn._var, tmp+0.0001f);
		
		float value1 = (Float)visit((ASTStart)dn.jjtGetChild(0), data);
		
		func.set(dn._var, tmp);
		
		return ( value1 - value ) / 0.0002f;
	}


	@Override
	public Object visit(SimpleNode node, Object data)
	{
		return null;
	}
}
