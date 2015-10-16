
MathEx -- Mathematical Expressions
==================================

Introduction
------------

MathEx defines mathematical expression language using JJTree (https://javacc.java.net/doc/JJTree.html) to define a parser.

Probably the best introduction is to look at https://github.com/tesract/MathEx/blob/master/src/test/java/MathExTest.java  which has several tests which also serve as examples.

Building
--------

To build from source run these commands:

	git clone http://github.com/tesract/MathEx
	cd MathEx
	gradle jar

After that you should have a MathEx.jar file sitting in the MathEx folder which is ready to use.

Example
-------

```java
		Func f = new Func("a*x^3+b*x^2+c*x+d");

		f.set("a", 1);
		f.set("b", 1);
		f.set("c", 1);
		f.set("d", 1);

		f.set("x", 1);

		Assert.assertEquals(4, f.value(), 0.0001f); //0.0001f allowable error
```

Future Plans
------------

Finish the DeriveVisitor implementation so it can handle polynomial expressions with out resorting to value based deravites.

Add functionality to find the zero's of a function.
