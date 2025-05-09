package reservasi;

public class Kamar {

    public enum TipeKamar {
        STANDAR, SUPERIOR, DELUXE, SUITE
    }

    int nomor_kamar;
    TipeKamar tipe_kamar;
    int harga_permalam;
    Boolean status_ketersediaan;

    public Kamar(int nomor_kamar, TipeKamar tipe_kamar, int harga_permalam) {
        this.nomor_kamar = nomor_kamar;
        this.tipe_kamar = tipe_kamar;
        this.harga_permalam = harga_permalam;
        this.status_ketersediaan = false;
    }

    public void setKetersediaanTerisi() {
        status_ketersediaan = true;
    }

    public void setKetersediaanKosong() {
        status_ketersediaan = false;
    }
}
