/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Johna
 */
@Entity
@Table(name = "tbl_aangebodenboeken")
@NamedQueries({
    @NamedQuery(name = "AangebodenBoek.findAll", query = "SELECT a FROM AangebodenBoek a")
    , @NamedQuery(name = "AangebodenBoek.findById", query = "SELECT a FROM AangebodenBoek a WHERE a.id = :id")
    , @NamedQuery(name = "AangebodenBoek.findByPrijs", query = "SELECT a FROM AangebodenBoek a WHERE a.prijs = :prijs")
    , @NamedQuery(name = "AangebodenBoek.findByDatum", query = "SELECT a FROM AangebodenBoek a WHERE a.datum = :datum")
    , @NamedQuery(name = "AangebodenBoek.findByConditie", query = "SELECT a FROM AangebodenBoek a WHERE a.conditie = :conditie")})
public class AangebodenBoek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prijs")
    private double prijs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "conditie")
    private String conditie;
    @JoinColumn(name = "boek_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Boek boekID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userID;

    public AangebodenBoek() {
    }

    public AangebodenBoek(Integer id) {
        this.id = id;
    }

    public AangebodenBoek(Integer id, double prijs, Date datum, String conditie) {
        this.id = id;
        this.prijs = prijs;
        this.datum = datum;
        this.conditie = conditie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getConditie() {
        return conditie;
    }

    public void setConditie(String conditie) {
        this.conditie = conditie;
    }

    public Boek getBoekID() {
        return boekID;
    }

    public void setBoekID(Boek boekID) {
        this.boekID = boekID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AangebodenBoek)) {
            return false;
        }
        AangebodenBoek other = (AangebodenBoek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.AangebodenBoek[ id=" + id + " ]";
    }
    
}
