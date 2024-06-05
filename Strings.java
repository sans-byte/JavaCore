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


        // TO use mutable strings we use something known as 
        // String buffer or String Builder

        //String Buffer

        StringBuffer s = new StringBuffer("Sanskar");
        System.out.println(s.length()); //7
        System.out.println(s.capacity()); //23

        s.append(" Jain");
        System.out.println(s);
        // String str = s.toString(); //convert stringbuffer to string
        // s.delete(2, 4);
        // System.out.println(s); //Sakar Jain

        // s.deleteCharAt(3);
        // System.out.println(s); // Sankar Jain

        //s.insert(8, "Hello world ");

        //System.out.println(s); // Sanskar Hello world Jain

        //String buffer and String builder has  only one difference that
        // String buffer is threas safe and string builder is not
    }

}
