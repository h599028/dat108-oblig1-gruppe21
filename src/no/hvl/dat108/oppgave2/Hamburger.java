package no.hvl.dat108.oppgave2;

public class Hamburger {
    int burgerNr;

    public Hamburger(int n) {
        burgerNr = n;
    }

    public String burgerToString() {
        char moonL = '◖';
        char moonR = '◗';
        String b = "" + moonL + burgerNr  +moonR;
        return b;
    }

}
