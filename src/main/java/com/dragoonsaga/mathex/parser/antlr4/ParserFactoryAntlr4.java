package com.dragoonsaga.mathex.parser.antlr4;

import com.dragoonsaga.mathex.parser.ParserFactory;

public class ParserFactoryAntlr4 implements ParserFactory {
	@Override
	public com.dragoonsaga.mathex.parser.Parser createParser(String eq) {
		return new Parser(eq);
	}

}
