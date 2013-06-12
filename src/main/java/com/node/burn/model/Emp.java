package com.node.burn.model;

import com.node.burn.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="emp",catalog="eduoa")
@Indexed
@XmlRootElement
public class Emp extends BaseObject implements Serializable {
    private Long eid;
    private Long eage;
    private String ename;
    private Long estate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getEid() {
        return this.eid;
    }
    
    public void setEid(Long eid) {
        this.eid = eid;
    }
    
    @Column(name="eage")
    @Field
    public Long getEage() {
        return this.eage;
    }
    
    public void setEage(Long eage) {
        this.eage = eage;
    }
    
    @Column(name="ename", length=50)
    @Field
    public String getEname() {
        return this.ename;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }
    
    @Column(name="estate")
    @Field
    public Long getEstate() {
        return this.estate;
    }
    
    public void setEstate(Long estate) {
        this.estate = estate;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp pojo = (Emp) o;

        if (eage != null ? !eage.equals(pojo.eage) : pojo.eage != null) return false;
        if (ename != null ? !ename.equals(pojo.ename) : pojo.ename != null) return false;
        if (estate != null ? !estate.equals(pojo.estate) : pojo.estate != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (eage != null ? eage.hashCode() : 0);
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (estate != null ? estate.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("eid").append("='").append(getEid()).append("', ");
        sb.append("eage").append("='").append(getEage()).append("', ");
        sb.append("ename").append("='").append(getEname()).append("', ");
        sb.append("estate").append("='").append(getEstate()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
