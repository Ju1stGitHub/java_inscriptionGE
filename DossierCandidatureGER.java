package inscriptionecole;

public class DossierCandidatureGER {
	  // Ici des attributs
	  String nomcandidat;
	  String numeroinsee;
	  String statut_encours="non enregistré";
	  Boolean signature = false;
	  Boolean presence_oral = true;
	  Boolean status_updatable = true;
	  int note_ecrit;
	  int note_oral;
	  // constructeur
	  public DossierCandidatureGER(String nom, String numero){
		  nomcandidat=nom;
		  numeroinsee=numero;
		  statut_encours="ENREGISTRE";
		  status_updatable=true;
	  }
	  public void enregistrerEmargementEpreuveEcrite(){
		  if(statut_encours.equals("ADMIS")) {
			  throw new IllegalStateException("le candidat est déjà admis");
		  }else {
			  signature=true;
			  statut_encours="EMARGE";
		  }
	  }
	  public void enregistrerNoteEpreuveEcrite(int note){
		  if(statut_encours.equals("ADMIS")) {
			  throw new IllegalStateException("le candidat est déjà admis");
		  }else {
			  if(signature) {
				  note_ecrit=note;
				  statut_encours="NOTE_ECRIT_TRANSMISE";
			  }else {
				  throw new IllegalStateException("signature manquante");
			  }
		  }
	  }
	  public void publierResultatEcrit(){
		  if(statut_encours.equals("ENREGISTRE")) {
			  throw new IllegalStateException("le candidat est seulement enregistré");
		  }else if(statut_encours.equals("ADMIS")){
			  throw new IllegalStateException("le candidat est déjà admis");
		  }else {
			  System.out.println("A l'épreuve écrite ;le candidat a obtenu la note de: "+note_ecrit);
			  if(note_ecrit<10) {
				  statut_encours="NON_ADMISSIBLE";
				  System.out.println("Désolé, vous avez raté votre épreuve d'admissibilité.");
			  }else {
				  System.out.println("Félicitations vous êtes admissible");
				  statut_encours="ADMISSIBLE";
			  }
		  }
	  }
	  public void enregistrerNoteEpreuveOrale(int note){
		  if(statut_encours.equals("ADMIS")) {
			  throw new IllegalStateException("le candidat est déjà admis");
		  }else {
			  if(note_ecrit>=10 && presence_oral) {
				  note_oral=note;
				  statut_encours="NOTE_ORAL_TRANSMISE";
			  }else {
			  throw new IllegalStateException("Le candidat n'était pas admissible ou était absent à l'épreuve orale.");
			  }
		  }
	  }
	  public void enregistrerAbsenceALOral(){
		  if(statut_encours.equals("ENREGISTRE")) {
			  throw new IllegalStateException("le candidat est seulement enregistré");
		  }else {
		  presence_oral=false;
		  }
	  }
	  public void publierResultatFinal(){
		  if(statut_encours.equals("ADMIS")) {
			  throw new IllegalStateException("le candidat est déjà admis");
		  }else {
			  if(!signature) {
				  //System.out.println("Vous ne vous êtes pas présenté aux épreuves écrites");
			  }else {
				  if(note_ecrit<10) {
					  //System.out.println("Désolé, vous avez raté votre épreuve d'admissibilité.");
				  }else {
					  if(!presence_oral) {
						  //System.out.println("Vous ne vous êtes pas présenté aux épreuves écrites");
					  }else {
						  if(note_oral<10) {
							  statut_encours="NON_ADMIS";
							  //System.out.println("Désolé, vous avez raté votre épreuve d'admission.");
						  }else {
							  statut_encours="ADMIS";
							  //System.out.println("Félicitations vous êtes admis!");
						  }
					  }
				  }
			  }
		  }
	  }
	  public String toString(){
		  String statut="Nom: "+nomcandidat+" Numéro INSEE: "+numeroinsee+" ";
		 //on souhaite compléter statut avec statut_encours et, le cas échéant, les notes.
		  if(status_updatable==true) {
			  switch(statut_encours) {
			  	case "ENREGISTRE": statut+="ENREGISTRE ! "; 
			  	case "EMARGE": statut+="EMARGE ! "; 
			  	case "NOTE_ECRIT_TRANSMISE": statut+="NOTE_ECRIT_TRANSMISE ! ";
		  		case "NON_ADMISSIBLE": statut+="Note écrit: "+note_ecrit+" "+"NON_ADMISSIBLE ! ";
		  		case "ADMISSIBLE": statut+="Note écrit: "+note_ecrit+" "+"ADMISSIBLE ! "; 
		  		case "NOTE_ORAL_TRANSMISE": statut+="Note écrit: "+note_ecrit+" "+"NOTE_ORAL_TRANSMISE ! "; 
		  		case "NON_ADMIS": statut+="Note écrit: "+note_ecrit+" "+"Note oral: "+note_oral+" NON_ADMIS ! "; ;
		  		case "ADMIS": statut+="Note écrit: "+note_ecrit+" "+"Note oral: "+note_oral+" ADMIS ! "; 
			  }
			  status_updatable=false;
			 
		  }else {
			  statut+="";
		  }
		  return statut;
	  }

	  public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
