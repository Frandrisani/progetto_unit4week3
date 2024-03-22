package FrancescoAndrisani.dao;

import FrancescoAndrisani.entities.Catalogo;
import FrancescoAndrisani.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(prestito);
            t.commit();
            System.out.println("Nuovo elemento aggiunto con successo!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Prestito findById(long id) {
        return em.find(Prestito.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Prestito found = em.find(Prestito.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento del catalogo eliminato con successo!");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Prestito> findAll() {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p", Prestito.class);
        return query.getResultList();
    }

    // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
    public List<Catalogo> getElementiInPrestitoPerNumeroTessera(int numeroTessera) {
        TypedQuery<Catalogo> list = em.createQuery("SELECT p.oggetto FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS null", Catalogo.class);
        list.setParameter("numeroTessera", numeroTessera);
        return list.getResultList();
    }

    // Ricerca di tutti i prestiti scaduti e non ancora restituiti
    public List<Prestito> getPrestitiScadutiNonRestituiti() {
        TypedQuery<Prestito> list = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        return list.getResultList();
    }
}
