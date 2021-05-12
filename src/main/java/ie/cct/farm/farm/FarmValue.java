//This class calculates the value of the animals that can be sold by type and also the total value of the farm
package ie.cct.farm.farm;

import java.util.ArrayList;

public class FarmValue {

	// Variables used to do the calculation in the code
	double totalCowValue, totalChickenValue, totalPigValue, totalValue;
	int cowCounter, chickenCounter, pigCounter;

	// Variable used to send back the message to user and its getters and setters
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Constructor of the class
	public FarmValue(ArrayList<Animal> animals, float newCowValue, float newChickenValue, float newPigValue) {

		// Checks if the Array is not empty
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm");
		}

		// Loop that go through every object in the array
		for (Animal animal : animals) {

			// Condition that looks for 'cow'
			if ((animal.getAnimalType()).equalsIgnoreCase("cow")) {
				// In case it is a cow it also checks if the weight of the animal is same or
				// greater that the minimum required to be sold. If so, then it will sum up the
				// price value and will increase the counter by one. Same process for all animals
				if (animal.getWeight() >= animal.getMinimumWeightCow()) {
					totalCowValue += newCowValue;
					cowCounter++;
				}
			}
			// Condition that looks for 'chicken'
			else if ((animal.getAnimalType()).equalsIgnoreCase("chicken")) {
				if (animal.getWeight() >= animal.getMinimumWeightChicken()) {
					totalChickenValue += newChickenValue;
					chickenCounter++;
				}
			}
			// There are only pigs left if the two conditions above were not met
			else {
				if (animal.getWeight() >= animal.getMinimumWeightPig()) {
					totalPigValue += newPigValue;
					pigCounter++;
				}
			}

		}
		// Sums up the values to get the total value of the farm animals that can be
		// sold
		totalValue = totalCowValue + totalChickenValue + totalPigValue;
		message = "Value of Cows(" + cowCounter + " * " + newCowValue + "): " + totalCowValue + "€" + "     -Chickens("
				+ chickenCounter + " * " + newChickenValue + "): " + totalChickenValue + "€" + "     -Pigs("
				+ pigCounter + " * " + newPigValue + "): " + totalPigValue + "€" + "     -Total farm value: "
				+ totalValue + "€";
	}

}
