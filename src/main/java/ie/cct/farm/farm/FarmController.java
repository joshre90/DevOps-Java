package ie.cct.farm.farm;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmController {

	// Instance Animal used to populate the array
	Animal animal = new Animal();
	// ArrayList of the type animals that stores all the farm animals
	private ArrayList<Animal> animals;

	public FarmController() {
		// ArrayList used to store all the animals of the farm
		animals = new ArrayList<Animal>();

		// Animals added when the program starts, it is to help shorten the evaluation
		// time
		animals.add(new Animal("Cow", 305, 0));
		animals.add(new Animal("cOw", 280, 0));// Cannot be sold
		animals.add(new Animal("piG", 127, 0));
		animals.add(new Animal("pig", 70, 0));// Cannot be sold
		animals.add(new Animal("cHicken", 1.2f, 0));
		animals.add(new Animal("chIckeN", 0.3f, 0));// Cannot be sold
	}
	
	///////////// Calculating the average weight of the farm animals
	@GetMapping("")
	public String greeting() {
	return "Hi! Welcome to the Farm API";
	}

	///////////// Calculating the average weight of the farm animals
	@GetMapping("average-weight")
	public AverageWeight getAverage(ArrayList<Animal> animals) {
		return new AverageWeight(this.animals);
	}

	//////////// Method that displays which animals can be sold
	@GetMapping("selling-animals")
	public SellAnimals getSellingAnimals() {
		return new SellAnimals(this.animals);
	}

	//// Calculating farm value either with default values or using parameters. This
	//// option availability makes the required parameters not mandatory
	@GetMapping("current-value")
	public FarmValue currentFarmValue(ArrayList<Animal> animals, @RequestParam(required = false) String cow,
			@RequestParam(required = false) String chicken, @RequestParam(required = false) String pig) {

		// Variables were the parameter values would be store once converted
		Float cowFloat;
		Float chickenFloat;
		Float pigFloat;

		// Checks if the parameter cow receives a null value. If so it assigns the
		// default price value of 500
		if (cow == null) {
			cowFloat = 500f;
		} else {
			cowFloat = Float.parseFloat(cow);
		}

		// Checks if the parameter chicken receives a null value. If so it assigns the
		// default price value of 5
		if (chicken == null) {
			chickenFloat = 5f;
		} else {
			chickenFloat = Float.parseFloat(chicken);
		}

		// Checks if the parameter pig receives a null value. If so it assigns the
		// default price value of 250
		if (pig == null) {
			pigFloat = 250f;
		} else {
			pigFloat = Float.parseFloat(pig);
		}

		// Calls the method to calculate the current value of the farm
		return new FarmValue(this.animals, cowFloat, chickenFloat, pigFloat);
	}

	// POST http://localhost:8080/add-animal
	@PostMapping("add-animal")
	public SuccessResponse addAnimal(@RequestBody Animal animal) {
		// This variable converts all the inputs into lower case
		String animalLC = animal.getAnimalType().toLowerCase();

		// Checks if the inputs is cow, chicken or pig, if the input is either of them,
		// then adds it to the animals ArrayList. If not throws a 406 http exception
		if (animalLC.equals("cow") || animalLC.equals("chicken") || animalLC.equals("pig")) {
			animals.add(animal);
			return new SuccessResponse("Item " + animal.getAnimalType() + " added.");
		} else {
			throw new NotAcceptableException("Please input Cow, Chicken or Pig");
		}
	}

	///////// Exceptions
	@GetMapping("no-content")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void emptyContent() {

	}

}
