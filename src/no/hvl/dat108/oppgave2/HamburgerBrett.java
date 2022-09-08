package no.hvl.dat108.oppgave2;

public class HamburgerBrett {
    int kapasitet;
    public int antall;
    int burgerNr = 1;
    Hamburger[] burgerQ;

    public synchronized int nextNr() {
        return burgerNr++;
    }

    public HamburgerBrett(int kap) {
        kapasitet = kap;
        antall = 0;
        burgerQ = new Hamburger[kapasitet];
    }

    public synchronized void addBurger(Hamburger ham) {
        while (full()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.print(e.getMessage());
            }
        }

        burgerQ[antall++] = ham;
        notifyAll();
    }

    public synchronized Hamburger takeBurger() {
        while (empty()) {
            try {
                wait();
            } catch (InterruptedException e) {

                System.out.print(e.getMessage());
            }
        }
        Hamburger burger = burgerQ[0];
        moveQueue();
        antall--;
        notifyAll();
        return burger;
    }

    private void moveQueue() {
        for (int i = 0; i < antall; i++) {
            if (i + 1 < antall) {
                burgerQ[i] = burgerQ[i + 1];
            } else {
                burgerQ[i] = null;
            }
        }
    }

    public String toStringBrett() {
        String str = "[";

        for (int i = 0; i < antall - 1; i++) {
            str += burgerQ[i].burgerToString();
            str += ", ";
        }
        if (antall - 1 >= 0) {
            str += burgerQ[antall - 1].burgerToString();
        }
        str += "]";
        return str;

    }

    public boolean empty() {
        if (antall == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean full() {
        if (antall == kapasitet) {
            return true;
        } else {
            return false;
        }
    }
}
