
MathEx -- Mathematical Expressions
==================================

Introduction
------------

MathEx defines mathematical expression language using JJTree (https://javacc.java.net/doc/JJTree.html) to define a parser.

Probably the best introduction is to look at https://github.com/tesract/MathEx/blob/master/src/MathExTest.java  which has several tests which also serve as examples.

Example
-------

Func f = new Func("a*x^3+b*x^2+c*x+d");

		f.set("a", 1);
		f.set("b", 1);
		f.set("c", 1);
		f.set("d", 1);

		f.set("x", 1);

		Assert.assertEquals(4, f.value(), 0.0001f);

Future Plans
------------

Finish the DeriveVisitor implementation so it can handle polynomial expressions with out resorting to value based deravites.

Add functionality to find the zero's of a function.


