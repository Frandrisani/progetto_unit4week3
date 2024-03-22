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


        for (int i = 0; i < 10; i++) {
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
        }


       /* // Esempio di ricerca per anno di pubblicazione
        List<Catalogo> catalogoAnnoPubblicazione = catalogoDAO.getCatalogoPerAnnoPubblicazione(2020);
        System.out.println("Catalogo per anno di pubblicazione: " + catalogoAnnoPubblicazione);

        // Esempio di ricerca per autore
        List<Book> libriPerAutore = catalogoDAO.getLibriPerAutore("John Doe");
        System.out.println("Libri per autore: " + libriPerAutore);

        // Esempio di ricerca per titolo
        List<Catalogo> catalogoPerTitolo = catalogoDAO.getCatalogoPerTitolo("Java");
        System.out.println("Catalogo per titolo: " + catalogoPerTitolo);

        // Esempio di ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        List<Catalogo> elementiInPrestito = catalogoDAO.getElementiInPrestitoPerNumeroTessera("1234567890");
        System.out.println("Elementi in prestito: " + elementiInPrestito);

        // Esempio di ricerca di tutti i prestiti scaduti e non ancora restituiti
        List<Prestito> prestitiScaduti = catalogoDAO.getPrestitiScadutiNonRestituiti();
        System.out.println("Prestiti scaduti: " + prestitiScaduti);*/

        em.close();
        emf.close();

    }
}