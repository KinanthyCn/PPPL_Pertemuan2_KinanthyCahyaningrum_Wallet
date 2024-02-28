

import java.time.LocalDate;
import java.util.Objects;

public class Card {
    String namaPemilik;
    String noRek;
    LocalDate masaAktif;

    String namaBank;


    public Card(String namaPemilik, String noRek, String namaBank) {
        this.namaPemilik = namaPemilik;
        this.noRek = noRek;
        this.namaBank = namaBank;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public LocalDate getMasaAktif() {
        return masaAktif;
    }

    public void setMasaAktif(LocalDate masaAktif) {
        this.masaAktif = masaAktif;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    @Override
    public String toString() {
        return "" + namaBank + " " + noRek;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(namaPemilik, card.namaPemilik) &&
                Objects.equals(noRek, card.noRek) &&
                Objects.equals(namaBank, card.namaBank);
    }

}
