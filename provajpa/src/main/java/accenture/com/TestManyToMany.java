package accenture.com;

import java.util.List;

import accenture.com.dao.PostgresqlDao;
import accenture.com.entity.Corso;
import accenture.com.entity.Studente;

public class TestManyToMany {
    public static void main(String[] args) {


        PostgresqlDao dao = new PostgresqlDao();

   /*   Corso c1 = new Corso("infomatica", "mario rossi", 20);
        Corso c2 = new Corso("informatica2", "sara verdi", 15);
        Corso c3 = new Corso("base dati", "valeria neri", 15);

        dao.saveCorso(c1);
        dao.saveCorso(c2);
        dao.saveCorso(c3);

        Studente s1= new Studente("Alberto", "Viola", "Via vulcano");
        
        Studente s2= new Studente("Francesca", "Bianchi", "Via delle puglie");

        s1.setCorsi(List.of(c1,c2));
        s2.setCorsi(List.of(c1,c2,c3));

        dao.saveStudente(s1);
        dao.saveStudente(s2);

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(c1.getStudenti()); */

        Studente s1 = dao.getStudenteById(1653);
        System.out.println(s1.getCorsi());


        Corso c1 = dao.getCorsoById(2);
        System.out.println(c1.getStudenti());








    }

    
    
}
