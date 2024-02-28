

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    List<Card> empty = new ArrayList<Card>();
    Wallet wallet1 = new Wallet("Android", empty, 0.0);
    Wallet wallet2 = new Wallet("DragonBall", empty, 0.0);

    @Test
    void getOwner() {
        Assertions.assertEquals("Android", wallet1.getOwner());
    }

    @Test
    void setOwner() {
        wallet2.setOwner("Naruto");
        Assertions.assertEquals("Naruto", wallet2.getOwner());
    }

    @Test
    void withdraw() {
        wallet1.deposit(10000.0);
        wallet1.withdraw(5000.0);
        Assertions.assertEquals(5000.0, wallet1.getCash());
    }

    @Test
    void deposit() {
        wallet1.deposit(5000.0);
        Assertions.assertEquals(5000.0, wallet1.getCash());
    }

    @Test
    void addCards() {
        wallet1.addCards("BRI", 101);
        wallet1.addCards("BNI", 202);
        List<Card> cards = new ArrayList<>();
        Card BRI = new Card(wallet1.getOwner(), "101", "BRI");
        cards.add(BRI);
        Card BNI = new Card(wallet1.getOwner(), "202", "BNI");
        cards.add(BNI);
        Assertions.assertEquals(cards, wallet1.getCards());
    }

    @Test
    void removeCard() {
        wallet1.addCards("BRI", 101);
        wallet1.addCards("BNI", 202);
        wallet1.removeCard(202);
        List<Card> cards = new ArrayList<>();
        Card BRI = new Card(wallet1.getOwner(), "101", "BRI");
        cards.add(BRI);
        Assertions.assertEquals(cards, wallet1.getCards());
    }
}