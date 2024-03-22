package FrancescoAndrisani.entities;

import jakarta.persistence.*;

@Entity
public class Magazines extends Catalogo {
    // attributi
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    // costruttore
    public Magazines(String isbn, String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita){
        super(isbn, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
public Magazines() {
}
    // getter e setter

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // toString

    @Override
    public String toString() {
        return "Magazines{" +
                "periodicita=" + periodicita +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
