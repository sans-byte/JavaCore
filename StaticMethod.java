class Book{

    String author;
    int price;

    public static void printBook(){
        System.out.println("this is a static function");
    }

    // public static void prin(){
    //     System.out.println(author + " " + price); //we cannot use non static variables here
    // }

    //but we can use them by giving the object refrence
    public static void print(Book obj){
        System.out.println(obj.author + " " + obj.price);
    }
}

public class StaticMethod {
    public static void main(String[] args) {
        Book.printBook(); // we can access static method like this

        Book b1 = new Book();
        b1.author = "Ana";
        b1.price = 100;

        Book b2 = new Book();
        b2.author = "David";
        b2.price = 200;

        Book.print(b1); // we can provide the object refrence that we wanna use
    }
}
