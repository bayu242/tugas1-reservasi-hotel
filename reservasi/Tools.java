package reservasi;

import java.text.NumberFormat;
import java.util.Locale;

public class Tools {
    //method untuk membersihkan terminal agar tampilan lebih bersih

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //method untuk menkonfersi nilai double atau integer ke dalam string dengan format rupiah
    
    public String formatRupiah(double nilai) {
        Locale indonesia = Locale.forLanguageTag("id-ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(indonesia);
        return formatRupiah.format(nilai);
    }

    public String formatRupiah(int nilai) {
        Locale indonesia = Locale.forLanguageTag("id-ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(indonesia);
        return formatRupiah.format(nilai);
    }
}
