package zit.springdata.zti_springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_ID")
    @JsonManagedReference
    private KauflandCard card;

    @Nationalized
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Nationalized
    @Column(name = "last_name", nullable = false, length = 120)
    private String lastName;

    @Nationalized
    @Column(name = "email", nullable = false, length = 200)
    private String email;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}