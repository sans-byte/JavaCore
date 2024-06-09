
//Lambda expression only works with functional interfaces

interface SomeInterface {
    void show();
}

interface SomeInterfaceWithReturn{
    int getSum(int i,int j);
}

public class LambdaExpression {
    
    public static void main(String[] args){
        // SomeInterface s = new SomeInterface() {
        //     public void show(){
        //         System.out.println("Show");
        //     }
        // };

        SomeInterface s = ( ) -> {
            System.out.println("Show");
        };

        s.show();

        SomeInterfaceWithReturn s1 = (i,j) -> i + j;

        System.out.println(s1.getSum(10, 20));
    }
}
