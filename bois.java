public class bois {
    type_bois type;
    int h;
    int l;

    public bois( int h, int l) {
        this.type = type_bois.normal;
        this.h = h;
        this.l = l;
    }

    public void feu() {
        this.type = type_bois.feu;
    }

    public void cendre() {
        this.type = type_bois.cendre;
    }

    public type_bois getTypes(){
        return this.type;
    }

}
