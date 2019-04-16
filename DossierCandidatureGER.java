package inscriptionecole;

public class DossierCandidatureGER {
	  // Ici des attributs
	  String nomcandidat;
	  String numeroinsee;
	  String statut_encours="non enregistr�";
	  Boolean signature = false;
	  Boolean presence_oral = true;
	  int note_ecrit;
	  int note_oral;
	  // constructeur
	  public DossierCandidatureGER(String nom, String numero){
		  nomcandidat=nom;
		  numeroinsee=numero;
		  statut_encours="ENREGISTRE";
	  }
	  public void enregistrerEmargementEpreuveEcrite(){
		  signature=true;
		  statut_encours="EMARGE";
	  }
	  public void enregistrerNoteEpreuveEcrite(int note){
		  if(signature) {
			  note_ecrit=note;
			  statut_encours="NOTE_ECRIT_TRANSMISE";
		  }else {
			  throw new IllegalStateException("signature manquante");
		  }
	  }
	  public void publierResultatEcrit(){
		  if(statut_encours.equals("ENREGISTRE")) {
			  throw new IllegalStateException("le candidat est seulement enregistr�");
		  }else {
			  System.out.println("A l'�preuve �crite ;le candidat a obtenu la note de: "+note_ecrit);
			  if(note_ecrit<10) {
				  statut_encours="NON_ADMISSIBLE";
				  System.out.println("D�sol�, vous avez rat� votre �preuve d'admissibilit�.");
			  }else {
				  System.out.println("F�licitations vous �tes admissible");
				  statut_encours="ADMISSIBLE";
			  }
		  }
	  }
	  public void enregistrerNoteEpreuveOrale(int note){
		  if(note_ecrit>=10 && presence_oral) {
		  note_oral=note;
		  statut_encours="NOTE_ORAL_TRANSMISE";
		  }else {
			  throw new IllegalStateException("Le candidat n'�tait pas admissible ou �tait absent � l'�preuve orale.");
		  }
	  }
	  public void enregistrerAbsenceALOral(){
		  presence_oral=false;
	  }
	  public void publierResultatFinal(){
		  if(!signature) {
			  System.out.println("Vous ne vous �tes pas pr�sent� aux �preuves �crites");
		  }else {
			  if(note_ecrit<10) {
				  System.out.println("D�sol�, vous avez rat� votre �preuve d'admissibilit�.");
			  }else {
				  if(!presence_oral) {
					  System.out.println("Vous ne vous �tes pas pr�sent� aux �preuves �crites");
				  }else {
					  if(note_oral<10) {
						  statut_encours="NON_ADMIS";
						  System.out.println("D�sol�, vous avez rat� votre �preuve d'admission.");
					  }else {
						  statut_encours="ADMIS";
						  System.out.println("F�licitations vous �tes admis!");
					  }
				  }
			  }
		  }
	  }
	  public String toString(){
		  String statut="Nom: "+nomcandidat+" Num�ro INSEE: "+numeroinsee+" ";
		 //on souhaite compl�ter statut avec statut_encours et, le cas �ch�ant, les notes.
		  switch(statut_encours) {
		  case "ENREGISTRE": statut+="ENREGISTRE";
		  case "EMARGE": statut+="EMARGE";
		  case "NOTE_ECRIT_TRANSMISE": statut+="NOTE_ECRIT_TRANSMISE";
		  case "NON_ADMISSIBLE": statut+="Note �crit: "+note_ecrit+" "+"NON_ADMISSIBLE";
		  case "ADMISSIBLE": statut+="Note �crit: "+note_ecrit+" "+"ADMISSIBLE";
		  case "NOTE_ORAL_TRANSMISE": statut+="Note �crit: "+note_ecrit+" "+"NOTE_ORAL_TRANSMISE";
		  case "NON_ADMIS": statut+="Note �crit: "+note_ecrit+" "+"Note oral: "+note_oral+" NON_ADMIS";
		  case "ADMIS": statut+="Note �crit: "+note_ecrit+" "+"Note oral: "+note_oral+" ADMIS";
		  }
		
		  return statut;
		  
	  }

	  public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
