//This class holds all the attributes and their getters and setters to be used in other classes
package ie.cct.farm.farm;

public class Animal {

	// Variables used in the Animal object
	private String animalType;
	private float weight;
	private float minimumWeightCow = 300f;
	private float minimumWeightChicken = 0.5f;
	private float minimumWeightPig = 100f;
	private int value;

	// Empty constructor
	public Animal() {

	}

	// Constructor using field attributes
	public Animal(String animalType, float weight, int value) {
		super();
		this.animalType = animalType;
		this.weight = weight;
		this.value = value;
	}

	// Setters and Getter from all the attributes
	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public float getMinimumWeightCow() {
		return minimumWeightCow;
	}

	public void setMinimumWeightCow(float minimumWeightCow) {
		this.minimumWeightCow = minimumWeightCow;
	}

	public float getMinimumWeightChicken() {
		return minimumWeightChicken;
	}

	public void setMinimumWeightChicken(float minimumWeighChicken) {
		this.minimumWeightChicken = minimumWeighChicken;
	}

	public float getMinimumWeightPig() {
		return minimumWeightPig;
	}

	public void setMinimumWeightPig(float minimumWeighPig) {
		this.minimumWeightPig = minimumWeighPig;
	}

}
