package asw.goodbooks.recensioniseguite.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @NoArgsConstructor
@Entity
public class ConnessioneConRecensore {

	@Id
	@GeneratedValue
	private Long id; 
	private String utente; 
	private String recensore;

	public ConnessioneConRecensore(String utente, String recensore) {
		this.utente = utente;
		this.recensore = recensore;
	}
}
