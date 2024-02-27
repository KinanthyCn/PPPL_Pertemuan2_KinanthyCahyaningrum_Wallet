import java.util.ArrayList;
import java.util.List;

public class Wallet {

    String owner;
    List<Card> cards = new ArrayList<>();
    private Double cash;

    public Wallet() {

    }

    public Wallet(String owner, List<Card> cards, Double cash) {
        this.owner = owner;
        this.cards = cards;
        this.cash = cash;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double withdraw(Double amount) {
        if (this.cash < amount){
            System.out.println("uang urang");
        return 0.0;
    }
        else {
            this.cash -= amount;
            return amount;
        }

    }

    public Double deposit(Double amount){
        this.cash+=amount;
        return this.cash;
    }

    public void addCards(String bank, String accountNumber){
        Card card= new Card(this.owner, String.valueOf(accountNumber), bank);
        this.cards.add(card);
    }

    public void removeCard(int accountNumber){
        this.cards.forEach(card -> {
            if (card.getNoRek().equals(String.valueOf(
                    accountNumber
            )))
                this.cards.remove(card);
        });

    }

    private Integer usia;

}

