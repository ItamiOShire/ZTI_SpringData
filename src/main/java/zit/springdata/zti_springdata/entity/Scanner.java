package zit.springdata.zti_springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Scanner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "serial_number", nullable = false, length = 10)
    private String serialNumber;

    @OneToMany(mappedBy = "scanner")
    @JsonManagedReference
    private Set<ShoppingSession> shoppingSessions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Set<ShoppingSession> getShoppingSessions() {
        return shoppingSessions;
    }

    public void setShoppingSessions(Set<ShoppingSession> shoppingSessions) {
        this.shoppingSessions = shoppingSessions;
    }

}