import java.util.Scanner;
import reservasi.Kamar;
import reservasi.Kamar.TipeKamar;
import reservasi.Main;
import reservasi.ReservasiKamar;
import reservasi.Tools;

public class ReservasiHotel {

    // data kamar yang tersedia
    public static Kamar data_kamar[] = {
            new Kamar(101, TipeKamar.STANDAR, 150000),
            new Kamar(102, TipeKamar.STANDAR, 150000),
            new Kamar(103, TipeKamar.DELUXE, 200000),
            new Kamar(104, TipeKamar.SUITE, 250000),
            new Kamar(105, TipeKamar.DELUXE, 200000),
            new Kamar(106, TipeKamar.STANDAR, 150000),
            new Kamar(107, TipeKamar.SUITE, 250000),
            new Kamar(108, TipeKamar.DELUXE, 200000),
            new Kamar(109, TipeKamar.STANDAR, 150000),
            new Kamar(110, TipeKamar.SUITE, 250000),
            new Kamar(111, TipeKamar.STANDAR, 150000),
            new Kamar(112, TipeKamar.SUPERIOR, 175000),
            new Kamar(113, TipeKamar.SUPERIOR, 175000),
            new Kamar(114, TipeKamar.SUPERIOR, 175000),
            new Kamar(115, TipeKamar.SUPERIOR, 175000),
    };

    //tempat data pesanan akan disimpan
    public static ReservasiKamar data_booking[] = new ReservasiKamar[3];

    public static void main(String[] args) {
        Main App = new Main();
        Scanner input = new Scanner(System.in);
        Tools tools = new Tools();
        // App.tampilkanDataKamar(data.data_kamar);
        // App.tampilkanDaftarBooking(data.data_booking);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("----------------------------Selamat Datang----------------------------");
        System.out.println("---------------------------------------------------------------------\n");

        boolean menuActive = true;

        while (menuActive) {
            System.out.println("\nSilahkan pilih menu : ");
            System.out.println("[1] Daftar Kamar \t[2] Booking kamar");
            System.out.println("[3] Daftar Booking \t[4] Batalkan Booking");
            System.out.println("[5] Cetak Struk \t[6] Keluar Aplikasi");
            System.out.print("Pilih Menu: ");
            int menu = 0;

            try {
                menu = input.nextInt();
            } catch (Exception e) {
                System.out.println("Input tidak valid atau tidak sesuai dengan menu");
                input.nextLine();
            }

            switch (menu) {
                case 1:// menu 2 menampilkan daftar kamar yang ada di hotel
                    tools.clearScreen();
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");

                    System.out.println(
                            "=============================================Daftar Kamar=============================================\n");

                    App.tampilkanDataKamar(data_kamar);
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");
                    break;

                case 2: // menu 2 melakukan booking kamar
                    tools.clearScreen();
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");

                    System.out.println(
                            "=============================================Booking Kamar=============================================\n");
                    int nomor_kamar = 0;
                    int lama_menginap = 0;
                    try {
                        System.out.print("Pilih nomor kamar : ");
                        nomor_kamar = input.nextInt();
                        System.out.print("Masukan berapa malam anda ingin menginap : ");
                        lama_menginap = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Input tidak valid");
                        input.nextLine();
                    }
                    App.bookingKamar(data_kamar, data_booking, nomor_kamar,
                            lama_menginap);
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");

                    break;

                case 3: // menu 3 menampilkn daftar booking
                    tools.clearScreen();
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");

                    System.out.println(
                            "=============================================Daftar Kamar=============================================\n");
                    App.tampilkanDaftarBooking(data_booking);
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");
                    break;

                case 4: // menu 4 membatalkan booking kamar
                    tools.clearScreen();
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");

                    System.out.println(
                            "=====================================Membatalkan Booking Kamar=======================================\n");
                    boolean isBooking = false;
                    for (ReservasiKamar booking : data_booking) {
                        // pengeceka data booking
                        if (booking != null) {
                            isBooking = true;
                        }
                    }

                    if (!isBooking) {
                        System.out.println("Anda belum melakukan booking");
                    } else {
                        int no_kamar = 0;
                        try {
                            System.out.print("Massukan nomor kamar : ");
                            no_kamar = input.nextInt();
                        } catch (Exception e) {
                            System.out.println("Input tidak valid");
                            input.nextLine();
                        }
                        App.batalkanBookingKamar(data_booking, data_kamar, no_kamar);
                    }

                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");
                    break;

                case 5: // menu 5 mencetak struk
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");

                    System.out.println(
                            "=======================================Mencetak Struk Booking=========================================\n");

                    App.cetakStrukBooking(data_booking);

                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------");
                    break;
                case 6: // keluar dari aplikasi
                    tools.clearScreen();
                    try {
                        System.out.println("Yakin ingin keluar?");
                        System.out.print("Ketik [1] untuk keluar / ketik apa saja untuk membatalkan :");
                        int exit = input.nextInt();
                        if (exit == 1) {
                            menuActive = false;
                        }
                    } catch (Exception e) {
                        input.nextLine();
                    }
                    break;
            }

        }

        input.close();
    }

}