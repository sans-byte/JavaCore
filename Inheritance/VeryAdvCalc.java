package Inheritance;

public class VeryAdvCalc extends AdvanceCalculator { //here it shows the example of multilevel 
    //inheritance where calc <- advancecalc <- veryadvancecalc 
    public double pow(int i,int j){
        return Math.pow(i, j);
    }
}
