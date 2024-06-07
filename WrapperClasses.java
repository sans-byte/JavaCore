// Wrapper classes in java are like Object Implementations of premitive datatypes
//int -> Integer
//double -> Double
// char -> Character
// String

public class WrapperClasses {

    public static void main(String[] args) {
        int num = 10;
        Integer n = new Integer(num);   //This is called boxing //This is depricated
        Integer n1 = num;  //autoboxing // This is basically converting primitive int to object Integer
        
        String str =  "12";
        Integer strInt = Integer.parseInt(str);    //Convert string in int  
        System.out.println(strInt + 10); 
    }
}
