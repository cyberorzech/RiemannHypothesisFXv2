package sample.tests;

public class Test {
    public static void run(){
        DataGenerationTest firstObject = new DataGenerationTest();
        firstObject.randomReal();
        /*DataToChartTest secondObject = new DataToChartTest();         produces known exception which is not causing problems (duplicate series)
        secondObject.addData();*/
        DataValidationTest thirdObject = new DataValidationTest();
        thirdObject.realPartCheck();
        ZetaValueTest fourthObject = new ZetaValueTest();
        fourthObject.zValTest();
    }
}
