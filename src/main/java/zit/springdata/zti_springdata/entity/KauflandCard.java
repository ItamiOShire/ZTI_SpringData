package zit.springdata.zti_springdata.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Kaufland_Card")
public class KauflandCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "code", nullable = false, length = 200)
    private String code;

    @OneToOne(mappedBy = "card")
    private Client client;

    @OneToMany(mappedBy = "card")
    private Set<ShoppingSession> shoppingSessions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ShoppingSession> getShoppingSessions() {
        return shoppingSessions;
    }

    public void setShoppingSessions(Set<ShoppingSession> shoppingSessions) {
        this.shoppingSessions = shoppingSessions;
    }

}