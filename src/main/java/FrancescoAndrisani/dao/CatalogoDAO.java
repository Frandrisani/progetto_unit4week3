package FrancescoAndrisani.dao;

import FrancescoAndrisani.entities.Book;
import FrancescoAndrisani.entities.Catalogo;
import FrancescoAndrisani.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogoDAO {
    private EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    // Salviamo nel database un oggetto di tipo Catalogo
    public void save(Catalogo oggetto) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(oggetto);
            t.commit();
            System.out.println("Nuovo elemento aggiunto con successo! L'elemento aggiunto è: " + oggetto.getIsbn()+ " "+ oggetto.getTitolo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Cerchiamo un oggetto di tipo Catalogo in base al codice ISBN
    public Catalogo findById(String isbn) {
        return em.find(Catalogo.class, isbn);
    }

    // Cerchiamo e, se trovato, eliminiamo un oggetto di tipo Catalogo in base al codice ISBN
    public void findByIdAndDelete(String isbn) {
        try {
            EntityTransaction t = em.getTransaction();
            Catalogo found = em.find(Catalogo.class, isbn);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Oggetto del catalogo eliminato con successo! E' stato eliminato l'oggetto:" + isbn);
            } else System.out.println("Oggetto non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Facciamoci restituire una lista di tutti gli oggetti di tipo Catalogo
    public List<Catalogo> findAll() {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c", Catalogo.class);
        return query.getResultList();
    }

    // Ricedca per anno di pubblicazione
    public List<Catalogo> getCatalogoPerAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Catalogo> list = em.createQuery("SELECT c FROM Catalogo c WHERE c.annoDiPubblicazione = :anno", Catalogo.class);
        list.setParameter("anno", annoPubblicazione);
        return list.getResultList();
    }

    // Ricerca per autore (solo per Book in quanto solo loro hanno qeull'attributo)
    public List<Book> getLibriPerAutore(String autore) {
        TypedQuery<Book> list = em.createQuery("SELECT b FROM Book b WHERE b.autore = :autore", Book.class);
        list.setParameter("autore", autore);
        return list.getResultList();
    }

    // Ricerca per titolo o parte di esso
    public List<Catalogo> getCatalogoPerTitolo(String titolo) {
        TypedQuery<Catalogo> list = em.createQuery("SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE :titolo", Catalogo.class);
        //toLowerCase() serve per non fare distinzione tra maiuscole e minuscole eventuali
        list.setParameter("titolo", "%" + titolo.toLowerCase() + "%");
        return list.getResultList();
    }


}
