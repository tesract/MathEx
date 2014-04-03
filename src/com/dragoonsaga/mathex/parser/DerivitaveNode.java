package com.dragoonsaga.mathex.parser;

public class DerivitaveNode extends SimpleNode 
{
	public String _var;
	
	public DerivitaveNode(SimpleNode sn, String variable) 
	{
		super(0);
		
		jjtAddChild(sn, 0);
		_var=variable;
	}

	/** Accept the visitor. **/
	public Object jjtAccept(MathExParserVisitor visitor, Object data) 
	{
		return visitor.visit(this, data);
	}
}
