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