package warriors;

public class King extends Character {
	public King() {
		setNome("King");
	}
	@Override
	
	public String attack() {
//		System.out.print(this.getNome() + ": " );
		return "com " + this.weaponbehavior.useWeapon();	
	}
}
