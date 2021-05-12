//This class calculates the average weight of each animal

package ie.cct.farm.farm;

import java.util.ArrayList;

public class AverageWeight {

	// Variables used to store the animals weight by type
	float cowsWeight = 0.0f;
	float chickenWeight = 0.0f;
	float pigsWeight = 0.0f;

	// Counters used to calculate the averages of each animal
	int i = 0, j = 0, k = 0;

	// Variable used to send back the message to user and its getters and setters
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/////// Constructor of the class
	public AverageWeight(ArrayList<Animal> animals) { // Receives an ArrayList of the type Animal

		// Checks if the ArrayList is empty
		if (animals.size() == 0) {
			throw new NotFoundException("No animals in the farm");
		}

		// Loop that checks every object in the array
		for (Animal animal : animals) {
			// If the animal type is cow, the counter i increases by 1 and the total weight
			// of the cows increases
			if ((animal.getAnimalType()).equalsIgnoreCase("cow")) {
				i++;
				cowsWeight += animal.getWeight();

				// If the animal type is chicken, the counter j increases by 1 and the total
				// weight of the chicken increases
			} else if ((animal.getAnimalType()).equalsIgnoreCase("chicken")) {
				j++;
				chickenWeight += animal.getWeight();

				// If the animal type is pig, the counter k increases by 1 and the total weight
				// of the pigs increases
			} else {
				k++;
				pigsWeight += animal.getWeight();
			}
		}

		// Calculating the averages of each animal (Total weight/number of animals of
		// that type)
		cowsWeight = cowsWeight / (i);
		chickenWeight = chickenWeight / (j);
		pigsWeight = pigsWeight / (k);

		// Message sent back
		message = "Average weight of     -Cows(" + i + "): " + cowsWeight + "kg" + "     -Chickens(" + j + "): "
				+ chickenWeight + "kg" + "     -Pigs(" + k + "): " + pigsWeight + "kg";
	}
}