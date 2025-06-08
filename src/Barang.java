public class Barang {
    public String kode;
    public String nama;
    public double harga;
    public double hargaDiskon;
    public String tanggalBerakhir;
    public int stok;

    public Barang(String kode, String nama, double harga, double hargaDiskon, String tanggalBerakhir, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.hargaDiskon = hargaDiskon;
        this.tanggalBerakhir = tanggalBerakhir;
        this.stok = stok;

        public Barang(String kode, String nama, double harga, int stok) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
            this.hargaDiskon = 0.0;
            this.tanggalBerakhir = "";
            this.stok = stok;
        }
    }

}
