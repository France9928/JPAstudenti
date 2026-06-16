package accenture.com;

import accenture.com.entity.Studente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class testJpa {
    public static void main(String[] args) {
        System.out.println("test jpa");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo"); //carica i dati della connessione in questo oggetto
        EntityManager em = emf.createEntityManager();
        
        Studente s1 = new Studente("Mario", "Rossi", "viaRoma");
        
        //s1.setMatricola(1);

        try{
        em.getTransaction().begin(); //comincio una transazione
        //la transazione è obbligatoria quando facciamo o una insert o un update o una delete

        em.persist(s1); //serve per salvare in maniera permanente lo studente nella tabella
        //Studente s2 = em.find(Studente.class, 52);//indica la classe dell'oggetto da modificare e la chiave primaria
        //find fa una select:dobbiamo fornirfli il nome della classe dell'entità che vogliamo recuperare e la chiave primaria del record che vogliamo recuperare

        //s2.setNome("Dario");
        //s2.setCognome("Bianchi");

        //System.out.println(s2);

        //em.persist(s2); //update in questo caso perchè il record con quella matricola già esisteva

        //Studente s3 = em.find(Studente.class, 252); //per aggiornare un elemendo devo aspettarmelo nel contesto quindi uso il metodo find

        //em.remove(s3); //remove cancella l record con quella matricola dalla tabella

        em.getTransaction().commit(); //committo una transazione

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        //Query di jacarta persistence
        //select * from studenti where nome= 'Mario'
        Query query = em.createQuery("select s from Studente s where s.nome ='Mario'", Studente.class);//query in jpql

        query.getResultList().stream().forEach(s->System.out.println(s));;

}

    
}
