import java.util.Scanner;

public class mastermindJessyMenneboo {

		static String [] TAB_REF_COLORS = {
				"rouge", 
				"jaune", 
				"vert", 
				"bleu", 
				"orange", 
				"blanc", 
				"violet", 
				"fuchsia" 
		};
		
		static int NB_COLORS = 4;

		public static void main(String[] args) {
			// Pour utiliser generateRandomCombination, il suffit de recupérer le tableau de couleurs généré. 
			String [] combinaisonSecrete = generateRandomCombination(), tabColors = new String [NB_COLORS];
			boolean uniColors = false, winner = false;
			int maxTry=0, goodPlace=0, colorsPlace =0, notInTab =4;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Bienvenue dans MasterMind !");
			System.out.println("Trouvez la combinaison secrète de 4 couleurs parmi les 8 proposées en 12 essais ou moins. Attention à l'orthographe des couleurs !");
			System.out.println("Bonne chance !");
		do {
			do {
				System.out.println("Choisissez 4 couleurs différentes parmi les 8 suivantes : ");
				for (int i=0;i<TAB_REF_COLORS.length;i++) {
					System.out.print(TAB_REF_COLORS[i] + " | ");
				}
				System.out.println();
				for (int i =0; i<tabColors.length;i++) {
					tabColors[i]=sc.nextLine();
				}
				if (tabColors[0].equals(tabColors[1]) ||tabColors[0].equals(tabColors[2])||tabColors[0].equals(tabColors[3])||tabColors[1].equals(tabColors[2])||tabColors[1].equals(tabColors[3])|| tabColors[2].equals(tabColors[3])) {
					uniColors=false;
				}else {
					uniColors=true;
				}
			}while (!uniColors);
			for (int i =0;i<tabColors.length;i++){
				if (tabColors[i].equals(combinaisonSecrete[i])) {
							goodPlace = (goodPlace +1);
				}
			}
				if (goodPlace==4) {
						winner=true;
						System.out.println("Bravo vous avez gagné ! La bonne combinaison était :");
						for(int i=0;i<4;i++) {
							System.out.println(combinaisonSecrete[i]);
						}
				} else {
			for (int i = 0; i<combinaisonSecrete.length;i++) {
					if (combinaisonSecrete[i].contains(tabColors[0])) {
					notInTab = (notInTab-1);
					}
					if (combinaisonSecrete[i].contains(tabColors[1])) {
						notInTab = (notInTab-1);
						}
					if (combinaisonSecrete[i].contains(tabColors[2])) {
						notInTab = (notInTab-1);
						}
					if (combinaisonSecrete[i].contains(tabColors[3])) {
						notInTab = (notInTab-1);
						}
			}		
					colorsPlace =(NB_COLORS-(goodPlace+notInTab));
					System.out.println("Il y a "+ goodPlace + " couleur(s) bien(s) placée(s)"+" et "+colorsPlace+" couleur(s) mal placée(s)");
			}
					goodPlace=0;
					colorsPlace=0;
					notInTab=4;
					maxTry++;
				if (maxTry<12 && !winner) {
				System.out.println("Il vous reste "+(12-maxTry)+" essais! ");
				}
				if (maxTry==12) {
				System.out.println("Vous avez utilisé vos 12 essais, désolé vous avez perdu ! La bonne combinaison était :");
				for(int i=0;i<4;i++) {
					System.out.println(combinaisonSecrete[i]);
				}
				winner=true;
				}
			}while(!winner && maxTry<12);
			sc.close();
		}
	
		// Generate random combination of 4 colors 
		static String [] generateRandomCombination() {
			String [] combination = new String[NB_COLORS];
			int currentPosition = 0;
			while(currentPosition!=NB_COLORS) {
				int indexRandom = (int)(Math.random()*TAB_REF_COLORS.length);
				String color = TAB_REF_COLORS[indexRandom];
				if(!isIn(color, combination)) {
					combination[currentPosition] = color;
					currentPosition++;
				}
			}
			return combination;
		}
		static boolean isIn(String iStringToFind, String [] iTab) {
			int size = iTab.length;
			for(int i=0;i<size;i++) {
				if(iStringToFind.equalsIgnoreCase(iTab[i])) return true;
			}
			return false;
		}
	}

		