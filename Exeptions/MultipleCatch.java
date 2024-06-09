package Exeptions;

public class MultipleCatch {
    
    public static void main(String[] args) {
        int i =0;
        
        int[] arr = new int[5];
        String str = null;

        //where ever the first exception occurs the execution will jump to the catch block

        try{
            int j = 10/i; //This will throw an /zero error
            int x = arr[6];     // Will give array out of bound
            int len = str.length(); //will give null pointer
        }catch (ArithmeticException e){
            System.out.println("Cannot devide by zero" + e);
        }catch(ArrayIndexOutOfBoundsException e){ 
            System.out.println("Array out of bound" + e);
        }catch(Exception e){                    //Exception is the parent class of all exception
                                            //classes so should be called at the bottom
            System.out.println("Something went wrong" + e);         
        }
    }
}
