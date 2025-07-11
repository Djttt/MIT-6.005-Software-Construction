// Generated from Expression.g4 by ANTLR 4.5.1

package expressivo.parser;
// Do not edit this .java file! Edit the grammar in Expression.g4 and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link ExpressionParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(ExpressionParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(ExpressionParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#polynomial_calculate}.
   * @param ctx the parse tree
   */
  void enterPolynomial_calculate(ExpressionParser.Polynomial_calculateContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#polynomial_calculate}.
   * @param ctx the parse tree
   */
  void exitPolynomial_calculate(ExpressionParser.Polynomial_calculateContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#add_expr}.
   * @param ctx the parse tree
   */
  void enterAdd_expr(ExpressionParser.Add_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#add_expr}.
   * @param ctx the parse tree
   */
  void exitAdd_expr(ExpressionParser.Add_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#mul_expr}.
   * @param ctx the parse tree
   */
  void enterMul_expr(ExpressionParser.Mul_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#mul_expr}.
   * @param ctx the parse tree
   */
  void exitMul_expr(ExpressionParser.Mul_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#primitive}.
   * @param ctx the parse tree
   */
  void enterPrimitive(ExpressionParser.PrimitiveContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#primitive}.
   * @param ctx the parse tree
   */
  void exitPrimitive(ExpressionParser.PrimitiveContext ctx);
}