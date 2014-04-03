/* Generated By:JJTree: Do not edit this line. ASTConstant.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.dragoonsaga.mathex.parser;

public
class ASTConstant extends SimpleNode {
  public ASTConstant(int id) {
    super(id);
  }

  public ASTConstant(MathExParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MathExParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  
  private float _value;
  
  public float getValue() { return _value; }
  public void setValue(String value) { _value= Float.parseFloat(value); } 
}
/* JavaCC - OriginalChecksum=38a05249663612dcd8ba1c0c4328a23f (do not edit this line) */