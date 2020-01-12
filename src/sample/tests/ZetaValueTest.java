package sample.tests;

import org.apache.commons.math3.complex.Complex;
import org.testng.Assert;
import sample.data.ZetaValue;

class ZetaValueTest extends Test {
    final long expectedAbsValue = (long) 0.1618389986932944;

    @org.testng.annotations.Test
    void zValTest(){
        Complex z = new Complex(0.2, 0.2);
        ZetaValue object = new ZetaValue(z);
        long computedAbsValue = (long)object.absoluteValueGetter();
        Assert.assertEquals(computedAbsValue, expectedAbsValue);
    }
}