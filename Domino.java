
//La classe Domino represente un domino sous la forme d'un couple d'entiers.
public class Domino {
	//l'ordre a une importance on parlera du nombre de gauche et du nombre de droite
	int nombreg;
	int nombred;
	
	
	//le constructeur
	public Domino(int n1, int n2){
		this.nombreg = n1;
		this.nombred = n2;
	}

	public int getNbGauche() {
		return this.nombreg;
	}
	
	public int getNbDroit() {
		return this.nombred;
	}
	
	//une methode retournant le domino
	public void retourne() {
		int nbd = this.nombred;
		int nbg = this.nombreg;
		this.nombred = nbg;
		this.nombreg = nbd;
	}
	
	//une methode qui regarde si notre domino peut suivre un domino en argument
	public boolean peutSuivre(Domino dd) {
		if(dd.nombred == this.nombred || dd.nombred == this.nombreg) {
			return true;
		}else {
			return false;
		}
	}
	// meme principe mais pour preceder un domino
	public boolean peutPreceder(Domino dd) {
		if(dd.nombreg == this.nombred || dd.nombreg == this.nombreg) {
			return true;
		}else {
			return false;
		}
	}
	//le toString qui affiche le domino du genre (3,4)
	public String toString() {
		return String.format( "(%d,%d)",this.nombreg, this.nombred);
	}
}

