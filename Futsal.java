import java.util.*;

class Pemain {
    int tinggi;
    int berat;

    Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public String toString() {
        return "Tinggi: " + tinggi + " cm, Berat: " + berat + " kg";
    }
}

public class Futsal {
    public static void main(String[] args) {
        // Data Tim A
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain(168, 50), new Pemain(170, 60), new Pemain(165, 56),
            new Pemain(168, 55), new Pemain(172, 60), new Pemain(170, 70),
            new Pemain(169, 66), new Pemain(165, 56), new Pemain(171, 72),
            new Pemain(166, 56)
        ));

        // Data Tim B
        List<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain(170, 66), new Pemain(167, 60), new Pemain(165, 59),
            new Pemain(166, 58), new Pemain(168, 58), new Pemain(175, 71),
            new Pemain(172, 68), new Pemain(171, 68), new Pemain(168, 65),
            new Pemain(169, 60)
        ));

        // 1a. Sorting berdasarkan Tinggi Badan (Asc & Desc)
        System.out.println("=== Sorting Berdasarkan Tinggi Badan ===");
        List<Pemain> timATinggiAsc = new ArrayList<>(timA);
        timATinggiAsc.sort(Comparator.comparingInt(p -> p.tinggi));
        System.out.println("Tim A - Tinggi Ascending:");
        timATinggiAsc.forEach(System.out::println);

        List<Pemain> timATinggiDesc = new ArrayList<>(timA);
        timATinggiDesc.sort(Comparator.comparingInt((Pemain p) -> p.tinggi).reversed());
        System.out.println("\nTim A - Tinggi Descending:");
        timATinggiDesc.forEach(System.out::println);

        List<Pemain> timBTinggiAsc = new ArrayList<>(timB);
        timBTinggiAsc.sort(Comparator.comparingInt(p -> p.tinggi));
        System.out.println("\nTim B - Tinggi Ascending:");
        timBTinggiAsc.forEach(System.out::println);

        List<Pemain> timBTinggiDesc = new ArrayList<>(timB);
        timBTinggiDesc.sort(Comparator.comparingInt((Pemain p) -> p.tinggi).reversed());
        System.out.println("\nTim B - Tinggi Descending:");
        timBTinggiDesc.forEach(System.out::println);

        // 1b. Sorting berdasarkan Berat Badan (Asc & Desc)
        System.out.println("\n=== Sorting Berdasarkan Berat Badan ===");
        List<Pemain> timABeratAsc = new ArrayList<>(timA);
        timABeratAsc.sort(Comparator.comparingInt(p -> p.berat));
        System.out.println("Tim A - Berat Ascending:");
        timABeratAsc.forEach(System.out::println);

        List<Pemain> timABeratDesc = new ArrayList<>(timA);
        timABeratDesc.sort(Comparator.comparingInt((Pemain p) -> p.berat).reversed());
        System.out.println("\nTim A - Berat Descending:");
        timABeratDesc.forEach(System.out::println);

        List<Pemain> timBBeratAsc = new ArrayList<>(timB);
        timBBeratAsc.sort(Comparator.comparingInt(p -> p.berat));
        System.out.println("\nTim B - Berat Ascending:");
        timBBeratAsc.forEach(System.out::println);

        List<Pemain> timBBeratDesc = new ArrayList<>(timB);
        timBBeratDesc.sort(Comparator.comparingInt((Pemain p) -> p.berat).reversed());
        System.out.println("\nTim B - Berat Descending:");
        timBBeratDesc.forEach(System.out::println);

        // 1c. Cari nilai maksimum dan minimum Tinggi & Berat untuk masing-masing tim
        System.out.println("\n=== Nilai Maksimum dan Minimum ===");
        System.out.printf("Tim A - Max Tinggi: %d cm, Min Tinggi: %d cm\n",
                maxTinggi(timA), minTinggi(timA));
        System.out.printf("Tim A - Max Berat: %d kg, Min Berat: %d kg\n",
                maxBerat(timA), minBerat(timA));
        System.out.printf("Tim B - Max Tinggi: %d cm, Min Tinggi: %d cm\n",
                maxTinggi(timB), minTinggi(timB));
        System.out.printf("Tim B - Max Berat: %d kg, Min Berat: %d kg\n",
                maxBerat(timB), minBerat(timB));

        // 1d. Copy seluruh anggota Tim B ke Tim C yang baru
        List<Pemain> timC = new ArrayList<>();
        timC.addAll(timB);
        System.out.println("\n=== Tim C (Copy dari Tim B) ===");
        timC.forEach(System.out::println);

        // 2a. ArrayList untuk data tim A dan B sudah ada di atas

        // Buat list tinggi dan berat terpisah untuk mempermudah pencarian
        List<Integer> tinggiTimA = getListTinggi(timA);
        List<Integer> beratTimA = getListBerat(timA);
        List<Integer> tinggiTimB = getListTinggi(timB);
        List<Integer> beratTimB = getListBerat(timB);

        // Sort list untuk binary search
        Collections.sort(tinggiTimA);
        Collections.sort(beratTimA);
        Collections.sort(tinggiTimB);
        Collections.sort(beratTimB);

        // 2b. Cari jumlah pemain Tim B dengan tinggi 168 dan 160 cm
        int freq168TimB = Collections.frequency(tinggiTimB, 168);
        int freq160TimB = Collections.frequency(tinggiTimB, 160);
        System.out.printf("\nTim B - Pemain dengan tinggi 168 cm: %d\n", freq168TimB);
        System.out.printf("Tim B - Pemain dengan tinggi 160 cm: %d\n", freq160TimB);

        // 2c. Cari jumlah pemain Tim A dengan berat 56 dan 53 kg
        int freq56TimA = Collections.frequency(beratTimA, 56);
        int freq53TimA = Collections.frequency(beratTimA, 53);
        System.out.printf("Tim A - Pemain dengan berat 56 kg: %d\n", freq56TimA);
        System.out.printf("Tim A - Pemain dengan berat 53 kg: %d\n", freq53TimA);

        // 2d. Cek apakah ada pemain Tim A yang memiliki tinggi atau berat sama dengan Tim B
        boolean adaTinggiSama = !Collections.disjoint(tinggiTimA, tinggiTimB);
        boolean adaBeratSama = !Collections.disjoint(beratTimA, beratTimB);

        System.out.println("\nApakah ada pemain dengan tinggi sama di Tim A dan Tim B? " + (adaTinggiSama ? "Ya" : "Tidak"));
        System.out.println("Apakah ada pemain dengan berat sama di Tim A dan Tim B? " + (adaBeratSama ? "Ya" : "Tidak"));
    }

    // Helper methods untuk max, min, dan ekstraksi data
    private static int maxTinggi(List<Pemain> list) {
        return list.stream().mapToInt(p -> p.tinggi).max().orElse(-1);
    }

    private static int minTinggi(List<Pemain> list) {
        return list.stream().mapToInt(p -> p.tinggi).min().orElse(-1);
    }

    private static int maxBerat(List<Pemain> list) {
        return list.stream().mapToInt(p -> p.berat).max().orElse(-1);
    }

    private static int minBerat(List<Pemain> list) {
        return list.stream().mapToInt(p -> p.berat).min().orElse(-1);
    }

    private static List<Integer> getListTinggi(List<Pemain> list) {
        List<Integer> tinggi = new ArrayList<>();
        for (Pemain p : list) tinggi.add(p.tinggi);
        return tinggi;
    }

    private static List<Integer> getListBerat(List<Pemain> list) {
        List<Integer> berat = new ArrayList<>();
        for (Pemain p : list) berat.add(p.berat);
        return berat;
    }
}
