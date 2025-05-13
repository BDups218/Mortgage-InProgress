import java.util.ArrayList;
import java.util.List;

public class Balance {
    private final int principal;
    private final float interestRate;
    private final int numberOfPayments;
    private int numberOfPaymentsMade = 0;
    List<String> listOfPayments = new ArrayList<>();

    public Balance(int principal, float interestRate, int numberOfPayments) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.numberOfPayments = numberOfPayments;
    }
    private void calculateBalance(){
        while (numberOfPaymentsMade < numberOfPayments) {
            double balance;
            float monthlyInterest = getMonthlyInterestRate();
            numberOfPaymentsMade++;

            balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
            listOfPayments.add("\nBalance after "+numberOfPaymentsMade+" months: "+Mortgage.currencyFormat.format(balance));
        }
    }
    private float getMonthlyInterestRate() {
        float interest = interestRate / 100;
        return interest / Mortgage.yearMonths;
    }
    public void printBalance(){
        calculateBalance();
        System.out.println(listOfPayments);
    }
}
