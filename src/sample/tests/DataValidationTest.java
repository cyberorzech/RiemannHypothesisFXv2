package sample.tests;

import org.testng.Assert;
import sample.data.DataValidation;

class DataValidationTest {

    @org.testng.annotations.Test
    void realPartCheck() {
        double x = 0.5;
        double y = 0.0;
        double z = 1.0;
        double a = 0.123456789;
        Assert.assertFalse(DataValidation.realPartCheck(x));
        Assert.assertTrue(DataValidation.realPartCheck(y));
        Assert.assertFalse(DataValidation.realPartCheck(z));
        Assert.assertTrue(DataValidation.realPartCheck(a));
    }
}