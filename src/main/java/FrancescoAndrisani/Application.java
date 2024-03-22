package FrancescoAndrisani;

import FrancescoAndrisani.dao.CatalogoDAO;
import FrancescoAndrisani.dao.PrestitoDAO;
import FrancescoAndrisani.dao.UtenteDAO;
import FrancescoAndrisani.entities.*;
import com.github.javafaker.Cat;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu4w3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        Random rndm = new Random();


        /*for (int i = 0; i < 10; i++) {
            int num = rndm.nextInt(2);
            if (num == 0) {
                Catalogo book = new Book(faker.code().isbn10(), faker.book().title(), rndm.nextInt(2019, 2023), rndm.nextInt(100, 1000), faker.book().author(), faker.book().genre() );
                catalogoDAO.save(book);
            } else {
                Catalogo magazines = new Magazines(faker.code().isbn10(), faker.book().title(), rndm.nextInt(2019, 2023), rndm.nextInt(100, 1000), Periodicita.MENSILE );
                catalogoDAO.save(magazines);
            }
        }

        for (int i = 1; i <= 10; i++) {
            Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(2024, 1, 1), faker.number().digit());
            utenteDAO.save(utente);
        }

        List<Utente> utenti = utenteDAO.findAll();
        List<Catalogo> catalogo = catalogoDAO.findAll();

        for (int i = 0; i < 5; i++) {
            Utente utente = utenti.get(i);
            Catalogo elemento = catalogo.get(i);
            Prestito prestito = new Prestito(utente, elemento, LocalDate.now(), LocalDate.now().plusDays(30));
            prestitoDAO.save(prestito);
        }*/


          /* // Richiamiamo la query per ottenere tutti gli oggetti di catalogo sottofoma di lista in un certo anno passato come parametro
        List<Catalogo> catalogoAnnoPubblicazione = catalogoDAO.getCatalogoPerAnnoPubblicazione(2020);
        System.out.println("Catalogo per anno di pubblicazione: " + catalogoAnnoPubblicazione);*/

        /*// Richiamiamo la query per ottenere tutti gli oggetti di catalogo scritti da un autore che passiamo come parametro
     List<Book> libriPerAutore = catalogoDAO.getLibriPerAutore("Ettore Orlando");
        System.out.println("Libri per autore: " + libriPerAutore);*/

       /* // Richiamiamo la query per ottenere tutti gli oggetti di catalogo che hanno un titolo che passiamo come parametro. Possiamo passare pure parte di titolo
        List<Catalogo> catalogoPerTitolo = catalogoDAO.getCatalogoPerTitolo("Behold the Man");
        System.out.println("Catalogo per titolo: " + catalogoPerTitolo);*/

       /* //Richiamando questa query invece, passando per parametro il numero di una tessera, possiamo vedere gli oggetti in prestito ancora non restituiti di quell'utente
        List<Catalogo> elementiInPrestito = prestitoDAO.getElementiInPrestitoPerNumeroTessera(1);
        System.out.println("Elementi in prestito: " + elementiInPrestito);*/

       /* // Richiamiamo la query per ottenere tutti gli utenti che hanno preso in prestito un oggetto del catalogo e non l'hanno ancora restituito pur essendo scaduto il termine ultimo
        List<Prestito> prestitiScaduti = prestitoDAO.getPrestitiScadutiNonRestituiti();
        System.out.println("Prestiti scaduti: " + prestitiScaduti);*/

        em.close();
        emf.close();

    }
}