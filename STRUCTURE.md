# STRUCTURE.md

Diese Datei bietet eine Übersicht über die OOP-Struktur des Projektes. Diese Zusammenfassung des Projektes soll eine kompakte Übersicht über den Aufbau des Projektes bieten und Mitwirkenden einen guten Überblick bieten. Die Aktualität und Vollständigkeit dieser Datei ist nicht gesichert.

Das Projekt entwickelt sich über die verschiedenen Aufgabenblöcke hinweg weiter. Eine Erweiterung der Struktur für einen neuen Block wird in einem neuen Abschnitt formuliert - die alte Struktur wird noch beibehalten.

## Struktur bei Block 1

Noch keine Struktur vorhanden - Block 1 war der Setup des Projektes

## Struktur bei Block 2

Das Projekt ist eine einfache Straßenverkehrs-Simulation. Fahrzeuge sind auf einem Straßennetz unterwegs. Anhand der Kapazität des Straßennetzes und den fahrenden Fahrzeugen wird simuliert, ob die Fahrzeuge sich durch überschreiten der Straßenkapazität verspäten.

### values
* <Null> -

### entities

* car (licensePlate, )
* roadNetwork (carsCapacity, )

### methods
* car: announceDrive
* car: drive
* car: logSituation
* car: printLog
* roadNetwork: compareAnnouncesToCapacity
* roadNetwork: scenarioSimulation
* parseInput
* parseOutput

## truktur bei Block 3