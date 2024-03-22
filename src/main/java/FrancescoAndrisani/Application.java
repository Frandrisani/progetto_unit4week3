package FrancescoAndrisani;

import FrancescoAndrisani.dao.CatalogoDAO;
import FrancescoAndrisani.entities.Book;
import FrancescoAndrisani.entities.Catalogo;
import FrancescoAndrisani.entities.Magazines;
import FrancescoAndrisani.entities.Periodicita;
import com.github.javafaker.Cat;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu4w3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        CatalogoDAO obDAO = new CatalogoDAO(em);
        Random rndm = new Random();


        for (int i = 0; i < 10; i++) {
            int num = rndm.nextInt(2);
            if (num == 0) {
                Catalogo book = new Book(faker.code().isbn10(), faker.book().title(), rndm.nextInt(2019, 2023), rndm.nextInt(100, 1000), faker.book().author(), faker.book().genre() );
                obDAO.save(book);
            } else {
                Catalogo magazines = new Magazines(faker.code().isbn10(), faker.book().title(), rndm.nextInt(2019, 2023), rndm.nextInt(100, 1000), Periodicita.MENSILE );
                obDAO.save(magazines);
            }
        }


    }
}