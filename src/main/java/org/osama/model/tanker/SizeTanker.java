package org.osama.model.tanker;

import javax.persistence.*;

@Entity
@Table(name = "size_table_tanker")
public class SizeTanker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SIZE_TANKER")
    Integer id;
    @Column(name = "SIZE_TANKER")
    String sizeTanker;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSizeTanker() {
        return sizeTanker;
    }

    public void setSizeTanker(String sizeTanker) {
        this.sizeTanker = sizeTanker;
    }
}
