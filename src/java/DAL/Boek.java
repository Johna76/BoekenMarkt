/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Johna
 */
@Entity
@Table(name = "tbl_boeken")
@NamedQueries({
    @NamedQuery(name = "Boek.findAll", query = "SELECT b FROM Boek b")
    , @NamedQuery(name = "Boek.findById", query = "SELECT b FROM Boek b WHERE b.id = :id")
    , @NamedQuery(name = "Boek.findByTitel", query = "SELECT b FROM Boek b WHERE b.titel = :titel")
    , @NamedQuery(name = "Boek.findByAuteur", query = "SELECT b FROM Boek b WHERE b.auteur = :auteur")
    , @NamedQuery(name = "Boek.findByIsbn", query = "SELECT b FROM Boek b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "Boek.findByRichting", query = "SELECT b FROM Boek b WHERE b.richting = :richting")})

public class Boek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titel")
    private String titel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "auteur")
    private String auteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "richting")
    private String richting;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "afbeelding")
    private String afbeelding;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boekID")
    private List<AangebodenBoek> aangebodenBoekList;

    public Boek() {
    }

    public Boek(Integer id) {
        this.id = id;
    }

    public Boek(Integer id, String titel, String auteur, String isbn, String richting) {
        this.id = id;
        this.titel = titel;
        this.auteur = auteur;
        this.isbn = isbn;
        this.richting = richting;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRichting() {
        return richting;
    }

    public void setRichting(String richting) {
        this.richting = richting;
    }

    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public List<AangebodenBoek> getAangebodenBoekList() {
        return aangebodenBoekList;
    }

    public void setAangebodenBoekList(List<AangebodenBoek> aangebodenBoekList) {
        this.aangebodenBoekList = aangebodenBoekList;
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
        if (!(object instanceof Boek)) {
            return false;
        }
        Boek other = (Boek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Boek[ id=" + id + " ]";
    }
    
}
