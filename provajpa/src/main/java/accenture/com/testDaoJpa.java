package accenture.com;

import java.time.LocalDate;

import accenture.com.dao.PostgresqlDao;
import accenture.com.entity.CartaIdentita;
import accenture.com.entity.Esame;
import accenture.com.entity.Studente;

public class testDaoJpa {

    public static void main(String[] args) {
        PostgresqlDao dao = new PostgresqlDao();

        /* Studente s1 = new Studente("Valeria", "Bianchi", "via mazzini");
        dao.save(s1);

        dao.getAll().stream().forEach(s->System.out.println(s));

        System.out.println(dao.getByName("Mario")); */

        /* CartaIdentita c1 = new CartaIdentita("Roma,", LocalDate.of(2026, 05, 10), LocalDate.of(2026, 06, 15));

        Studente studente = dao.getStudenteById(802);

        c1.setStudente(studente);

        dao.saveCartaIdentita(c1);

        Studente s2 = new Studente("Luca", "Neri", "Via Palermo");

        s2.setCartaIdentita(c1);

        dao.saveStudente(s2);

        System.out.println(s2); */

/* 
        //creo un oggetto del lato inverso
        Studente s2 = new Studente("Mario", "Rossi", "Via Palermo");

        //lo salvo sul db
        dao.saveStudente(s2);

        
        //creo un oggetto del lato proprietario
        CartaIdentita c1 = new CartaIdentita("Roma,", LocalDate.of(2025, 05, 10), LocalDate.of(2025, 06, 15));

        //assegno all'oggetto del lato proprietario un oggetto del lato inverso
        c1.setStudente(s2);



        //salvo sul db l'oggetto del lato proprietario
        dao.saveCartaIdentita(c1);  

 */

        /* Studente s3 = dao.getStudenteById(1452); //devo pero eliminare nel tostring di studente il riferimento dell'altro

        System.out.println(s3); */

/*         //ONE TO MANY

        Studente s4 = new Studente("Francesco", "Verdi", "Via Bari");

        dao.saveStudente(s4);
        
        //proprietario perchè ha la join column
        Esame e1 = new Esame(LocalDate.of(2025, 03, 02), 28, "inf");
        Esame e2 = new Esame(LocalDate.of(2025, 11, 20), 29, "mat");
        Esame e3 = new Esame(LocalDate.of(2025, 02, 21), 30, "fis");


        e1.setStudente(s4);
        e2.setStudente(s4);
        e3.setStudente(s4);

        dao.saveEsame(e1);
        dao.saveEsame(e2);
        dao.saveEsame(e3);
 */

        Esame e1 = dao.getEsameById(3);

        System.out.println(e1);

        Studente s1 = dao.getStudenteById(1502);

        System.out.println(s1.getEsami());


        












    }
    
}
