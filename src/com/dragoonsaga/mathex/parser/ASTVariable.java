/* Generated By:JJTree: Do not edit this line. ASTVariable.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.dragoonsaga.mathex.parser;

public
class ASTVariable extends SimpleNode {
  public ASTVariable(int id) {
    super(id);
  }

  public ASTVariable(MathExParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MathExParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  private String _name;
  public void setName(String name) { _name=name; }
  public String getName() { return _name; }
}
/* JavaCC - OriginalChecksum=276ad669faa064a8119a5f143d671ecb (do not edit this line) */
