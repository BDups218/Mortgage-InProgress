import java.text.NumberFormat;

public class Mortgage {
    private int principal;
    private float interestRate;
    private int numberOfYears;
    public final static int yearMonths = 12;
    public final static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public Mortgage(int principal, float interestRate, int numberOfYears) {
        setPrincipal(principal);
        setInterestRate(interestRate);
        setNumberOfYears(numberOfYears);
    }
    private float calculateMortgage() {
        int months = numberOfYears * yearMonths;
        float interest = interestRate/100;
        float monthlyInterestRate = interest / yearMonths;

        return (principal*(monthlyInterestRate*(float)Math.pow((1+monthlyInterestRate), months))/(((float)Math.pow((1+monthlyInterestRate), months))-1));
    }
    private int calculateNumberOfPayments(){
        return yearMonths * numberOfYears;
    }
    private void setPrincipal(int principal) {
        if(principal < 1000 || principal > 1000000) {
            throw new IllegalArgumentException("Principal must be between 1000 and 1000000");
        } else {
            this.principal = principal;
        }
    }
    private void setInterestRate(float interestRate) {
        if(interestRate < 1 || interestRate > 30) {
            throw new IllegalArgumentException("Interest rate must be between 1 and 30");
        } else {
            this.interestRate = interestRate;
        }
    }
    private void setNumberOfYears(int numberOfYears) {
        if(numberOfYears < 1 || numberOfYears > 30) {
            throw new IllegalArgumentException("Number of years must be between 1 and 30");
        } else {
            this.numberOfYears = numberOfYears;
        }
    }
    public int getPrincipal() {
        return principal;
    }
    public float getInterestRate() {
        return interestRate;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    public int getNumberOfPayments() {
        return calculateNumberOfPayments();
    }
    public void printMortgage(){
        System.out.println("Mortgage: " + currencyFormat.format(calculateMortgage()));
    }
}
