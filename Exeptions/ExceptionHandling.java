package Exeptions;

public class ExceptionHandling {
    public static void main(String[] args) {
        int i = 0;
        try {
            int j = 18 / i; // Now here we can get runtime error
            System.out.println(j);
        } catch (Exception e) {
            System.out.println("Something went wrong...");
            System.out.println(e);
        }

        System.out.println("It does not stop the execution");
    }

}
