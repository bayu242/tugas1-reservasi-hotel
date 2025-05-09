package reservasi;

public class Main {
    Tools tools = new Tools();

    // method untuk menampilkan data kamar
    public void tampilkanDataKamar(Kamar data_kamar[]) {
        for (int i = 0; i < data_kamar.length; i++) {
            System.out.print("No. " + (i + 1));
            System.out.print("\tNomor Kamar : " + data_kamar[i].nomor_kamar);
            System.out.print("\tTipe Kamar : " + data_kamar[i].tipe_kamar);
            System.out.print("\tHarga per Malam : " + tools.formatRupiah(data_kamar[i].harga_permalam));
            System.out.print("\tStatus Ketersediaan : " + (data_kamar[i].status_ketersediaan ? "Terisi" : "Tersedia"));
            System.out.println(); // baris kosong antar data
        }
    }

    // method untuk menerima pesanan booking kamar dan memasukkan ke dalam data
    // booking
    public void bookingKamar(Kamar data_Kamar[], ReservasiKamar data_booking[], int nomor_kamar,
            int lama_menginap) {
        boolean isBooking = false;
        boolean isValid = false;
        boolean isAvailable = false;
        for (ReservasiKamar booking : data_booking) {
            // cek apakah data booking masih tersedia yaitu maskimal 3 kamar
            if (booking == null) {
                isBooking = true;
                for (Kamar kamar : data_Kamar) {
                    // cek apakah nomor kamar sesuai dengan data kamar
                    if (kamar.nomor_kamar == nomor_kamar) {
                        isValid = true; // kamar ditemukan
                        // cek ketersediaan kamar
                        if (kamar.status_ketersediaan == false) {
                            isAvailable = true;
                            // memasukkan pesanan data booking
                            for (int i = 0; i < data_booking.length; i++) {
                                if (data_booking[i] == null) {
                                    data_booking[i] = new ReservasiKamar(nomor_kamar, kamar.tipe_kamar,
                                            kamar.harga_permalam,
                                            lama_menginap);

                                    // rubah status ketersediaan menjadi sudah terisi
                                    kamar.setKetersediaanTerisi();

                                    // tampilkan detail booking
                                    System.out.println("-----Booking kamar berhasil-----");
                                    System.out.println("Nomor kamar : " + kamar.nomor_kamar);
                                    System.out.println("Tipe Kamar : " + kamar.tipe_kamar);
                                    System.out.println("Lama menginap : " + lama_menginap + " Malam");
                                    System.out.println("Total biaya : ");
                                    System.out.println(
                                            "\tHarga Booking permalam : " + tools.formatRupiah(kamar.harga_permalam));
                                    System.out.println("\tTotal harga bookinng " + lama_menginap + " Malam : "
                                            + (tools.formatRupiah(kamar.harga_permalam * lama_menginap)));
                                    System.out.println("\tBiaya layanan perkamar : " + tools.formatRupiah(50000));
                                    System.out.println(
                                            "\tTotal biaya : " + (tools
                                                    .formatRupiah(kamar.harga_permalam * lama_menginap + 50000)));
                                    System.out.println();
                                    break;
                                }
                            }
                        }
                        if (!isAvailable) {
                            System.out.println("Kamar sudah terisi silahkan pilih kamar yang lain");
                        }
                    }
                }

                if (!isValid) {
                    System.out.println("Kamar tidak ditemukan");
                }

            }
        }

        if (!isBooking) {
            System.out.println("Booking sudah melebihi batas yaitu 3 kamar");
        }

    }

    // methos untuk menampilkan daftar booking kamar
    public void tampilkanDaftarBooking(ReservasiKamar data_booking[]) {
        int index = 0;
        boolean isAvailable = false;
        System.out.println("Data kamar yang sudah anda booking\n");
        for (ReservasiKamar booking : data_booking) {
            index++;
            if (booking != null) {
                isAvailable = true;
                System.out.println("[" + index + "] " + "Nomer Kamar : " + booking.nomor_kamar + "\t| Tipe Kamar : "
                        + booking.tipe_kamar + "\t| Lama Menginap : " + booking.lama_menginap
                        + " malam\t| Harga Permalam : "
                        + tools.formatRupiah(booking.harga_permalam));
            }
        }
        if (!isAvailable) {
            System.out.println("---Tidak ada kamar yang and booking---");
        }
    }

    // method untuk membatalkan booking kamar
    public void batalkanBookingKamar(ReservasiKamar data_booking[], Kamar data_kamar[], int nomor_kamar) {

        boolean isValid = false;
        for (int i = 0; i < data_booking.length; i++) {
            // pastikan data tidak null untuk menghindari error
            if (data_booking[i] != null) {
                // cek apakah nomer kamar sesuai data booking
                if (data_booking[i].nomor_kamar == nomor_kamar) {
                    isValid = true;
                    System.out.println("Booking berhasil dibatalkan");
                    System.out.println("\tNo Kamar : " + data_booking[i].nomor_kamar);
                    System.out.println("\tTipe Kamar : " + data_booking[i].tipe_kamar);

                    // rubah isi data menjadi null / kosong
                    data_booking[i] = null;

                    // rubah ketersediaan kamar yang dibatalkan menjadi kosong
                    for (Kamar kamar : data_kamar) {
                        if (kamar.nomor_kamar == nomor_kamar) {
                            kamar.setKetersediaanKosong();
                        }
                    }
                }
            }

        }
        if (!isValid) {
            System.out.println("Nomor kamar salah atau tidak valid");
        }
    }

    // Method untuk mencetak struk
    public void cetakStrukBooking(ReservasiKamar data_booking[]) {
        int index = 0;
        double total_biaya = 0;
        for (ReservasiKamar booking : data_booking) {
            index++;
            if (booking != null) {
                System.out.println("[" + index + "] " + "Nomer Kamar : " + booking.nomor_kamar + "\t| Tipe Kamar : "
                        + booking.tipe_kamar + "\t| Lama Menginap : " + booking.lama_menginap
                        + " malam\t| Biaya : "
                        + tools.formatRupiah(biayaPerkamar(booking)));
                total_biaya = total_biaya + biayaPerkamar(booking);
            }
        }

        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
        System.out.println("Total\t\t\t\t\t\t\t\t\t\t\t: " + tools.formatRupiah(total_biaya));
        if (total_biaya > 500000) {
            double harga_diskon = diskon(total_biaya);
            System.out.println("Diskon\t\t\t\t\t\t\t\t\t\t\t: 15%");
            total_biaya = harga_diskon;
        }
        total_biaya = pajak(total_biaya);
        System.out.println("Pajak\t\t\t\t\t\t\t\t\t\t\t: 10%");
        System.out.println("Total Biaya Booking\t\t\t\t\t\t\t\t\t: " + tools.formatRupiah(total_biaya));

    }

    // method untuk menghitung biaya perkamar
    private int biayaPerkamar(ReservasiKamar booking) {
        return booking.harga_permalam * booking.lama_menginap + 50000;
    }

    // method untuk menghitung diskon 15%
    private double diskon(double total_harga) {
        return total_harga - (total_harga * 0.15);
    }

    // method untuk menghitung pajak 10%
    private double pajak(double total_harga) {
        return total_harga + (total_harga * 0.10);
    }
}
