package accenture.com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="corso")
public class Corso {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    private String docente;
    private int cfu;

    @ManyToMany(mappedBy = "corsi")
    private List<Studente> studenti;

    public Corso(String nome, String docente, int cfu) {
        this.nome = nome;
        this.docente = docente;
        this.cfu = cfu;
    }

    public Corso(){

    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    @Override
    public String toString() {
        return "Corso [id=" + id + ", nome=" + nome + ", docente=" + docente + ", cfu=" + cfu + ", studenti=" + studenti
                + "]";
    }

    

    



    
}
