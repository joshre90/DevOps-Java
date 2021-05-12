//This class determines which animals can be sell at the moment of they have the requirements needed
package ie.cct.farm.farm;

import java.util.ArrayList;

public class SellAnimals {

	// Variables used to do the math
	int cowCounter, chickenCounter, pigCounter;
	int totalCow, totalChicken, totalPig;
	double totalCowValue, totalChickenValue, totalPigValue;

	// Variable used to send back the message to user and its getters and setters
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Constructor of the class
	public SellAnimals(ArrayList<Animal> animals) {

		// Checks if the Array is not empty
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm");
		}

		// Loop that go through every object in the array
		for (Animal animal : animals) {

			// Condition that looks for 'cow', if it finds a cow it will increment by 1 the
			// totalCow Counter, same with respective animals
			if ((animal.getAnimalType()).equalsIgnoreCase("cow")) {
				totalCow++;
				// Condition that checks if the a cow weight the same or more as the minimum
				// amount required. If so it increases the cow counter by one.
				if (animal.getWeight() >= animal.getMinimumWeightCow()) {
					cowCounter++;
				}
			} else if ((animal.getAnimalType()).equalsIgnoreCase("chicken")) {
				totalChicken++;
				// Condition that checks if the a chicken weight the same or more as the minimum
				// amount required. If so it increases the chicken counter by one.
				if (animal.getWeight() >= animal.getMinimumWeightChicken()) {
					chickenCounter++;
				}
			} else {
				totalPig++;
				// Condition that checks if the a pig weight the same or more as the minimum
				// amount required. If so it increases the pig counter by one.
				if (animal.getWeight() >= animal.getMinimumWeightPig()) {
					pigCounter++;
				}
			}
		}

		message = "There are " + cowCounter + " (of " + totalCow + ")" + " Cows, " + chickenCounter + " (of "
				+ totalChicken + ")" + " Chickens and " + pigCounter + " (of " + totalPig + ")"
				+ " Pigs big enough to be sold at the moment!";

	}

}
