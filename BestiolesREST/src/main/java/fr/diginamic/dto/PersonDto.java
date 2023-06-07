package fr.diginamic.dto;

public class PersonDto {

	private int id;
	private String nomAge; // contiendra un string qui affiche « nom prénom (age) »
	// contiendra un tableau qui contient le nom de tous les animaux sous forme «
	// nom-animal (espèce-animal) »
	private String[] animaux;
	
	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nomAge
	 * @param animaux
	 */
	public PersonDto(int id, String nomAge, String[] animaux) {
		super();
		this.id = id;
		this.nomAge = nomAge;
		this.animaux = animaux;
	}
	
	// GETTER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAge() {
		return nomAge;
	}

	public void setNomAge(String nomAge) {
		this.nomAge = nomAge;
	}

	public String[] getAnimaux() {
		return animaux;
	}

	public void setAnimaux(String[] animaux) {
		this.animaux = animaux;
	}

	
	

}
