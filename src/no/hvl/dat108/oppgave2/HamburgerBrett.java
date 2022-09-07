package no.hvl.dat108.oppgave2;

public class HamburgerBrett {
    int kapasitet;
    int antall;
    int burgerNr = 1;
    int[] burgerQ;


    public HamburgerBrett(int kap) {
        kapasitet = kap;
        antall = 0;
        burgerQ = new int[kapasitet];
    }

    public void addBurger() {
        burgerQ[antall++] = burgerNr++;
    }

    public int takeBurger() {
        int burger = burgerQ[0];
        moveQueue();
        antall--;
        return burger;
    }

    private void moveQueue () {
        for (int i = 0; i < antall; i++) {
            burgerQ[i] = burgerQ[i+1];
        }
    }

    public void printBrett() {
        String str = "[";

        for (int i = 0; i < burgerQ.length - 1; i++) {
            str += burgerQ[i];
            str += ", ";
        }
        str+=burgerQ[burgerQ.length-1];
        str+="]";
        System.out.println(str);

    }
}
