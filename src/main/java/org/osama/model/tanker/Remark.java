package org.osama.model.tanker;

import javax.persistence.*;

@Entity
@Table(name = "remark_table_tanker")
public class Remark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REMARK_TANKER")
    Integer id;
    @Column(name = "REMARK_TANKER")
    String remark;

    public Remark() {
    }

    public Remark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
