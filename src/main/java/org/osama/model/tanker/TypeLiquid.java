package org.osama.model.tanker;

import javax.persistence.*;

@Entity
@Table(name = "type_liquid_table")
public class TypeLiquid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIQUID_TANKER")
    Integer id;
    @Column(name = "TYPE_LIQUID")
    String typeLiquid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeLiquid() {
        return typeLiquid;
    }

    public void setTypeLiquid(String typeLiquid) {
        this.typeLiquid = typeLiquid;
    }
}
