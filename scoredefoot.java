package scorefoot;

public class Score {
	char etat; //'a' à venir, 'e' en cours, 't' terminé
	  int butsEq1;
	  int butsEq2;
	  public Score(){
	    etat = 'a';
	    butsEq1=0;
	    butsEq2=0;
	  }
	  public char getStatut(){
	    return etat;
	  }
	  public  int getButsEquipe1(){
	    return butsEq1;
	  }
	  public   int getButsEquipe2(){
	    return butsEq2;
	  }
	  public  void butEquipe1(){
	    if (etat == 'e'){
	      butsEq1 = butsEq1+1;
	    }
	  }
	  public  void butEquipe2(){
	    butsEq2 = butsEq2+1;
	  }
	  public  String toString(){
	    return butsEq1 + ":" + butsEq2;
	  }
	  public void commencer(){
	    etat = 'c';
	  }
	  public void terminer(){
	    etat = 't';
	  }
	  public static void main(String[] args){
	    Score psg_om = new Score();
	    psg_om.commencer();
	    psg_om.butEquipe1();
	    System.out.println(psg_om.toString());
	  }

}
