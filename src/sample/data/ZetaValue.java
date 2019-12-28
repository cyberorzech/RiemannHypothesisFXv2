package sample.data;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.special.Gamma;

public class ZetaValue {
    private Complex result;
    private static final Complex TWO = new Complex(2, 0);
    private static final Complex ONE = new Complex(1,0);
    private static final Complex PI = new Complex(0 + Math.PI, 0);
    private static final Complex HALFPI = new Complex(0 + Math.PI/2, 0);
    public static double leastAbsValue = 100000.0;
    public static double whichIterationLeastAbsValueHappened;
    private int n = 1;
    private Complex end = new Complex(0.5, 0.5);

    public ZetaValue(Complex z, double m)
    {
        result = compute(z);
        checkIfLeast(result, m);
    }

    private void checkIfLeast(Complex z, double m)
    {
        double currentAbsValue = absoluteValue(z);
        if (currentAbsValue < leastAbsValue)
        {
            leastAbsValue = currentAbsValue;
            whichIterationLeastAbsValueHappened = m;
        }
    }
    public Complex getter()
    {
        return this.result;
    }

    private Complex compute(Complex x)
    {
        if (n == 10)
        {
            return end;
        }
        Complex twoPowX = TWO.pow(x);
        Complex piPowX = PI.pow((x.subtract(ONE)));
        Complex sineArg = x.multiply(HALFPI);
        Complex sine = sineArg.sin();
        //Complex gammaValue = Gamma.gamma((ONE.subtract(x)));
        double gammaValue = Gamma.gamma(0.5);
        ++n;
        Complex zetaBetaValue = this.compute(ONE.subtract(x));
        return twoPowX.multiply(piPowX).multiply(sine).multiply(gammaValue).multiply(zetaBetaValue);
    }
    private double absoluteValue(Complex z)
    {
        return z.abs();
    }
}
