package models;

    public class Current extends Account{

    public Current() {
        super();
        super.minimumBalance = 1000.0f;
    }

    @Override
    public
    void display() {
        System.out.println("This is Current account");
        
    }
    
}
