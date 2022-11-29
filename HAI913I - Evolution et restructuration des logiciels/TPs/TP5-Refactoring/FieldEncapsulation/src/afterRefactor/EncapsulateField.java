package afterRefactor;

/* 
 * Author : SANCHEZ Martin
 */

public class EncapsulateField {

	private int toto;
	
	public EncapsulateField(int t) {
		this.setToto(t); // this.toto = ??  || pas top 
	}

	/**
	 * @return the toto
	 */
	public int getToto() {
		return toto;
	}

	/**
	 * @param toto the toto to set
	 */
	public void setToto(int toto) {
		this.toto = toto;
	}
}
