import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QueueBarangDiskon {
    private Node front;
    private Node rear;

    public QueueBarangDiskon() {
        front = rear = null;
    }

    // Method isEmpty()
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue - Kembali ke Antrean FIFO murni
    public void enqueue(Barang barang) {
        Node newNode = new Node(barang);
        // Pengecekan tanggal masih bisa dilakukan untuk validasi,
        // tapi tidak mempengaruhi urutan penyisipan lagi.
        if (barang.getTanggalBerakhirAsLocalDate() == null) {
            System.out.println("Tanggal berakhir tidak valid untuk barang " + barang.getNama() + ". Barang tidak ditambahkan.");
            return;
        }

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        System.out.println("Barang " + barang.getNama() + " ditambahkan ke antrian.");
    }

// Dequeue (tetap sama)
    public Barang dequeue() {
        if (isEmpty()) {
            System.out.println("Barang kosong!");
            return null;
        }
        Barang barang = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return barang;
    }

    // Peek (tetap sama)
    public Barang peek() {
        if (isEmpty()) {
            System.out.println("Barang kosong!");
            return null;
        }
        return front.getData();
    }

    // Display (tetap sama)
    public void display() {
        if (isEmpty()) {
            System.out.println("Tidak ada barang dalam antrian");
            return;
        }
        System.out.println("\n=== DAFTAR BARANG DISKON (Urutan Masuk) ===");
        Node current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // Metode updateStok, searchBarang, dan removeBarang
    // 5. Ubah Stok Barang (tetap sama)
    public void updateStok(String kodeBarang, int newStok) {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada barang untuk diubah stoknya.");
            return;
        }

        Node current = front;
        boolean found = false;
        while (current != null) {
            if (current.getData().getKode().equalsIgnoreCase(kodeBarang)) {
                current.getData().setStok(newStok);
                System.out.println("Stok barang " + current.getData().getNama() + " (Kode: " + kodeBarang + ") berhasil diubah menjadi " + newStok + ".");
                found = true;
                break;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan dalam antrian.");
        }
    }

    // 6. Cari Barang (tetap sama)
    public void searchBarang(String keyword) {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada barang untuk dicari.");
            return;
        }

        Node current = front;
        boolean found = false;
        System.out.println("\n=== Hasil Pencarian ===");
        while (current != null) {
            if (current.getData().getKode().equalsIgnoreCase(keyword) ||
                current.getData().getNama().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Ditemukan: " + current.getData());
                found = true;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("Tidak ada barang yang cocok dengan '" + keyword + "' dalam antrian.");
        }
    }

    // 7. Hapus Barang dari Antrean (tetap sama)
    public void removeBarang(String kodeBarang) {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada barang untuk dihapus.");
            return;
        }

        if (front.getData().getKode().equalsIgnoreCase(kodeBarang)) {
            System.out.println("Barang " + front.getData().getNama() + " (Kode: " + kodeBarang + ") berhasil dihapus dari antrian.");
            front = front.getNext();
            if (front == null) {
                rear = null;
            }
            return;
        }

        Node current = front;
        Node previous = null;
        boolean found = false;

        while (current != null && !current.getData().getKode().equalsIgnoreCase(kodeBarang)) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
            if (current == rear) {
                rear = previous;
            }
            System.out.println("Barang " + current.getData().getNama() + " (Kode: " + kodeBarang + ") berhasil dihapus dari antrian.");
            found = true;
        }

        if (!found) {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan dalam antrian.");
        }
    }
}