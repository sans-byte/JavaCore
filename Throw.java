
class MyException extends Exception {
    public MyException(String str){
        super(str);
    }
}

public class Throw {
    public static void main(String[] args) {
        int i = 10;

        try {
            int j = 10/i;
            if(j == 0){
                throw new ArithmeticException("J cannot be 0");
            }
            j = 1;
            if(j == 1){
                throw new MyException("J cannot be 1 from custom exception");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
