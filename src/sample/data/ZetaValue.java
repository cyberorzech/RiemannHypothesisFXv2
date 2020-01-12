package sample.data;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.special.Gamma;

public class ZetaValue {
    private static final Complex TWO = new Complex(2, 0);
    private static final Complex ONE = new Complex(1, 0);
    private static final Complex PI = new Complex(0 + Math.PI, 0);
    private static final Complex HALFPI = new Complex(0 + Math.PI / 2, 0);
    private Complex result;
    private double absoluteValue;
    private int n = 1;
    private Complex end = new Complex(0.5, 0.5);

    public ZetaValue(Complex z) {
        result = compute(z);
        absoluteValue = result.abs();
    }

    public double absoluteValueGetter() {
        return absoluteValue;
    }

    public Complex getter() {
        return this.result;
    }

    /**
     * Method which actually computes the zeta value. Note that tenth iterations returns non correct value which is (0.5, 0.5).
     *
     * @param x Complex number with Real and Imag part requested by user
     */
    private Complex compute(Complex x) {
        if (n == 10) {
            return end;
        }
        Complex twoPowX = TWO.pow(x);
        Complex piPowX = PI.pow((x.subtract(ONE)));
        Complex sineArg = x.multiply(HALFPI);
        Complex sine = sineArg.sin();
        double gammaValue = Gamma.gamma(0.5);
        ++n;
        Complex zetaBetaValue = this.compute(ONE.subtract(x));
        return twoPowX.multiply(piPowX).multiply(sine).multiply(gammaValue).multiply(zetaBetaValue);
    }
}