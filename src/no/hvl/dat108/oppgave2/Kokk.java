package no.hvl.dat108.oppgave2;

import java.util.Random;

public class Kokk extends Thread {
    String navn;
    HamburgerBrett brett;

    Random rand = new Random(741209124);


    Kokk(String navn,  HamburgerBrett brett) {
        this.navn = navn;
        this.brett = brett;
    }

    @Override
    public void run() {
        boolean stop = false;
        while (!stop) {
            int waitTime = rand.nextInt(5)+2;
            brett.addBurger();
            try {
                Thread.sleep(waitTime * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            brett.printBrett();
        }
    }
}
