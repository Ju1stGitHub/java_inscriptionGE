import java.util.ArrayList;

class SequenceDominos{
	ArrayList<Domino> dominolist = new ArrayList<Domino>();
	public SequenceDominos(Domino d) {
		dominolist.add(d);
	}
	public int valeurAGauche() {
		return (this.dominolist.get(0)).nombreg;
	}
	public int valeurADroite() {
		return (this.dominolist.get(this.dominolist.size()-1).nombred);
	}
	//la methode qui ajoute un domino a gauche
	public Domino ajouterAGauche(Domino d) {
		if(d.getNbDroit()==(this.dominolist.get(0)).nombreg) {
			//avant de parcourir la arraylist pour la maj on cree un domino save pour garder la valeur qu'on va ecraser
			Domino dsave;
			//on cree aussi un domino new qui va remplacer le contenu de la case
			Domino dnew = d;
			//la boucle qui parcourt notre arraylist
			for(int i=0; i<this.dominolist.size()-1; i++) {
				//on realise la sauvegarde de la case i
				dsave=this.dominolist.get(i);
				//la case i recoit sa nouvelle valeur
				this.dominolist.set(i, dnew);
				//la sauvegarde sera la valeur a affecter a la prochaine atape
				dnew=dsave;
			}
			//a la fin du processus il reste a ajouter notre dernier dnew a notre tableau
			this.dominolist.add(dnew);
			return d;
		}else {
			d.retourne();
			if(d.getNbDroit()==(this.dominolist.get(0)).nombreg) {
				//avant de parcourir la arraylist pour la maj on cree un domino save pour garder la valeur qu'on va ecraser
				Domino dsave;
				//on cree aussi un domino new qui va remplacer le contenu de la case
				Domino dnew = d;
				//la boucle qui parcourt notre arraylist
				for(int i=0; i<this.dominolist.size()-1; i++) {
					//on realise la sauvegarde de la case i
					dsave=this.dominolist.get(i);
					//la case i recoit sa nouvelle valeur
					this.dominolist.set(i, dnew);
					//la sauvegarde sera la valeur a affecter a la prochaine atape
					dnew=dsave;
				}
				//a la fin du processus il reste a ajouter notre dernier dnew a notre tableau
				this.dominolist.add(dnew);
				return d;
			}else {
				throw new IllegalStateException("les valeurs ne correspondent pas");
			}
		}
	}
	//la methode assez simple qui ajoute un domino a droite
	public Domino ajouterADroite(Domino d) {
		if(d.getNbGauche()==this.valeurADroite()) {
			this.dominolist.add(d);
			return d;
		}else {
			d.retourne();
			if(d.getNbGauche()==this.valeurADroite()) {
				this.dominolist.add(d);
				return d;
			}else {
			throw new IllegalStateException("les valeurs ne correspondent pas");
			}
		}
	}
	//la methode toString
	public String toString() {
		String listedominos="";
		for(int i=0; i<this.dominolist.size()-1; i++) {
			listedominos += (this.dominolist.get(i)).toString();
		}
		return listedominos;
	}
}