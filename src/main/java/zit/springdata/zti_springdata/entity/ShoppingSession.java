package zit.springdata.zti_springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Shopping_Session")
public class ShoppingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "card_ID", nullable = false)
    @JsonBackReference
    private KauflandCard card;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "scanner_ID", nullable = false)
    @JsonBackReference
    private Scanner scanner;

    @Column(name = "shopping_start", nullable = false)
    private Instant shoppingStart;

    @Column(name = "shopping_end")
    private Instant shoppingEnd;

    @OneToMany(mappedBy = "shoppingSession")
    @JsonBackReference
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KauflandCard getCard() {
        return card;
    }

    public void setCard(KauflandCard card) {
        this.card = card;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Instant getShoppingStart() {
        return shoppingStart;
    }

    public void setShoppingStart(Instant shoppingStart) {
        this.shoppingStart = shoppingStart;
    }

    public Instant getShoppingEnd() {
        return shoppingEnd;
    }

    public void setShoppingEnd(Instant shoppingEnd) {
        this.shoppingEnd = shoppingEnd;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

}