package models;
import java.util.*;
public abstract class Account {
    private static int accId;
    protected static Date accountCreated;
    private static int countAccounts = 0;
    public static float minimumBalance=0.0f;
    public Account()
    {
        countAccounts+=1;
        this.accId=countAccounts;
        this.accountCreated = new Date();
    }
    public abstract void display();
}
