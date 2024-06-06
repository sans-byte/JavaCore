
class Person {
    private String name;
    private int age;
    
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
}

public class Encapsulation {
    
    public static void main(String[] args) {
        Person p = new Person("SANSKAR", 23);
        // Name and age are not accessable outsite the class you cannot directly assign value to 
        // them here
        System.out.println(p.getName());
    }
    
}
