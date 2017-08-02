# STRUCTURE.md

Diese Datei bietet eine Übersicht über die OOP-Struktur des Projektes. Diese Zusammenfassung des Projektes soll eine kompakte Übersicht über den Aufbau des Projektes bieten und Mitwirkenden einen guten Überblick bieten. Die Aktualität und Vollständigkeit dieser Datei ist nicht gesichert.

Das Projekt entwickelt sich über die verschiedenen Aufgabenblöcke hinweg weiter. Eine Erweiterung der Struktur für einen neuen Block wird in einem neuen Abschnitt formuliert - die alte Struktur wird noch beibehalten.

## Struktur bei Block 1

Noch keine Struktur vorhanden - Block 1 war der Setup des Projektes

## Struktur bei Block 2

Das Projekt ist eine einfache Straßenverkehrs-Simulation. Fahrzeuge sind auf einem Straßennetz unterwegs. Anhand der Kapazität des Straßennetzes und den fahrenden Fahrzeugen wird simuliert, ob die Fahrzeuge sich durch überschreiten der Straßenkapazität verspäten. Ein Simulationsschritt sei eine Stunde.

### values
* <Null> -

### entities

* car (licensePlate, )
* roadNetwork (carsCapacity, )

### methods
* car: announceDrive
	- a car announces whether it wants to drive or not
* car: drive
	- a car whether drives or drives not (real - not announcement)
* car: logSituation
	- every car keeps track of whether it is delayed or is not^
* car: printLog
	- the logSituation of every car is printed on the console
* roadNetwork: compareAnnouncesToCapacity
	- the network tallies up the number of cars on the road and compares it to its own capacity
* roadNetwork: scenarioSimulation
	- the network decides for each car whether it drives or is delayed due to traffic jams. All cars are delayed if the networks capacity is exceedet otherwise all cars drive without delays
* parseInput
	- the input how many cars are there and their interest to drive is picked out of a csv-file
* parseOutput
	- the simulations output of delays and not-delays are exported into a csv-file

## truktur bei Block 3