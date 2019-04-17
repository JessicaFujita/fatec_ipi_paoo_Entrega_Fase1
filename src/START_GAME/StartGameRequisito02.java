package START_GAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import battle.Fight;
import warriors.Character;
import warriors.*;
import weapons.*;

public class StartGameRequisito02 {
	//######### MAIN PARA TESTE DO REQUISITO 02 DA PARTE 01 DO PORJETO
	public static void main(String[] args) {
		List <Fight> fight = new ArrayList <>();
		Random gerador = new Random();
		Character winner;
		Character semiFinalista = null;
		int round = 0;
		for (int i = 0 ; i < 10 ; i++) {
			int p1 = gerador.nextInt(4);
			Character f1 = null, f2 = null;			
			switch(p1) {
				case 0:
					f1 = new King();
					break;
				case 1:
					f1 = new Knight();
					break;
				case 2:
					f1 = new Queen();
					break;
				case 3:
					f1 = new Troll();
					break;
			}			
			int p2 = gerador.nextInt(4);
			switch(p2) {
				case 0:
					f2 = new King();
					break;
				case 1:
					f2 = new Knight();
					break;
				case 2:
					f2 = new Queen();
					break;
				case 3:
					f2 = new Troll();
					break;
			}
			fight.add(new Fight(f1, f2));
		}
		for(Fight f : fight) {
			int weaponP1 = gerador.nextInt(4);
			switch (weaponP1) {
			case 0:
				f.getFighter01().setWeaponbehavior(new AxeBehavior());
				break;
			case 1:
				f.getFighter01().setWeaponbehavior(new BowAndArrowBehavior());
				break;
			case 2:
				f.getFighter01().setWeaponbehavior(new KnifeBehavior());
				break;
			case 3:
				f.getFighter01().setWeaponbehavior(new SwordBehavior());
				break;
			}
			int weaponP2 = gerador.nextInt(4);
			switch (weaponP2) {
			case 0:
				f.getFighter02().setWeaponbehavior(new AxeBehavior());
				break;
			case 1:
				f.getFighter02().setWeaponbehavior(new BowAndArrowBehavior());
				break;
			case 2:
				f.getFighter02().setWeaponbehavior(new KnifeBehavior());
				break;
			case 3:
				f.getFighter02().setWeaponbehavior(new SwordBehavior());
				break;
			}
		}
		
		//Start battle here
		for(int i=0; i<5; i++) {
			Character p1 = null, p2 = null;
			List <Fight> results = new ArrayList <> ();
			int cont = 0;
			for(Fight f : fight) {
					cont++;
					System.out.println("-----------------------------------------------------------------------");
					System.out.println("\nBattle: " + cont + " - " + f.whosBattle() +"\n");
					System.out.println("-----------------------[Description Battle]---------------------------\n");
					while(f.checkBattle()) {
						boolean whoAttack = gerador.nextDouble() <= 0.5;
						if(whoAttack) {
							f.fighter01Attack();
						}
						else {
							f.fighter02Attack();
						}
					}
					System.out.println("\n**************************************************");
					System.out.println("Winner:" + f.whoWins().getNome()+ "\n");
					System.out.println("****************************************************");
					winner = f.whoWins();
					if(i == 1) {
						if(cont == 5) {
							semiFinalista = f.whoWins();
						}
						else {
							if(round == 0) {
								p1 = winner;
								p1.setVida(1);
								round = 1;
							}
							else {
								p2 = winner;
								p2.setVida(1);
								round= 0;
								results.add(new Fight(p1, p2));
							}
						}
					}
					else {
						
						if(i == 3) {
							if(round == 0) {
								p1 = winner;
								p1.setVida(1);
								p2 = semiFinalista;
								p2.setVida(1);
								round= 0;
								results.add(new Fight(p1, p2));
							}
						}
						else {
							if(round == 0) {
								p1 = winner;
								p1.setVida(1);
								round = 1;
							}
							else {
								p2 = winner;
								p2.setVida(1);
								round= 0;
								results.add(new Fight(p1, p2));
							}
						}
						
					}

					System.out.println("////////////////////////////////////////////////////\n\n");

				}
				fight = results;
				System.out.println("\n*****************************************************");
				if(i==4) {
					System.out.println("\n-------------------------------------------------");
					System.out.println("\nCampeão: " + p1.getNome());
					System.out.println("\n-------------------------------------------------");
				}
			}
		}		
}


