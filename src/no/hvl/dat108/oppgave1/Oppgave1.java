package no.hvl.dat108.oppgave1;

import javax.swing.*;

public class Oppgave1  {
    public static void main(String[] args) throws InterruptedException {

        Thread tPrint = new Thread("") {
            @Override
            public void run() {
                while(!getName().equals("quit")) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread tRead = new Thread() {
            @Override
            public void run() {
                String text = "";
                while(!text.equals("quit")) {
                    text = JOptionPane.showInputDialog("Skriv inn melding. Skriv quit for å slutte");
                    tPrint.setName(text);
                    if (!tPrint.isAlive()) {
                        tPrint.start();
                    }
                }
            }
        };

        tRead.start();

    }
}
