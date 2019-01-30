package org.osama.model.tanker;

import javax.persistence.*;


@Entity
@Table(name = "number_table_tanker")
public class NumberTanker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NUMBER_TANKER")
    Integer id;
    @Column(name = "NUMBER_TANKER")
    String numberTanker;

    public NumberTanker() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberTanker() {
        return numberTanker;
    }

    public void setNumberTanker(String numberTanker) {
        this.numberTanker = numberTanker;
    }
}
