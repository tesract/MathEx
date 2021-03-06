package com.dragoonsaga.mathex;

import org.junit.Assert;
import org.junit.Test;

import com.dragoonsaga.mathex.parser.ParseException;

public class MathExTest {
	@Test
	public void varTest() throws ParseException {
		Func f = new Func("a");

		Assert.assertEquals("a", f.toString());
	}

	@Test
	public void addTest() throws ParseException {
		Func f = new Func("a+b+c");

		Assert.assertEquals("a+b+c", f.toString());
	}

	@Test
	public void subTest() throws ParseException {
		Func f = new Func("a-b-c");

		Assert.assertEquals("a-b-c", f.toString());
	}

	@Test
	public void mulTest() throws ParseException {
		Func f = new Func("3*a*b*c");

		Assert.assertEquals("3*a*b*c", f.toString());
	}

	@Test
	public void print2Test() throws ParseException {
		Func f = new Func("a*x^3+b*x^2+c*x+d");

		Assert.assertEquals("a*x^3+b*x^2+c*x+d", f.toString());
	}

	@Test
	public void syntaxDefinitionTest() throws ParseException {
		Func f = new Func("a*x^3+b*x^2+c*x+d");

		f.set("a", 1);
		f.set("b", 1);
		f.set("c", 1);
		f.set("d", 1);

		f.set("x", 1);

		Assert.assertEquals(4, f.value(), 0.0001f);
	}

	@Test
	public void testNegativeParen() throws ParseException {
		Func f = new Func("-(x)");

		Assert.assertEquals("-x", f.toString());
	}

	@Test
	public void testNegativeConstant() throws ParseException {
		Func f = new Func("-5");

		Assert.assertEquals(-5, f.value(), 0.0001f);
	}

	@Test
	public void testNegativeMulti() throws ParseException {
		Func f = new Func("x*-1");

		Assert.assertEquals("x*-1", f.toString());
	}

	@Test
	public void derivitavePrintTest() throws ParseException {
		Func f = new Func("a*x^3+b*x^2+c*x+d");

		Func ff = f.derive("x");

		Assert.assertEquals("3*a*x^2+2*b*x+c", ff.toString());
	}

	@Test
	public void valueTest() throws ParseException {
		Func f = new Func("a*x^3+b*x^2+c*x+d");

		f.set("a", 0);
		f.set("b", 0);
		f.set("c", 1);
		f.set("d", 1);
		f.set("x", 0);

		Assert.assertEquals(1, f.value(), 0.0001f);

	}

	@Test
	public void derivitaveValueTest() throws ParseException {
		Func f = new Func("a*x+b");

		Func ff = f.derive("x");

		// System.out.println(ff._root.accept(new ReversePolishVisitor(),
		// this));

		ff.set("a", 1);
		ff.set("b", 1);
		ff.set("x", 0);

		Assert.assertEquals(1f, ff.value(), 0.001f);
	}
}
