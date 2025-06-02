import java.util.*;

class Pemain { //class Pemain buat nyimpen data tinggi dan berat badan tiap pemain
    int tinggi;
    int berat;

Pemain(int tinggi, int berat) { //constructor buat bikin objek Pemain baru
    this.tinggi = tinggi;
    this.berat = berat;
    }

public String toString() { //supaya pas print, tampilannya enak dibaca
    return "Tinggi: " + tinggi + " cm, Berat: " + berat + " kg";
    }
}

public class Futsal {
    public static void main(String[] args) {
        //data pemain Tim A
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain(168, 50), new Pemain(170, 60), new Pemain(165, 56),
            new Pemain(168, 55), new Pemain(172, 60), new Pemain(170, 70),
            new Pemain(169, 66), new Pemain(165, 56), new Pemain(171, 72),
            new Pemain(166, 56)));
        // data pemain Tim B
        List<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain(170, 66), new Pemain(167, 60), new Pemain(165, 59),
            new Pemain(166, 58), new Pemain(168, 58), new Pemain(175, 71),
            new Pemain(172, 68), new Pemain(171, 68), new Pemain(168, 65),
            new Pemain(169, 60)));
        System.out.println("=== Urut berdasarkan tinggi badan ===");  // bagian sorting berdasarkan tinggi badan

        List<Pemain> timATinggiAsc = new ArrayList<>(timA); //sort Tim A dari pendek ke tinggi
        timATinggiAsc.sort(Comparator.comparingInt(p -> p.tinggi));
        System.out.println("Tim A - Tinggi naik:");
        timATinggiAsc.forEach(System.out::println);

        List<Pemain> timATinggiDesc = new ArrayList<>(timA);  //sort Tim A dari tinggi ke pendek
        timATinggiDesc.sort(Comparator.comparingInt((Pemain p) -> p.tinggi).reversed());
        System.out.println("\nTim A - Tinggi turun:");
        timATinggiDesc.forEach(System.out::println);

        List<Pemain> timBTinggiAsc = new ArrayList<>(timB);  //sort Tim B dari pendek ke tinggi
        timBTinggiAsc.sort(Comparator.comparingInt(p -> p.tinggi));
        System.out.println("\nTim B - Tinggi naik:");
        timBTinggiAsc.forEach(System.out::println);

        List<Pemain> timBTinggiDesc = new ArrayList<>(timB);  //sort Tim B dari tinggi ke pendek
        timBTinggiDesc.sort(Comparator.comparingInt((Pemain p) -> p.tinggi).reversed());
        System.out.println("\nTim B - Tinggi turun:");
        timBTinggiDesc.forEach(System.out::println);
        
        System.out.println("\n=== Urut berdasarkan berat badan ==="); //bagian sorting berdasarkan berat badan

        List<Pemain> timABeratAsc = new ArrayList<>(timA); //sort Tim A dari ringan ke berat
        timABeratAsc.sort(Comparator.comparingInt(p -> p.berat));
        System.out.println("Tim A - Berat naik:");
        timABeratAsc.forEach(System.out::println);

        List<Pemain> timABeratDesc = new ArrayList<>(timA); //sort Tim A dari berat ke ringan
        timABeratDesc.sort(Comparator.comparingInt((Pemain p) -> p.berat).reversed());
        System.out.println("\nTim A - Berat turun:");
        timABeratDesc.forEach(System.out::println);

        List<Pemain> timBBeratAsc = new ArrayList<>(timB); //sort Tim B dari ringan ke berat
        timBBeratAsc.sort(Comparator.comparingInt(p -> p.berat));
        System.out.println("\nTim B - Berat naik:");
        timBBeratAsc.forEach(System.out::println);

        List<Pemain> timBBeratDesc = new ArrayList<>(timB); //sort Tim B dari berat ke ringan
        timBBeratDesc.sort(Comparator.comparingInt((Pemain p) -> p.berat).reversed());
        System.out.println("\nTim B - Berat turun:");
        timBBeratDesc.forEach(System.out::println);

        System.out.println("\n=== Nilai maksimum dan minimum ===");  //cari nilai max dan min buat tinggi dan berat
        System.out.printf("Tim A - Tinggi max: %d cm, Tinggi min: %d cm\n", maxTinggi(timA), minTinggi(timA));
        System.out.printf("Tim A - Berat max: %d kg, Berat min: %d kg\n", maxBerat(timA), minBerat(timA));
        System.out.printf("Tim B - Tinggi max: %d cm, Tinggi min: %d cm\n", maxTinggi(timB), minTinggi(timB));
        System.out.printf("Tim B - Berat max: %d kg, Berat min: %d kg\n", maxBerat(timB), minBerat(timB));

        List<Pemain> timC = new ArrayList<>(); //copy semua pemain Tim B ke Tim C
        timC.addAll(timB);
        System.out.println("\n=== Tim C (copy dari Tim B) ===");
        timC.forEach(System.out::println);

        List<Integer> tinggiTimA = getListTinggi(timA); //buat list tinggi dan berat terpisah buat ngecek frekuensi
        List<Integer> beratTimA = getListBerat(timA);
        List<Integer> tinggiTimB = getListTinggi(timB);
        List<Integer> beratTimB = getListBerat(timB);

        Collections.sort(tinggiTimA);    //urutkan dulu biar frekuensi dan binary search jalan mulus
        Collections.sort(beratTimA);
        Collections.sort(tinggiTimB);
        Collections.sort(beratTimB);

        int freq168TimB = Collections.frequency(tinggiTimB, 168);  //cek berapa pemain Tim B yang tinggi 168 dan 160 cm
        int freq160TimB = Collections.frequency(tinggiTimB, 160);
        System.out.printf("\nTim B - Jumlah pemain tinggi 168 cm: %d\n", freq168TimB);
        System.out.printf("Tim B - Jumlah pemain tinggi 160 cm: %d\n", freq160TimB);

        int freq56TimA = Collections.frequency(beratTimA, 56); //cek berapa pemain Tim A yang berat 56 dan 53 kg
        int freq53TimA = Collections.frequency(beratTimA, 53);
        System.out.printf("Tim A - Jumlah pemain berat 56 kg: %d\n", freq56TimA);
        System.out.printf("Tim A - Jumlah pemain berat 53 kg: %d\n", freq53TimA);

        boolean adaTinggiSama = !Collections.disjoint(tinggiTimA, tinggiTimB); // Cck apakah ada pemain Tim A yang punya tinggi atau berat sama dengan Tim B
        boolean adaBeratSama = !Collections.disjoint(beratTimA, beratTimB);
        System.out.println("\nAda pemain dengan tinggi sama di Tim A & Tim B? " + (adaTinggiSama ? "Iya" : "Gak ada"));
        System.out.println("Ada pemain dengan berat sama di Tim A & Tim B? " + (adaBeratSama ? "Iya" : "Gak ada"));
    }

    private static int maxTinggi(List<Pemain> list) {  //cari tinggi maksimal di list pemain
        return list.stream().mapToInt(p -> p.tinggi).max().orElse(-1);
    }

    private static int minTinggi(List<Pemain> list) { //cari tinggi minimal di list pemain
        return list.stream().mapToInt(p -> p.tinggi).min().orElse(-1);
    }

    private static int maxBerat(List<Pemain> list) { //cari berat maksimal di list pemain
        return list.stream().mapToInt(p -> p.berat).max().orElse(-1);
    }

    private static int minBerat(List<Pemain> list) { //cari berat minimal di list pemain
        return list.stream().mapToInt(p -> p.berat).min().orElse(-1);
    }

    private static List<Integer> getListTinggi(List<Pemain> list) { //ambil semua tinggi dari list pemain ke list integer
        List<Integer> tinggi = new ArrayList<>();
        for (Pemain p : list) tinggi.add(p.tinggi);
        return tinggi;
    }
    
    private static List<Integer> getListBerat(List<Pemain> list) { //ambil semua berat dari list pemain ke list integer
        List<Integer> berat = new ArrayList<>();
        for (Pemain p : list) berat.add(p.berat);
        return berat;
    }
}

