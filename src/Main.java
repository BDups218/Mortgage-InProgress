public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Enter a number for principal between 1000 and 1000000: ",1000,1000000);
        float interestRate = (float) Console.readNumber("Enter a number for annual interest rate between 1 and 30: ",1,30);
        int numberOfYears = (int) Console.readNumber("Enter a number of years between 1 and 30: ",1,30);
        int numberOfPayments = numberOfYears * Mortgage.yearMonths;
        var mortgage = new Mortgage(principal, interestRate, numberOfYears);
        var balance = new Balance(principal, interestRate, numberOfPayments);
        mortgage.printMortgage();
        balance.printBalance();
    }
}