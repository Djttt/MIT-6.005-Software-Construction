package expressivo;

import expressivo.parser.ExpressionListener;
import expressivo.parser.ExpressionParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Stack;

public class MakeExpresion implements ExpressionListener {
    private Stack<Expression> stack = new Stack<>();

    public Expression getExpression() throws IllegalArgumentException{
        return stack.get(0);  // root expression
    }

    @Override
    public void exitAdd_expr(ExpressionParser.Add_exprContext ctx) throws IllegalArgumentException{
        List<ExpressionParser.Mul_exprContext> terms = ctx.mul_expr();
        assert stack.size() >= terms.size();

        Expression expr = stack.pop();  // last term
        for (int i = 1; i < terms.size(); ++i) {
            expr = new Add(stack.pop(), expr);
        }

        stack.push(expr);
    }


    @Override
    public void exitMul_expr(ExpressionParser.Mul_exprContext ctx) throws IllegalArgumentException{
        List<ExpressionParser.PrimitiveContext> factors = ctx.primitive();
        assert stack.size() >= factors.size();

        Expression expr = stack.pop();  // last factor
        for (int i = 1; i < factors.size(); ++i) {
            expr = new Mul(stack.pop(), expr);
        }

        stack.push(expr);
    }


    @Override
    public void exitPrimitive(ExpressionParser.PrimitiveContext ctx) throws IllegalArgumentException{
        if (ctx.NUMBER() != null) {
            double value = Double.parseDouble(ctx.NUMBER().getText());
            stack.push(new Constant(value));
        } else {
            // Parenthesized expression, its value is already on the stack.
            if (ctx.ID() != null) {
                String variable = ctx.ID().getText();
                stack.push(new Variable(variable));
            }
        }
    }

    // Empty implementations (not needed but required by interface)
    @Override public void enterRoot(ExpressionParser.RootContext ctx) { }
    @Override public void exitRoot(ExpressionParser.RootContext ctx) { }
    @Override public void enterPolynomial_calculate(ExpressionParser.Polynomial_calculateContext ctx) { }
    @Override public void exitPolynomial_calculate(ExpressionParser.Polynomial_calculateContext ctx) { }
    @Override public void enterAdd_expr(ExpressionParser.Add_exprContext ctx) { }
    @Override public void enterMul_expr(ExpressionParser.Mul_exprContext ctx) { }
    @Override public void enterPrimitive(ExpressionParser.PrimitiveContext ctx) { }
    @Override public void visitTerminal(TerminalNode terminalNode) { }
    @Override
    public void visitErrorNode(ErrorNode errorNode) {}
    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {}
    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {}
}
