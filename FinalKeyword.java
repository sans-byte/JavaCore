//Final ->  variable | Class | Method 

// When we make a variable final that means it's value can't be changed once assigned
// When we make a Class final that means it cannot be inherited it cannot have any children
// When we Make a Method Final it means this method can't be overridden

final class Robot{
    public void  whoMadeThisRobot(){
        System.out.println("Sanskar Jain");
    }
}

// class MyRobot extends Robot{
  // This cannot be done coz the Robot class is final
// }

class AdvRobot{
    final public void  whoMadeThisRobot(){
        System.out.println("Sanskar Jain");
    }
}

class MyAdvRobot extends AdvRobot 
{
    // public void whoMadeThisRobot(){     // This cannot be done here and give error saying 
    //     System.out.println("John doe"); //cannot override final method
    // }
}


public class FinalKeyword {

    public static void main(String[] args) {
        final int x = 10;
        //x = 20; //This will give error or wont work coz x is a constant now
        final int y;
        y = 20;
        //y = 100; // Y is final and already have been assigned a value
    }
    
}
