package customer;

public class CostumerImpl implements Costumer{
    private String name;
    private double balance;

    public CostumerImpl(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public void deductBalance(double amount) {
        balance -= amount;
    }
}
