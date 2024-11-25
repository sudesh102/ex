import java.util.*;

class SavingAccount {

    private float savingBalance;
    private static float annualIntrestRate;

    SavingAccount() {
        savingBalance = 0.0f;
        annualIntrestRate = 0.0f;
    }

    SavingAccount(float savingBalance, float annualIntrestRate) {
        this.savingBalance = savingBalance;
        this.annualIntrestRate = annualIntrestRate;
    }

    public float calMonthIntreat() {
        float monthlyIntrest = (savingBalance * (annualIntrestRate) / 100) / 12;
        savingBalance += monthlyIntrest;
        return savingBalance;
    }

    public static void modifyIntrestRate(float newRate) {
        annualIntrestRate = newRate;
    }

    public void display() {
        System.out.println("Saving Balance: " + savingBalance);
        System.out.println("Annual Interest Rate: " + annualIntrestRate + "%");
        System.out.println("Amount After Month: " + calMonthIntreat());
    }

    public float getSavingBalance() {
        return savingBalance;
    }
}

public class Expt4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount saver1 = new SavingAccount(2000, 4);

        saver1.display();

        System.out.print("Enter the new intrest rate:");
        float rate1 = sc.nextFloat();
        System.out.println("After adding new Intrest Rate");

        SavingAccount.modifyIntrestRate(rate1);
        saver1.display();

        SavingAccount saver2 = new SavingAccount(3000, 4);

        saver2.display();

        System.out.print("Enter the new intrest rate:");
        float rate2 = sc.nextFloat();
        System.out.println("After adding new Intrest Rate");

        SavingAccount.modifyIntrestRate(rate2);
        saver2.display();

    }
}
