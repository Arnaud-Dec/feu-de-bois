import java.util.ArrayList;
import java.util.Random;

public class Controlleur {
    Vue vue = new Vue();
    public void start(ArrayList<bois> boisList, int h, int l, float propa){
        vue.afficherBois(boisList, h, l);


        Random rand = new Random();
        int l_depart = rand.nextInt(l);
        int h_depart = rand.nextInt(h);

        boisList.get(h_depart * l + l_depart).feu();
        vue.afficherBois(boisList, h, l);
        propagation(boisList, h, l, propa);

    }

    public void propagation(ArrayList<bois> boisList, int H, int L, float propa) {
        boolean feuExists = true;
        while (feuExists) {
            feuExists = false;
            Random rand = new Random();
            try {
                Thread.sleep(2000);
                ArrayList<bois> nouveauxFeux = new ArrayList<>();
                for (bois b : boisList) {
                    if (b.type == type_bois.feu) {
                        feuExists = true;
                        int h = b.h;
                        int l = b.l;
                        float Newpropa = propa * 100;
                        if (h > 0) {
                            if (boisList.get((h - 1) * L + l).getTypes() == type_bois.normal) {
                                if (rand.nextInt(100) + 1 < Newpropa) {
                                    nouveauxFeux.add(boisList.get((h - 1) * L + l));
                                }
                            }
                        }
                        if (h < H - 1) {
                            if (boisList.get((h + 1) * L + l).getTypes() == type_bois.normal) {
                                if (rand.nextInt(100) + 1 < Newpropa) {
                                    nouveauxFeux.add(boisList.get((h + 1) * L + l));
                                }
                            }
                        }
                        if (l > 0) {
                            if (boisList.get(h * L + (l - 1)).getTypes() == type_bois.normal) {
                                if (rand.nextInt(100) + 1 < Newpropa) {
                                    nouveauxFeux.add(boisList.get(h * L + (l - 1)));
                                }
                            }
                        }
                        if (l < L - 1) {
                            if (boisList.get(h * L + (l + 1)).getTypes() == type_bois.normal) {
                                if (rand.nextInt(100) + 1 < Newpropa) {
                                    nouveauxFeux.add(boisList.get(h * L + (l + 1)));
                                }
                            }
                        }
                        b.cendre(); // Convertir le bois en cendre après avoir propagé le feu
                    }
                }
                for (bois b : nouveauxFeux) {
                    b.feu(); // Allumer les nouveaux feux
                }
                vue.afficherBois(boisList, H, L);
                vue.afficherBois(boisList, H, L);
                if (!feuExists) {
                    System.out.println();
                    System.out.println("Le feu est éteint");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
