package models;

public class Savings extends Account{
    public Savings() {
        super();
        this.minimumBalance = 0;
    }

    @Override
    public
    void display() {
        // TODO Auto-generated method stub
        System.out.println("This is savings account");
    }

}

