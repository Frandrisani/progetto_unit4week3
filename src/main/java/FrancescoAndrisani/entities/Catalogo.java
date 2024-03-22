package FrancescoAndrisani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalogo")
public abstract class Catalogo {
    // attributi
    @Id
    protected String isbn;
    protected String titolo;
    protected int annoDiPubblicazione;
    protected int numeroPagine;

    // costruttore
    public Catalogo(String isbn, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Catalogo() {}

    // setter e getter

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
