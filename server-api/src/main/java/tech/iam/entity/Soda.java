package tech.iam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "soda", schema = "public", catalog = "postgres")
public class Soda implements Serializable {

    @Id
    @Column(name = "id_soda")
    private Long idSoda;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "price")
    private String price;

    public Soda(Long idSoda, String name, String code, String price) {
        this.idSoda = idSoda;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public Soda() {
    }

    public Long getIdSoda() {
        return idSoda;
    }

    public void setIdSoda(Long idSoda) {
        this.idSoda = idSoda;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
