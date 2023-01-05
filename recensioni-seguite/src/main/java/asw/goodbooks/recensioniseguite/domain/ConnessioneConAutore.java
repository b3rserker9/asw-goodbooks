package asw.goodbooks.recensioniseguite.domain;

import lombok.*; 

@Data @NoArgsConstructor
public class ConnessioneConAutore {

	private Long id; 
	private String utente; 
	private String autore; 

	public ConnessioneConAutore(String utente, String autore){
		this.utente = utente;
		this.autore = autore;
	}
}
