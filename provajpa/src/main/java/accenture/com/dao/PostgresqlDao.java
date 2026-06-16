package accenture.com.dao;

import java.util.List;

import org.hibernate.annotations.NotFound;

import accenture.com.entity.CartaIdentita;
import accenture.com.entity.Corso;
import accenture.com.entity.Esame;
import accenture.com.entity.Studente;
import accenture.com.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PostgresqlDao {

    private EntityManager em;

    public PostgresqlDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");
        em = emf.createEntityManager();
    }

    //inserisce un nuovo studente nel db
    public void saveStudente(Studente studente){
        em.getTransaction().begin();
        em.persist(studente);
        em.getTransaction().commit();
    }

    //aggiorna uno studente sul db
    public Studente updateStudente(Studente studente) throws NotFoundException{
        em.getTransaction().begin();
        Studente studenteDaAggiornare = em.find(Studente.class, studente.getMatricola());

        if(studenteDaAggiornare!=null){
            studenteDaAggiornare.setNome(studente.getNome());
            studenteDaAggiornare.setCognome(studente.getCognome());
            studenteDaAggiornare.setIndirizzo(studente.getIndirizzo());

            em.persist(studenteDaAggiornare);
            em.getTransaction().commit();

            return studenteDaAggiornare;
        }
        else{
            throw new NotFoundException("Studente con matricola " + studente.getMatricola() + " non trovato");
        }
        
    }

    //rimuove uno studente dal db
    public void removeStudente(Integer matricola){
        em.getTransaction().begin();
        Studente studenteDaRimuovere = em.find(Studente.class, matricola);

        em.remove(studenteDaRimuovere);
        
        em.getTransaction().commit();
    }


    public Studente getStudenteById(Integer matricola){
        return em.find(Studente.class, matricola);
    }

    public List<Studente> getAllStudenti(){
        Query query = em.createQuery("select s from Studente s", Studente.class);

        return query.getResultList();
    }


    public List<Studente> getStudenteByName(String nome){
        Query query = em.createQuery("select s from Studente s where s.nome= :nome" , Studente.class); //: significa parametro
        
        query.setParameter("nome", nome); //il primo è il nome del parametro nella stringa, il secondo è il valore
        
        return query.getResultList();
    }

    //METODI CARTA IDENTITA

    public void saveCartaIdentita(CartaIdentita cartaIdentita){
        em.getTransaction().begin();
        em.persist(cartaIdentita);
        em.getTransaction().commit();

    }

    public CartaIdentita updateCartaIdentita(CartaIdentita cartaIdentita) throws NotFoundException{
        em.getTransaction().begin();
        CartaIdentita cartaIdentitaDaAggiornare = em.find(CartaIdentita.class, cartaIdentita.getId());

        if(cartaIdentitaDaAggiornare != null){
            cartaIdentitaDaAggiornare.setComune(cartaIdentita.getComune());
            cartaIdentitaDaAggiornare.setDataRilascio(cartaIdentita.getDataRilascio());
            cartaIdentitaDaAggiornare.setDataScadenza(cartaIdentita.getDataScadenza());
            cartaIdentitaDaAggiornare.setStudente(cartaIdentita.getStudente());

            em.persist(cartaIdentitaDaAggiornare);
            em.getTransaction().commit();


        }
        else{
            throw new NotFoundException("carta di identita con id " + cartaIdentita.getId() + "non trovata");
        }
        return cartaIdentitaDaAggiornare;
    }

    public void removeCartaIdentita(Integer id){
        em.getTransaction().begin();

        CartaIdentita cartaIdentitaDaRimuovere = em.find(CartaIdentita.class,id);
        
        em.remove(cartaIdentitaDaRimuovere);
        
        em.getTransaction().commit();
    }


    public CartaIdentita getCartaIdentitaById(Integer id){
        return em.find(CartaIdentita.class, id);
    }

    public List<CartaIdentita> getAllCartaIdentita(){
        Query query = em.createQuery("select c from CartaIdentita c", CartaIdentita.class);
        return query.getResultList();
    }


    //METODI ESAMI

    public void saveEsame(Esame esame){
        em.getTransaction().begin();
        em.persist(esame);
        em.getTransaction().commit();
    }


    public Esame updateEsame(Esame esame) throws NotFoundException{
        em.getTransaction().begin();
        Esame esameDaAggiornare = em.find(Esame.class, esame.getId());

        if(esameDaAggiornare!=null){
            esameDaAggiornare.setData(esame.getData());
            esameDaAggiornare.setVoto(esame.getVoto());
            esameDaAggiornare.setNome(esame.getNome());

            em.persist(esameDaAggiornare);
            em.getTransaction().commit();

            return esameDaAggiornare;
        }
        else{
            throw new NotFoundException("esame con id " + esame.getId() + " non trovato");
        }
        
    }

     public void removeEsame(Integer id){
        em.getTransaction().begin();
        Esame esameDaRimuovere = em.find(Esame.class, id);

        em.remove(esameDaRimuovere);
        
        em.getTransaction().commit();
    }

    public Esame getEsameById(Integer id){
        return em.find(Esame.class, id);
    }

    public List<Esame> getAllEsami(){
        Query query = em.createQuery("select e from Esame e", Esame.class);

        return query.getResultList();
    }


    //metodi corso

    public void saveCorso(Corso corso){
        em.getTransaction().begin();
        em.persist(corso);
        em.getTransaction().commit();
    }

    public void updateCorso(Corso corso) throws NotFoundException{

        em.getTransaction().begin();
        Corso corsoDaAggiornare = em.find(Corso.class, corso.getId());

        if(corsoDaAggiornare!= null ){
            corsoDaAggiornare.setNome(corso.getNome());
            corsoDaAggiornare.setCfu(corso.getCfu());
            corsoDaAggiornare.setDocente(corso.getDocente());

            em.persist(corsoDaAggiornare);
            em.getTransaction().commit();
        }

        else{
            throw new NotFoundException("corso con id" + corso.getId() + "non trovato");
        }
           


    }

    public void removeCorso(Integer id){
        em.getTransaction().begin();
        Corso corsoDaRimuovere = em.find(Corso.class, id);
        em.remove(corsoDaRimuovere);
        em.getTransaction().commit();
    }

    public Corso getCorsoById(Integer id){
        return em.find(Corso.class, id);

    }

    public List<Corso> getAllCorsi(){
        Query query = em.createQuery("select c from Corso c", Corso.class);
        return query.getResultList();
    }






    
}