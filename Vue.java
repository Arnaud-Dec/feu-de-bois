import java.util.ArrayList;


public class Vue {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GRAY = "\u001B[37m";

    public void afficherBois(ArrayList<bois> boisList, int h, int l) {
        int index = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                bois b = boisList.get(index++);
                if (b.type == type_bois.feu) {
                    System.out.print(ANSI_ORANGE + " [F] " + ANSI_RESET);
                } else if (b.type == type_bois.cendre) {
                    System.out.print(ANSI_GRAY + " [C] " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_GREEN + " [N] " + ANSI_RESET);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
