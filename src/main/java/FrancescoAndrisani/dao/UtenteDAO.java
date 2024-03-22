package FrancescoAndrisani.dao;

import FrancescoAndrisani.entities.Prestito;
import FrancescoAndrisani.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(utente);
            t.commit();
            System.out.println("Nuovo utente aggiunto con successo!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Utente findById(long id) {
        return em.find(Utente.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Utente found = em.find(Utente.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Utente del catalogo eliminato con successo!");
            } else System.out.println("Utente non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Utente> findAll() {
        TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u", Utente.class);
        return query.getResultList();
    }
}
