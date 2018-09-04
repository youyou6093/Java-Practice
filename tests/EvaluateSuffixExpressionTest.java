import array.EvaluateSuffixExpression;
import org.junit.jupiter.api.Test;

class EvaluateSuffixExpressionTest {

    @Test
    void evaluate2() {
        EvaluateSuffixExpression x = new EvaluateSuffixExpression();
        System.out.println(x.evaluate2(new String[] {"2","12","4","/","+" }));
    }
}