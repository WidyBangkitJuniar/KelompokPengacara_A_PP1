import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Barang {
    private String kode;
    private String nama;
    private double harga;
    private String tanggalBerakhir;
    private int stok;

        public Barang(String kode, String nama, double harga, String tanggalBerakhir, int stok) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
            this.tanggalBerakhir = tanggalBerakhir;
            this.stok = stok;
        }

       // Getter methods
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public String getTanggalBerakhir() { return tanggalBerakhir; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

       // Metode untuk mendapatkan LocalDate dari tanggalBerakhir
    public LocalDate getTanggalBerakhirAsLocalDate() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(tanggalBerakhir, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date for item " + nama + ": " + e.getMessage());
               return null; // Handle error appropriately
        }
    }

    @Override
    public String toString() {
        return kode + " - " + nama + " | Rp" + harga + " | Berakhir: " + tanggalBerakhir + " | Stok: " + stok;
    }
}
