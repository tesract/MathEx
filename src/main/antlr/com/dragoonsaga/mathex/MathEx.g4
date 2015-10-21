
grammar MathEx;

@header {
	package com.dragoonsaga.mathex.parser.impl;
}

fragment LETTER: [a-zA-Z];
fragment NUMBER: [0-9];

INT: NUMBER+;
FLOAT: NUMBER+ '.' NUMBER+;
IDENTIFIER: LETTER (LETTER | NUMBER)*;


start: add;

add:
	add '+' sub
	| sub;
   
sub:
	sub '-' mul
	| mul;

mul: 
	mul '*' div
	| div
	;
   
div: 
	div '/' exp
	| exp;
   
exp: uni
   | exp '^' uni;
   
uni: value
   | '(' add ')'
   | '-' neg;
   
neg: add;

value:
	constant
	| variable;
	
constant: 
	INT
	| FLOAT;

variable:
	IDENTIFIER;
