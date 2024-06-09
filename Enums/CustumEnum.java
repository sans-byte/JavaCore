package Enums;

//enum always extends Enum class from java

enum Laptop{
    MackBook(200), Dell(100), HP, Lenove(180);
   
    int price;

    private Laptop(int price) {
        this.price = price;
    }

    private Laptop() {
        price = 150;
    }   
    
}

public class CustumEnum {
    public static void main(String[] args) {
        Laptop lap = Laptop.MackBook;

        for(Laptop l : Laptop.values()){
            System.out.println(l + " : " + l.price );
        }
    }
}
