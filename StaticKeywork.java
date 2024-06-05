// Static variable are shared variables that are common between all the object of a perticular class
// This makes static variables  property of class not of its objects

class Mobile {
    String company;
    String price;
    static String osType;

    public void printMobile(){
        System.out.println(company + " " + price + " " + osType);
    }
}
public class StaticKeywork {

    
    public static void main(String[] args) {

        Mobile.osType = "Android"; //We can also access it with the object name like s23.osType 
        //but that will also change the name for every object so it is preffered to acccess
        // static keyword with the name of the class as they are the class property

        Mobile s23 = new  Mobile();
        s23.company = "Samsung";
        s23.price = "2000$";

        Mobile G62 = new  Mobile();
        G62.company = "Moto";
        G62.price = "200$";

        s23.printMobile();

        G62.printMobile();
        
    }
}
