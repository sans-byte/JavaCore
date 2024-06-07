package AccessModifiers;

public class A {
    protected int protectedVariable;
    private int privateVariable;

    public void changePrivateVariable(int a){
        privateVariable = a;
        System.out.println(privateVariable);
    }
}
