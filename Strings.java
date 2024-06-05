public class Strings {
    public static void main(String[] args) {
        String n = "sanskar";
        System.out.println(n);

        String name = new String("Jain");

        System.out.println(name);

        System.out.println(n.charAt(2)); //access the characters
        System.out.println(name.concat("Hello"));


        // types of string
        // Mutable strings and Immuatable strings

        // Strings are Immutable by default
        // And There cannot  be two string of the same name in string pool which is in heap memory
        // ex String name  = "Sanskar"
        //    String newName = "Sanskar"
        //    Sout(name == newName) //true //coz they are pointing to the same address
        //    if we do name = name + "Jain" // a new object will be created and name will be
        //    assigned to that address and the Previous "Sanskar" will be eligible for garbage
        //    collection


        String s1 = "sanskar";
        String s2 = "sanskar";

        System.out.println(s1 == s2);
        System.out.println(s1.hashCode()); // prints address
        System.out.println(s2.hashCode()); // prints address

        s1 = s1 + "Jain";
        System.out.println(s1);
        System.out.println(s1.hashCode()); // prints address
    }

}
