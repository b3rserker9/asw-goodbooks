package asw.goodbooks.recensioniseguite.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/* Recensione. */
@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recensione implements Comparable<Recensione> {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id; 
	private String recensore; 
	private String titoloLibro; 
	private String autoreLibro; 
	private String testoRecensione;

	public Recensione(String recensore, String titoloLibro, String autoreLibro, String testoRecensione) {
		this();
		this.recensore = recensore;
		this.titoloLibro = titoloLibro;
		this.autoreLibro = autoreLibro;
		this.testoRecensione = testoRecensione;
	}

	@Override
	public int compareTo(Recensione other) {
		return this.id.compareTo(other.id); 
	}
	
}
