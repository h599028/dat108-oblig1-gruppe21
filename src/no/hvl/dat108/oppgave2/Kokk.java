package no.hvl.dat108.oppgave2;

import java.util.Random;

public class Kokk extends Thread {
    String navn;
    HamburgerBrett brett;

    Random rand = new Random(741209124);

    Kokk(String navn, HamburgerBrett brett) {
        this.navn = navn;
        this.brett = brett;
    }

    @Override
    public void run() {
        boolean stop = false;
        while (!stop) {
            int waitTime = rand.nextInt(10) + 2;
            Hamburger hamb = new Hamburger(brett.nextNr());
            synchronized (brett) {
                if (brett.full()) {
                    System.out.print(navn + " (Kokk) klar med hamburger, men brett er fullt. Venter! \n");
                }
                brett.addBurger(hamb);
                System.out.print(navn + " (Kokk) legger på hamburger " + hamb.burgerToString() + ". Brett: "
                        + brett.toStringBrett() + "\n");
            }
            try {
                Thread.sleep(waitTime * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
