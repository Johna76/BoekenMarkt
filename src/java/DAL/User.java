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
@Table(name = "tbl_users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByNaam", query = "SELECT u FROM User u WHERE u.naam = :naam")
    , @NamedQuery(name = "User.findByVoornaam", query = "SELECT u FROM User u WHERE u.voornaam = :voornaam")
    , @NamedQuery(name = "User.findByStudentennummer", query = "SELECT u FROM User u WHERE u.studentennummer = :studentennummer")
    , @NamedQuery(name = "User.findByEmailAdres", query = "SELECT u FROM User u WHERE u.emailAdres = :emailAdres")
    , @NamedQuery(name = "User.findByWachtwoord", query = "SELECT u FROM User u WHERE u.wachtwoord = :wachtwoord")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "voornaam")
    private String voornaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "studentennummer")
    private String studentennummer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String emailAdres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<AangebodenBoek> aangebodenBoekList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String naam, String voornaam, String studentennummer, String emailAdres, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.voornaam = voornaam;
        this.studentennummer = studentennummer;
        this.emailAdres = emailAdres;
        this.wachtwoord = wachtwoord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStudentennummer() {
        return studentennummer;
    }

    public void setStudentennummer(String studentennummer) {
        this.studentennummer = studentennummer;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.User[ id=" + id + " ]";
    }
    
}
