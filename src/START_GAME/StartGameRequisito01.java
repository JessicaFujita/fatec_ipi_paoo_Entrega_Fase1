package START_GAME;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import warriors.*;
import warriors.Character;
import weapons.AxeBehavior;
import weapons.BowAndArrowBehavior;
import weapons.KnifeBehavior;
import weapons.SwordBehavior;


public class StartGameRequisito01 {
	// ################ MAIN PARA TESTE DO REQUISITO 01 DA PARTE 01 DO PROJETO ####################
	public static void main(String[] args) {
		int i;
		boolean trocar;
		Random random = new Random();
		List <Character> personagens = new ArrayList<>(4);
		Character p1 = new King();
		Character p2 = new Knight();
		Character p3 = new Queen();
		Character p4 = new Troll();
		personagens.add(p1);
		personagens.add(p2);
		personagens.add(p3);
		personagens.add(p4);
		
		
		p1.setWeaponbehavior(new SwordBehavior());
		p2.setWeaponbehavior(new KnifeBehavior());
		p3.setWeaponbehavior(new BowAndArrowBehavior());
		p4.setWeaponbehavior(new AxeBehavior());
		
		for (Character c: personagens) {
			System.out.println(c.getNome()+ " " + c.attack());
		}
		System.out.println("\n\n\n");
		
		for (Character c : personagens) {
			if(trocar = random.nextDouble() <= 0.25) {
				int weaponChoice = random.nextInt(4);
				System.out.println("Change weapon of " + c.getNome());
				switch (weaponChoice) {
				case 0:
					c.setWeaponbehavior(new AxeBehavior());
					break;
				case 1:
					c.setWeaponbehavior(new BowAndArrowBehavior());
					break;
				case 2:
					c.setWeaponbehavior(new KnifeBehavior());
					break;
				case 3:
					c.setWeaponbehavior(new SwordBehavior());
					break;
				}
			}			
		}		
		for (Character c: personagens) {
			System.out.println(c.getNome()+ " " + c.attack());
		}
	}

}
