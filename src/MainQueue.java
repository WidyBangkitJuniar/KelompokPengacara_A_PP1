import java.util.Scanner;

public class MainQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueBarangDiskon queue = new QueueBarangDiskon();
        int pilihan;

        do {
            System.out.println("------------------------------------------------------------");
            System.out.println("          SISTEM INFORMASI PENJUALAN BARANG DISKON");
            System.out.println("                        TOKO SEMBAKO ");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Tambah Barang "); //(Enqueue)
            System.out.println("2. Jual Barang "); //(Dequeue)
            System.out.println("3. Lihat Barang Terdepan "); //(Peek)
            System.out.println("4. Tampilkan Semua Barang");
            System.out.println("5. Ubah Stok Barang");
            System.out.println("6. Cari Barang");
            System.out.println("7. Hapus Barang dari Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Kode Barang: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama Barang: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga Diskon: Rp");
                    double harga = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Tanggal Berakhir (DD-MM-YYYY): ");
                    String tanggal = sc.nextLine();
                    System.out.print("Stok Awal: ");
                    int stok = sc.nextInt();
                    queue.enqueue(new Barang(kode, nama, harga, tanggal, stok));
                    break;

                case 2:
                    Barang terjual = queue.dequeue();
                    if (terjual != null) {
                        System.out.println("Barang terjual: " + terjual.getNama());
                    }
                    break;

                case 3:
                    Barang depan = queue.peek();
                    if (depan != null) {
                        System.out.println("Barang terdepan: " + depan);
                    }
                    break;

                case 4:
                    queue.display();
                    break;

                case 5: // Implementasi Ubah Stok Barang
                    System.out.print("Masukkan Kode Barang yang stoknya ingin diubah: ");
                    String kodeUbahStok = sc.nextLine();
                    System.out.print("Masukkan Jumlah Stok Baru: ");
                    int stokBaru = sc.nextInt();
                    sc.nextLine(); // consume newline
                    queue.updateStok(kodeUbahStok, stokBaru);
                    break;

                case 6: // Implementasi Cari Barang
                    System.out.print("Masukkan Kode atau Nama Barang yang dicari: ");
                    String keywordCari = sc.nextLine();
                    queue.searchBarang(keywordCari);
                    break;

                case 7: // Implementasi Hapus Barang dari Antrean
                    System.out.print("Masukkan Kode Barang yang ingin dihapus: ");
                    String kodeHapus = sc.nextLine();
                    queue.removeBarang(kodeHapus);
                    break;

                case 0:
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
        sc.close();
    }
}