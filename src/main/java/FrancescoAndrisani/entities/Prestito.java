package FrancescoAndrisani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "presiti")
public class Prestito {
    // attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_id")
    private Catalogo oggetto;
    private LocalDate inizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    // costruttore
    public Prestito() {}

    public Prestito(Utente utente, Catalogo elemento, LocalDate inizioPrestito, LocalDate dataRestituzionePrevista) {
        this.utente = utente;
        this.oggetto = elemento;
        this.inizioPrestito = inizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    // getter e setter

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getOggetto() {
        return oggetto;
    }

    public void setOggetto(Catalogo oggetto) {
        this.oggetto = oggetto;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        //Da ricerca su come gestire la data di restituzione effettiva ho scoperto plusDays()
    //https://www.geeksforgeeks.org/localdate-plusdays-method-in-java-with-examples/
    this.dataRestituzionePrevista = this.inizioPrestito.plusDays(30);
}

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", oggetto=" + oggetto +
                ", inizioPrestito=" + inizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}





