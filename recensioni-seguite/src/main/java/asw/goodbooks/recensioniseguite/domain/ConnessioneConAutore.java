package asw.goodbooks.recensioniseguite.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @NoArgsConstructor
@Entity
public class ConnessioneConAutore {
	@Id
	@GeneratedValue
	private Long id; 
	private String utente; 
	private String autore; 

	public ConnessioneConAutore(String utente, String autore){
		this.utente = utente;
		this.autore = autore;
	}
}
