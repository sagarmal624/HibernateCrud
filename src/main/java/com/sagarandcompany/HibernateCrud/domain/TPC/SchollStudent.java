package com.sagarandcompany.HibernateCrud.domain.TPC;

import javax.persistence.*;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "name", column = @Column(name = "name"))
})
public class SchollStudent extends Student {
    private String std;

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

}
