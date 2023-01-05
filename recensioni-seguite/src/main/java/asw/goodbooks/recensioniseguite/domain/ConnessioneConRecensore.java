package asw.goodbooks.recensioniseguite.domain;

import lombok.*; 

@Data @NoArgsConstructor
public class ConnessioneConRecensore {

	private Long id; 
	private String utente; 
	private String recensore;

	public ConnessioneConRecensore(String utente, String recensore){
		this.utente = utente;
		this.recensore = recensore;
	}
	
}
