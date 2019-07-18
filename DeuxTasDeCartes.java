package tasdecartes;



class Carte{
    String valeur, couleur;
    public Carte(String val, String coul){
        int i;
        String[] valeursOk = {"as", "sept", "huit", "neuf", "dix", "valet",
                           "dame", "roi"};
        String[] couleursOk = {"pique", "coeur", "carreau", "trefle"};
        i=0;
        while (i < valeursOk.length && val.compareTo (valeursOk[i]) != 0)
            i++;
        if (i == valeursOk.length)
            throw new IllegalArgumentException();
        i=0;
        while (i < couleursOk.length && coul.compareTo (couleursOk[i]) != 0)
            i++;
        if (i == couleursOk.length)
            throw new IllegalArgumentException(); 

        valeur = val;
        couleur = coul;
    }
    public String toString(){
        return valeur + " de " + couleur;
    }
    public String getValeur(){
        return valeur;
    }
    public String getCouleur(){
        return couleur;
    }
    public boolean equals(Carte carte){
        return valeur.equals(carte.getValeur()) && 
            couleur.equals(carte.getCouleur());
    }
}



public class DeuxTasDeCartes {
	Carte[] tab1, tab2;
    public DeuxTasDeCartes(Carte[] t1, Carte[] t2){
        tab1 = t1;
        tab2 = t2;
    }
    public boolean t1ContientCarte(Carte d){
    	int i;
    	boolean temoin = false;
    	for(i=0;i<tab1.length;i++) {
    		if(tab1[i].equals(d)) {
    			temoin=true;
    		}
    	}
    	return temoin;
    }
    
    public boolean t1ContientObjet(Carte d){
    	int i;
    	boolean temoin = false;
    	for(i=0;i<tab1.length;i++) {
    		if(tab1[i]==d) {
    			temoin=true;
    		}
    	}
    	return temoin;
    }
    public int compteCartesCommunes(Carte[] t1, Carte[] t2){
    	int i,j;
    	tab1 = t1;
        tab2 = t2;
    	int compteur = 0;
    	for(i=0;i<tab1.length;i++) {
    		for(j=0;j<tab1.length;j++) {
    			if(tab1[i].equals(tab2[j])) {
        			compteur+=1;
        		}
    		}
    			
    	}
    	return compteur;
    }
    
    public int compteObjetsCommuns(Carte[] t1, Carte[] t2){
    	int i,j;
    	int compteur = 0;
    	tab1 = t1;
        tab2 = t2;
        for(i=0;i<tab1.length;i++) {
    		for(j=0;j<tab1.length;j++) {
    			if(tab1[i].equals(tab2[j])) {
        			compteur+=1;
        		}
    		}	
    	}
    	return compteur;
    }
    
    public String toString(){
        String res = "t1: ";
        for (int i=0; i<tab1.length; i++){
            res = res + tab1[i].toString() + ", ";
        }
        res = res + "\nt2: ";
        for (int i=0; i<tab2.length; i++){
            res = res + tab2[i].toString() + ", ";
        } 
        res = res + "\n";
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
