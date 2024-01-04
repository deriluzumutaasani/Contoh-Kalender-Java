import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class kalender {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Kalender");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new BorderLayout());

            // Panel untuk menampilkan kalender
            JPanel calendarPanel = new JPanel(new GridLayout(0, 7));
            calendarPanel.setBackground(Color.WHITE);

            // Mendapatkan instance dari Calendar
            Calendar calendar = Calendar.getInstance();

            // Menampilkan tanggal saat ini
            int tanggalSekarang = calendar.get(Calendar.DAY_OF_MONTH);
            int bulanSekarang = calendar.get(Calendar.MONTH) + 1; // Perlu ditambah 1 karena index bulan dimulai dari 0
            int tahunSekarang = calendar.get(Calendar.YEAR);
            JLabel dateLabel = new JLabel("Sekarang tanggal " + tanggalSekarang + "/" + bulanSekarang + "/" + tahunSekarang);
            dateLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.add(dateLabel, BorderLayout.NORTH);

            // Menampilkan kalender bulan dan tahun saat ini
            JLabel calendarLabel = new JLabel("Kalender Bulan " + bulanSekarang + " Tahun " + tahunSekarang + ":");
            calendarLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.add(calendarLabel, BorderLayout.CENTER);

            // Menentukan jumlah hari dalam bulan saat ini
            int jumlahHari = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            // Menampilkan kalender
            String[] hari = {"Ming", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"};
            for (String day : hari) {
                JLabel label = new JLabel(day);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setForeground(Color.BLACK); // Warna teks hari
                calendarPanel.add(label);
            }

            int hariAwalBulan = calendar.get(Calendar.DAY_OF_WEEK);
            for (int i = 1; i < hariAwalBulan; i++) {
                JLabel emptyLabel = new JLabel("");
                calendarPanel.add(emptyLabel); // Spasi untuk hari-hari sebelum tanggal pertama bulan
            }
            for (int i = 1; i <= jumlahHari; i++) {
                JLabel label = new JLabel(String.valueOf(i));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Garis pinggir setiap tanggal
                if (i == tanggalSekarang) {
                    label.setOpaque(true);
                    label.setBackground(Color.YELLOW); // Warna latar belakang tanggal saat ini
                }
                calendarPanel.add(label);
            }

            frame.add(calendarPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
