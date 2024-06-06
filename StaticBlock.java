
class Animal {
    String name;
    String type;
    static int legs;

    static { // in static block we can assign values to static variables.
        legs = 4; // this block will be called only once irrespective of the number of objects
                  // created
        System.out.println("Static method is called");
    } // this block gets called when the class loader is called in memory
      // so this block will always be called before the constructors

    public Animal() {
        name = "Coco";
        type = "Dog";
        System.out.println("Constructor is called");
    }
}

public class StaticBlock {
    public static void main(String[] args) throws ClassNotFoundException {
        // Animal a1 = new Animal();
        // Animal a2 = new Animal();

        //static method is called
        // Constructor is called
        // Constructor is called

        //Now if we no not make object the static block will not be exicuted 
        //coz class won't get loaded into class loader
        //but if  we explicitly wants to call the static block

        Class.forName("Animal"); //Static method is called
    }
}
