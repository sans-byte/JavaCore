
class Company{
    private String name;
    private int noOfEmployee;

    Company(){
        System.out.println("This is the default constructor");
    }

    Company( String name, int noOfEmployee ){
        this.name = name;                       //this keyword points to the current object
        this.noOfEmployee = noOfEmployee;
        System.out.println("This is parameterized constructor");
    }
}


public class ThisAndConstuctors {
    public static void main(String[] args) {
        Company c = new Company(); //This is default constructor 

        Company c1 = new Company("Adani",2000); //This will call parametrized constructor
    }
    
}
