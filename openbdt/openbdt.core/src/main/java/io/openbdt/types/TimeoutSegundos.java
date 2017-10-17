package io.openbdt.types;

/**
 * 
 * Enum para disponibilizar tempos em timeout utilizados com maior frequencia
 *
 */
public enum TimeoutSegundos {

	CINCO_SEGUNDOS(5),
	
	DEZ_SEGUNDOS(10),
	
	QUINZE_SEGUNDOS(15),
	
	VINTE_SEGUNDOS(20),
	
	TRINTA_SEGUNDOS(30),
	
	QUARENTA_SEGUNDOS(40),
	
	CINQUENTA_SEGUNDOS(50),
	
	SESSENTA_SEGUNDOS(60);
	
	private int timeout;
	
	private static final int _1000 = 1000;
	
	private TimeoutSegundos(final int timeout) {
		this.timeout = timeout;
	}
	
	/**
	 * Get timeout em segundos
	 * 
	 * @return int
	 */
	public int getTimeoutSegundos() {
		return this.timeout;
	}
	
	/**
	 * Get timeout em milisegundos
	 * 
	 * @return int
	 */
	public int getTimeoutMilisegundos() {
		return this.timeout*_1000;
	}
}
