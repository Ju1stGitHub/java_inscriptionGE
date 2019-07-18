package pokerdas;

public class pokerdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tirage = new int[5];
		for (int i=0; i<5; i++){
		    tirage[i] = (int) (Math.random()*6+1);
		}
		// ici on faisait les tests manuels de tirage
		/*tirage[0]=1;
		tirage[1]=2;
		tirage[2]=3;
		tirage[3]=5;
		tirage[4]=6;*/
		
		java.util.Arrays.sort(tirage);
		for (int i=0; i<5; i++){
		    System.out.print(tirage[i]+" ");
		}
		System.out.println();

		//reconnaitre le nombre de differences: on les compte via un int testeur
		int testeur = 0;
		for (int i=0; i<4; i++){
			if(tirage[i]!=tirage[i+1]) {
				testeur++;
			}
		}
		//Ici on controlait le compteur testeur
		//System.out.print("Le nombre de différences est :");
		//System.out.println(testeur);
		
		//On va aussi compter le nombre de fois ou les nombres se suivent on va aussi reperer ou ca arrete de suivre
		int testfollower=0;
		int pasfollow=0;
		for (int i=0; i<4; i++){
			int diff=0;
			diff = tirage[i+1]-tirage[i];
			if(diff == 1) {
				testfollower++;
			}else {
				pasfollow=i;
			}
		}
		//Ici on controlait le compteur testfollower
		//System.out.print("Le nombre de fois que les nombres se suivent est :");
		//System.out.println(testfollower);
		
		// si il y a zero difference on a un poker
		if(testeur == 0) {
			System.out.println("Vous avez un poker d'as!");
		}
		//si il y a une difference on a soit un carré soit un full
		if(testeur == 1) {
			if (tirage[1]==tirage[2] && tirage[2]==tirage[3]) {
				System.out.println("Vous avez un carré!");
			}else {
				System.out.println("Vous avez un full!");
			}
		}
		//si il y a deux differences on a un brelan ou une double paire
		if(testeur == 2) {
			if (tirage[0]==tirage[1] && tirage[1]==tirage[2]) {
				System.out.println("Vous avez un brelan!");
			}else {
				if(tirage[4]==tirage[3] && tirage[3]==tirage[2]) {
				System.out.println("Vous avez un brelan!");
				}
				else {
					if(tirage[2]==tirage[3] && tirage[1]==tirage[2]) {
						System.out.println("Vous avez un brelan!");
					}else {
						System.out.println("Vous avez une double paire!");
					}
				}
			}
		}
		//si il y a trois différences on a une petite suite ou une paire
		if(testeur == 3){
			if(testfollower==3) {
				if(pasfollow==0 || pasfollow==3) {
					System.out.println("Vous avez une petite suite!");
				}else {
					System.out.println("Vous n'avez RIEN!");
				}
			}else {
				System.out.println("Vous avez une paire!");
			}
		}	
		//Si il y a quatre différences on a une petite suite ou une grande suite ou rien
		if(testeur == 4){
			if(testfollower==4) {
				System.out.println("Vous avez une grande suite!");
			}else {
				if(pasfollow==0 || pasfollow==3) {
					System.out.println("Vous avez une petite suite!");
				}else {
					System.out.println("Vous n'avez RIEN!");
				}
			}
		}
		
	}

}
