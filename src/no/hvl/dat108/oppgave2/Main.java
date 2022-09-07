package no.hvl.dat108.oppgave2;

public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        int kapasitet = 6;

        skrivUtHeader(kokker, servitorer, kapasitet);

        HamburgerBrett brett = new HamburgerBrett(kapasitet);

        for (String navn : kokker) {
            new Kokk(navn, brett).start();
        }
        for (String navn : servitorer) {
            new Servitor(navn, brett).start();
        }
    }

     static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.printf("I denne simuleringen har vi %d kokker %s %d servitører %s Kapasiteten til brettet er %d hamburgere. ", kokker.length, arrToString(kokker), servitorer.length, arrToString(servitorer), kapasitet);
    }

    private static String arrToString(String[] arr) {
        String str = "[";

        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i];
            str += ", ";
        }
        str+=arr[arr.length-1];
        str+="]";
        return str;
    }
}
