package inscriptionecole;

public class DossierCandidatureGER {
	  // Ici des attributs
	  String nomcandidat;
	  String numeroinsee;
	  String statut_encours="non enregistré";
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
			  throw new IllegalStateException("le candidat est seulement enregistré");
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
		  if(note_ecrit>=10 && presence_oral) {
		  note_oral=note;
		  statut_encours="NOTE_ORAL_TRANSMISE";
		  }else {
			  throw new IllegalStateException("Le candidat n'était pas admissible ou était absent à l'épreuve orale.");
		  }
	  }
	  public void enregistrerAbsenceALOral(){
		  presence_oral=false;
	  }
	  public void publierResultatFinal(){
		  if(!signature) {
			  System.out.println("Vous ne vous êtes pas présenté aux épreuves écrites");
		  }else {
			  if(note_ecrit<10) {
				  System.out.println("Désolé, vous avez raté votre épreuve d'admissibilité.");
			  }else {
				  if(!presence_oral) {
					  System.out.println("Vous ne vous êtes pas présenté aux épreuves écrites");
				  }else {
					  if(note_oral<10) {
						  statut_encours="NON_ADMIS";
						  System.out.println("Désolé, vous avez raté votre épreuve d'admission.");
					  }else {
						  statut_encours="ADMIS";
						  System.out.println("Félicitations vous êtes admis!");
					  }
				  }
			  }
		  }
	  }
	public String toString() {
   		 String noteEcrit = signature ? " Note écrit: "+note_ecrit + " " : StringUtils.EMPTY;
		  String noteOral = presence_oral ? " Note oral: "+note_oral + " ": StringUtils.EMPTY;
 	 	  return String.format( "Nom : %s Numéro INSEE: %s%s%s %s",nomcandidat,numeroinsee,noteEcrit,noteOral,statut_encours)
	}

	  public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
