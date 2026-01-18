Requirement Clarification
1. How many entrances we have
2. Different type of ParkingSpot
	1. 2Wheeler 4 Wheeler
3. Types of Payment




Objects
	1. Vehicle
	2. Ticket
	3. Parking Spot
	4. EntranceGate
	5. ExitPoint
	6. 
   
Types Of ParkingSpot
1. TwoWheeler
2. FourWheeler


Vehicle 
	1. Vehicle Type Enum {2 wheeler 4 wheeler}
	2. vehicle Number :int

Ticket
	1. Entry Time: long int
	2. Vehicle vehicle
	3. ParkingSpot ps



ParkingSpot
	1. id : int
	2. isEmpty() : bool
	3. Vehicle vehicle
	4. price :int
	5. parkVehicle(vehicle v)
	6. removeVehicle()

TwoWheelerSpot child of ParkingSpot 
sets price
FourWheelerSpot child of ParkingSpot
sets price

ParkingSpotManager 
	1. List ParkingSpot list
	2. ParkingStrategy PS
	3. findParkingSpace()
	4. AddParkingSpace()
	5. RemoveParkingSpace()
	6. ParkVehicle()
	7. RemoveVehicle()
TwoWheelerManager child
FourWheelerManager child


ParkingStrategy

	NearToEntrance
	 NearToEntAndElevator
	  


ParkingManagerFactory
	ParkingSpotManager  getPM(VehicleType)

EntranceGate
		 1. ParkingSpotFactory psf
		 2. ParkingSpotManager psm
	     3. findParkingSpace(vehicleType VT)
	     4. BookSpot(Vehicle vehicle)
		5. generateTicket(Vehicle,Parking_spot)
		6. UpdateParkingSpace()


ExitGate
		 1. Ticket
		 2. ParkingSpotManager psm
		 3. ParkingSpotManager
		4. CostComputationfactory ccf
		5. CostComputation cc
		6. priceCalculation()
		7. Payment()
		8. RemoveVehicle





CostComputation
TwoWheelerCostComputation :- child
FourWheelerCostComputation:- child

CostComputationFactory
	CostComputation getCostComputationType(Ticket ticket)

PricingStrategy
	price(Ticket ticket)

HourlyPricingStrategy child of PricingStrategy
		price(Ticket ticket)

MinutePricingStrategy  child of PricingStrategy
			price(Ticket ticket)
