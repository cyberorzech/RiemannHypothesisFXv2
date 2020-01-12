package sample.data;

public class DataValidation {
    /**
     * Methods for data validation. More about the correct input parameters -> readme file
     */
    public static boolean realPartCheck(double x) {
        if (x >= 0.0 && x < 1 && x != 0.5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean imgStepCheck(double x) {
        if (x > 0)
            return true;
        else
            return false;
    }

    public static boolean iterNoCheck(double x) {
        if (x > 1)
            return true;
        else
            return false;
    }
}
