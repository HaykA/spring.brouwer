package be.brouwers.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.brouwers.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Length(min = 3, max = 25)
	@SafeHtml
	private String naam;
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	private Integer omzet;
	@Valid
	@Embedded
	private Adres adres;
	
	public Brouwer() {}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Integer getOmzet() {
		return omzet;
	}
	
	public Adres getAdres() {
		return adres;
	}
	
	
}
