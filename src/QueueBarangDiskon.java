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
        System.out.println("\n=== DAFTAR BARANG DISKON (Urutan Masuk) ==="); // Sesuaikan pesan
        Node current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }