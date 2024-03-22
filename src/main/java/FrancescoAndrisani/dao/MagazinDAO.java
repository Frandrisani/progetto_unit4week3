package FrancescoAndrisani.dao;

import FrancescoAndrisani.entities.Magazines;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MagazinDAO {
    private EntityManager em;

    public MagazinDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Magazines magazine) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(magazine);
            t.commit();
            System.out.println("Nuova rivista aggiunta con successo! L'elemento aggiunto è: " + magazine.getIsbn() + " " + magazine.getTitolo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}