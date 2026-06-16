package accenture.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//Uno a molti
@Entity
@Table(name = "esami")
public class Esame {
    
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate data;
    private int voto;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    

   

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Esame(LocalDate data, int voto, String nome) {
        this.data = data;
        this.voto = voto;
        this.nome = nome;
    }

    public Esame(){

    }

    @Override
    public String toString() {
        return "Esame [id=" + id + ", data=" + data + ", voto=" + voto + ", nome=" + nome + "Studente: " + studente +"]";
    }

    public Integer getId() {
        return id;
    }

    


    
    




}
