package accenture.com.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
@Table(name= "studenti")
public class Studente { 
    
    @Id //indica che questo campo è la chiave primaria
    @GeneratedValue //indica che la matricola verrà autogenerata (il jpa genererà la chiave primaria)
    private Integer matricola;
    @Column(length = 20)
    private String nome;
    @Column(length = 30)
    private String cognome;
    @Column(length = 30)
    private String indirizzo;
    
    //lato inverso non proprietario
    @OneToOne(mappedBy = "studente") //dobbiamo scrivere il nome del campo. la relazione è gestita dal campo studente
    private CartaIdentita cartaIdentita;

    @OneToMany(mappedBy = "studente")
    private List<Esame> esami;




    public Studente(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }

    public Studente(){
        
    }

    


    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getCognome() {
        return cognome;
    }



    public void setCognome(String cognome) {
        this.cognome = cognome;
    }



    public String getIndirizzo() {
        return indirizzo;
    }



    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    public Integer getMatricola() {
        return matricola;
    }



    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public CartaIdentita getCartaIdentita() {
        return cartaIdentita;
    }

    public void setCartaIdentita(CartaIdentita cartaIdentita) {
        this.cartaIdentita = cartaIdentita;
    }

    @Override
    public String toString() {
        return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo="
                + indirizzo + ", cartaIdentita=" + cartaIdentita + "]";
    }

    public List<Esame> getEsami() {
        return esami;
    }

    public void setEsami(List<Esame> esami) {
        this.esami = esami;
    }
    

   
    

    
    


    
}