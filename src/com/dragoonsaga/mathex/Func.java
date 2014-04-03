package com.dragoonsaga.mathex;

import java.util.HashMap;

import com.dragoonsaga.mathex.parser.*;

public class Func
{
	ASTStart _root;
	
	HashMap<String, Float> _values=new HashMap<String, Float>();
	
	public Func(String eq) throws ParseException
	{
		MathExParser mep=new MathExParser(new java.io.StringReader(eq));
		
		_root = mep.Start();

		_root= (ASTStart)_root.jjtAccept(new ReduceVisitor(), this);
	}
	
	private Func(ASTStart start)
	{
		_root = start;
	}
	
	private Func(SimpleNode start)
	{
		this(new ASTStart(0));
		
		_root.jjtAddChild(start, 0);
	}
	
	public void set(String s, float value)
	{
		_values.put(s, value);
	}
	
	public float get(String s)
	{
		return _values.get(s);
	}
	
	public Func derive(String var)
	{
		return new Func((DerivitaveNode)_root.jjtAccept(new DeriveVisitor(), var));
	}
	
	public float value()
	{
		return (Float)_root.jjtAccept(new ValueVisitor(), this);
	}
	
	public String toString()
	{
		return (String)_root.jjtAccept(new PrintVisitor(), this);
	}
	
	private void print(Node node, int indent)
	{
		for(int i=0; i<indent; i++)
			System.out.print("\t");

		System.out.println(node.getClass().getSimpleName());
		
		for(int i=0; i<node.jjtGetNumChildren(); i++)
			print(node.jjtGetChild(i), indent+1);
	}
}
