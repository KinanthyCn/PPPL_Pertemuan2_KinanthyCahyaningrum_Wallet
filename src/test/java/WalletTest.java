
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {
    List<Card> empty = new ArrayList<Card>();
    Wallet wallet1 = new Wallet("Android", empty, 0.0);
    Wallet wallet2 = new Wallet("DragonBall", empty, 0.0);

    @BeforeAll
    void initClass(){
        empty = new ArrayList<Card>();
        wallet1 = new Wallet("Android", empty, 0.0);
        wallet2 = new Wallet("DragonBall", empty, 0.0);
    }

    @BeforeEach
    void initMethod(){
        wallet1.deposit(50000.0);
        wallet2.deposit(100000.0);
        wallet1.addCards("BRI", 101);
        wallet1.addCards("BNI", 202);

    }

    @AfterEach
    void clearMethod(){
        wallet1.setCash(0.0);
        wallet2.setCash(0.0);
        wallet1.getCards().clear();
        wallet2.getCards().clear();
        wallet1.setOwner("Android");
        wallet2.setOwner("DragonBall");
    }

    @AfterAll
    void clearClass(){
        wallet1 = null;
        wallet2 = null;
    }


    @Test
    void testGetOwner() {
        Assertions.assertEquals("Android", wallet1.getOwner());
    }

    @Test
    void testSetOwner() {
        wallet2.setOwner("Naruto");
        Assertions.assertEquals("Naruto", wallet2.getOwner());
    }

    @Test
    void testWithdraw() {
        wallet1.withdraw(10000.0);
        Assertions.assertEquals(40000.0, wallet1.getCash());
    }

    @Test
    void testDeposit() {
        Assertions.assertEquals(50000.0, wallet1.getCash());
    }

    @Test
    void testAddCards() {
        List<Card> cards = new ArrayList<>();
        Card BRI = new Card(wallet1.getOwner(), "101", "BRI");
        cards.add(BRI);
        Card BNI = new Card(wallet1.getOwner(), "202", "BNI");
        cards.add(BNI);
        Assertions.assertEquals(cards, wallet1.getCards());
    }

    @Test
    void testRemoveCard() {
        wallet1.removeCard(202);
        List<Card> cards = new ArrayList<>();
        Card BRI = new Card(wallet1.getOwner(), "101", "BRI");
        cards.add(BRI);
        Assertions.assertEquals(cards, wallet1.getCards());
    }
}