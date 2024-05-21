import Controlleur.Controlleur;
import Modele.bois;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final String FILE_NAME = "input.txt";

    private float propa = 0;
    private int l = 0;
    private int h = 0;

    public void readFromFile() {
        try {
            File inputFile = new File(FILE_NAME);
            Scanner scanner = new Scanner(inputFile);

            for (int i = 0; i < 3; i++) {
                String data = scanner.nextLine();
                String[] part = data.split(":");
                if (i == 0){
                    h = Integer.parseInt(part[1]);
                } else if (i == 1){
                    l = Integer.parseInt(part[1]);
                } else if (i == 2){
                    propa = Float.parseFloat(part[1]);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readFromFile();
        System.out.println("h: " + main.h);
        System.out.println("l: " + main.l);
        System.out.println("propa: " + main.propa);
        System.out.println();

        ArrayList<bois> boisList = new ArrayList<bois>();

        for (int i = 0; i < main.h; i++) {
            for (int j = 0; j < main.l; j++) {
                boisList.add(new bois(i, j));
            }
        }

        Controlleur controlleur = new Controlleur();
        controlleur.start(boisList, main.h, main.l, main.propa);


    }


}