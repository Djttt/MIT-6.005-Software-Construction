package expressivo;

import expressivo.parser.ExpressionListener;
import expressivo.parser.ExpressionParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

class PrintEverything implements ExpressionListener {


    @Override
    public void enterRoot(ExpressionParser.RootContext ctx) {
        System.err.println("entering root");
    }

    @Override
    public void exitRoot(ExpressionParser.RootContext ctx) {
        System.err.println("exiting root");
    }

    @Override
    public void enterPolynomial_calculate(ExpressionParser.Polynomial_calculateContext ctx) {
        System.err.println("entering Polynomial_calculate");
    }

    @Override
    public void exitPolynomial_calculate(ExpressionParser.Polynomial_calculateContext ctx) {
        System.err.println("exiting exitPolynomial_calculate");
    }

    @Override
    public void enterAdd_expr(ExpressionParser.Add_exprContext ctx) {
        System.err.println("entering Add_expr");
    }

    @Override
    public void exitAdd_expr(ExpressionParser.Add_exprContext ctx) {
        System.err.println("exiting Add_expr");
    }

    @Override
    public void enterMul_expr(ExpressionParser.Mul_exprContext ctx) {
        System.err.println("entering Mul_expr");
    }

    @Override
    public void exitMul_expr(ExpressionParser.Mul_exprContext ctx) {
        System.err.println("exiting Mul_expr");
    }

    @Override
    public void enterPrimitive(ExpressionParser.PrimitiveContext ctx) {
        System.err.println("entering primitive");
    }

    @Override
    public void exitPrimitive(ExpressionParser.PrimitiveContext ctx) {
        System.err.println("exiting primitive");
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {
        System.err.println("terminal " + terminalNode.getText());
    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}