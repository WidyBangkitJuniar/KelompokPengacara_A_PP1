public class Barang {
    public String kode;
    public String nama;
    public double harga;
    public double hargaDiskon;
    public String tanggalBerakhir;
    public int stok;

    public void Barang(String kode, String nama, double harga, double hargaDiskon, String tanggalBerakhir, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.hargaDiskon = harga * (1 - hargaDiskon / 100);
        this.tanggalBerakhir = tanggalBerakhir;
        this.stok = stok;

        // test //

    }

}
