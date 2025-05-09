package reservasi;

public class ReservasiKamar extends Kamar {

    int lama_menginap;

    public ReservasiKamar(int nomor_kamar, TipeKamar tipe_kamar, int harga_permalam, int lama_menginap) {
        super(nomor_kamar, tipe_kamar, harga_permalam);
        this.lama_menginap = lama_menginap;
    }  
}
