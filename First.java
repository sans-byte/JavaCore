//Method Overloading 
    // Two methods have same name inside a class so the constructor will
    // Identify the method with the help of parameter those are expected by the method
    // Return type wont make a difference

class Insects {

    public void Insect (int legs, int eyes ){
        System.out.println("Has " + legs  + " Legs and" + eyes  +" eyes");
    }

    // public double Insect (int legs, int eyes ){
    //     System.out.println("Has " + legs  + "Legs and" + eyes  +"eyes");
    // } will give error

    public void Insect (int legs, int eyes, int nose ){
        System.out.println("Has " + legs  + " Legs and" + eyes  +" eyes and " + nose + " nose");
    }    
}
public class First {

    public static void main(String[] args) {
       Insects spider = new Insects();
       spider.Insect(8, 4);
       spider.Insect(8, 4,1);
    }
}