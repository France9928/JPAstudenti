package accenture.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//relazione uno a uno   

@Entity
@Table(name = "carta_identita")
public class CartaIdentita {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate dataRilascio;

    private String comune;

    private LocalDate dataScadenza;

    //inserisco un riferimento all'entità studente
    @OneToOne
    @JoinColumn(name = "studente_id") //nome che nella tabella carta di identità farà da foreign key    //lato proprietatario
    private Studente studente;

    public CartaIdentita(String comune, LocalDate dataRilascio, LocalDate dataScadenza){
        this.comune = comune;
        this.dataRilascio = dataRilascio;
        this.dataScadenza = dataScadenza;

    }

    public CartaIdentita(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(LocalDate dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    @Override
    public String toString() {
        return "CartaIdentita [id=" + id + ", dataRilascio=" + dataRilascio + ", comune=" + comune + ", dataScadenza="
                + dataScadenza + "]";
    }

    

    
}
