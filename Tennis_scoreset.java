package tennis_score;


public class Tennis_scoreset {
	
		char etat;
		String scorefinal;
		//déclaration et initialisation du score. On commence par les jeux puis par les points
		String score[];
		String scoreinit[]={"0","-","0"," et ","0","-","0"};
		public Tennis_scoreset(){
		    etat = 'e';
		    score = scoreinit;
		    scorefinal="";
		  }
		
		public void j1marque() {
			if(etat=='e') {
			  //le cas où on doit ajouter 15 points
			  if(score[4].equals("15")) {
					  int j1points = Integer.parseInt(score[4]);
					  j1points = j1points + 15;
					  score[4] = Integer.toString(j1points);
			  }else if(score[4]=="0") {
				  int j1points = Integer.parseInt(score[4]);
				  j1points = j1points + 15;
				  score[4] = Integer.toString(j1points);  
			  }
			
			  // le cas où le joueur 1 est à 30 points.
			  else if(score[4].equals("30")) {
				  int j1points = Integer.parseInt(score[4]);
				  j1points += 10;
				  score[4] = Integer.toString(j1points);
			  }
			  //les trois cas où le joueur 1 est à 40 points.
			  
			  //On commence par le cas d'égalité
			  else if(score[4].equals("40") && score[6].equals("40")) {
				  score[4]="avantage joueur 1";
			  }
			  //le cas où le joueur 2 avait l'avantage
			  else if (score[4].equals("40") && score[6].equals("avantage joueur 2")) {
				  score [6]="40";
			  }
			  //le cas où le joueur 1 va gagner
			  else if(score[4].equals("40")) {
				  score[4]="0";
				  score[6]="0";
				  int j1jeux = Integer.parseInt(score[0]);
				  j1jeux += 1;
				  score[0] = Integer.toString(j1jeux);
				//on teste la clôture du match
				  if(score[0].equals("7")) {
					  etat='t';
				  }
				  if(score[0].equals("6") && !score[2].equals("6")) {
					  etat='t';
				  }
			  }
			  //le cas où le joueur 1 avait avantage
			  else if(score[4].equals("avantage joueur 1")) {
				  score[4]="0";
				  score[6]="0";
				  int j1jeux = Integer.parseInt(score[0]);
				  j1jeux += 1;
				  score[0] = Integer.toString(j1jeux);
				//on teste la clôture du match
				  if(score[0].equals("7")) {
					  etat='t';
				  }
				  if(score[0].equals("6") && !score[2].equals("6")) {
					  etat='t';
				  }
			  }
			}
		}
		
		public void j2marque() {
			if(etat=='e') {
			  //le cas où on doit ajouter 15 points
			  if(score[6].equals("0") || score[6].equals("15") ) {
				  int j2points = Integer.parseInt(score[6]);
				  j2points += 15;
				  score[6] = Integer.toString(j2points);
			  }
			  // le cas où le joueur 1 est à 30 points.
			  else if(score[6].equals("30")) {
				  int j2points = Integer.parseInt(score[6]);
				  j2points += 10;
				  score[6] = Integer.toString(j2points);
			  }
			  //les trois cas où le joueur 1 est à 40 points.
			  
			  //On commence par le cas d'égalité
			  else if(score[4].equals("40") && score[6].equals("40")) {
				  score[6]="avantage joueur 2";
			  }
			  //le cas où le joueur 1 avait l'avantage
			  else if (score[6].equals("40") && score[4].equals("avantage joueur 1")) {
				  score [4]="40";
			  }
			  //le cas où le joueur 2 va gagner
			  else if(score[6].equals("40") && score[4].equals("30") || score[6].equals("40") && score[4].equals("15") || score[6].equals("40") && score[4].equals("0")) {
				  score[4]="0";
				  score[6]="0";
				  int j2jeux = Integer.parseInt(score[2]);
				  j2jeux += 1;
				  score[2] = Integer.toString(j2jeux);
				//on teste la clôture du match
				  if(score[2].equals("7")) {
					  etat='t';
				  }
				  if(score[2].equals("6") && !score[0].equals("6")) {
					  etat='t';
				  }
			  }
			  //le cas où le joueur 2 avait avantage
			  else if(score[6].equals("avantage joueur 2")) {
				  score[4]="0";
				  score[6]="0";
				  int j2jeux = Integer.parseInt(score[2]);
				  j2jeux += 1;
				  score[2] = Integer.toString(j2jeux);
				  //on teste la clôture du match
				  if(score[2].equals("7")) {
					  etat='t';
				  }
				  if(score[2].equals("6") && !score[0].equals("6")) {
					  etat='t';
				  }
			  }
			}
		}		
		
		
		public void j1abandonne() {
			if(etat=='e') {
			  score[0] = "abandon joueur 1";
			  for(int i = 1; i < score.length; i++) {
				  score[i] = "";
			  }
			  etat='t';
			}
		}
		
		public void j2abandonne() {
			if(etat=='e') {
			  score[0] = "abandon joueur 2";
			  for(int i = 1; i < score.length; i++) {
				  score[i] = "";
			  }
			  etat='t';
			}
		}
		
		public String toString() {
			scorefinal = "";
			  for(int i = 0; i < score.length; i++) {
				  scorefinal += score[i];
			  }
			  return scorefinal;
		}
		public static void main(String[] args) {
			Tennis_scoreset test = new Tennis_scoreset();
			System.out.println(test.toString());
			for(int i = 0; i < 25; i++) {
			test.j1marque();
			System.out.println(test.toString());
			}			
		}
}
