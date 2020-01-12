package sample.tests;

import org.junit.Assert;
import sample.data.DataGeneration;
import sample.data.DataValidation;


class DataGenerationTest extends Test {

    @org.testng.annotations.Test
    void randomReal() {
        Assert.assertTrue(DataValidation.realPartCheck(DataGeneration.getterReal()));
    }

}