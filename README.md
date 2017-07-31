# BBFW-Project

## Projektbeschreibung

Dieses Projekt ist das Abschlussprojekt des Modules Informatik an der Technischen Hochschule Bingen. In Gruppen von zwei bis vier Personen bearbeiten dabei die Studenten eine Aufgabenstellung. Die Form, wie die Gruppe dieses Abschlussprojekt bearbeitet entscheidet über die Benotung des Modules.

Der Bearbeitungszeitraum für das Projekt ist vom 30. Juli ab 18:00 Uhr bis zum 13. August um 18:00 Uhr.

Weiter unten kann die Zielstellung/die Aufgabenstellung gelesen werden.

## Projektteam

Die Bearbeiter des Projektes ist ein Team aus diesen vier Studierenden:
* [dbaumy](https://github.com/dbaumy "Link zum GitHub-Profil von dbaumy")
* [jwustmann](https://github.com/jwustmann "Link zum GitHub-Profil von jwustmann")
* [FelixWerle](https://github.com/FelixWerle "Link zum GitHub-Profil von FelixWerle")
* [RF-Buerky](https://github.com/RF-Buerky "Link zum GitHub-Profil von RF-Buerky")

Als Betrachter und Ratgeber des Projektes tritt auch der Dozent auf:
* [Nicolai Parlog](https://github.com/nicolaiparlog "Link zum GitHub-Profil von Nicolai Parlog")

## Informationen für Mitwirkende

### Sprachregeln

Für das Projekt gelten festgelegte Regeln für die Sprache. Dies soll Durcheinander bei der Kommunikation miteinander und dem Code vermeiden.

Es gilt zu beachten:
* Code mit all seinen Bestandteilen (Klassen, Variablennamen, Testnamen, Kommentare) auf Englisch
* Commits beziehungsweise deren Beschreibung (sowohl beim lokalen Committen als auch Merge-Commits auf GitHub) auf Deutsch
* GitHub: mit den verschiedenen Bestandteilen wie Kommentare, Beschreibungen von Issues und PullRequests sowie Milestones auf Deutsch

### Merge-Regeln

Die Bearbeiter sind Neulinge auf dem Gebiet der Versionskontrolle und dem Kodieren. Das Projekt dient nicht nur als Prüfung sondern auch als Lehreinheit. Damit die Studierenden sich nichts durch einen Merge zerstören, ist ein Merge auf den master-Branch nur auszufügen, wenn der Dozent [Nicolai Parlog](https://github.com/nicolaiparlog "Link zum GitHub-Profil von Nicolai Parlog") sein OK gegeben hat. 

## Zielsetzung / Aufgabenstellung

Die Aufgabenstellungen sind vier aufeinander folgende Blöcke an Einzelaufgaben. Jeder Aufgabenblock bildet einen Milestone und ist Voraussetzung für den nächsten Block. Nachfolgend sind die Aufgabenstellungen aus der E-Lerning Plattform [OLAT](https://olat.vcrp.de/auth/RepositoryEntry/1676804160/CourseNode/95999652079122 "Link zur Aufgabenstellung in OLAT") übernommen - Aufgabensteller ist der Dozent [Nicolai Parlog](https://github.com/nicolaiparlog "Link zum GitHub-Profil von Nicolai Parlog").

### Block 1: "Project Infrastructure" - Aufbau der Projektinfrastruktur

Create the project's infrastructure:
* create a README.md describing the project and listing your names (they do not have to be real names if you don’t want; GitHub user names are fine as well)
* add a license and document it in the README
* decide on a language (e.g. by discussing it on the issue that belongs to this task) and document it in the README:
    * code (e.g. classes and variables) needs to be English
    * comments can be English or German but must be consistent
    * conversation on GitHub can be English or German but must be consistent (does not have to be the same as comments)
* research what a code of conduct is, how it relates to open source projects, and pick one; add it as a file to the project and document it in the README
* create a .gitignore file that prevents adding files/folders that are specific to IntelliJ IDEA and Maven
* create a Maven/Kotlin project that contains a simple HelloWorld.kt class with a main method printing "Hello, World." and that successfully builds a JAR
* integrate with Travis (I’ll do that - ping me on the issue when Maven is set up)
* set up JUnit 4 by extending pom.xml and writing a small HelloWorldTest
* extend the README to tell users how to launch the application
* release version 1.0

### Block 2: "Create a Simple Traffic Simulation" - Einfache Verkehrs-Simulation

Now that the infrastructure is set up, you can write some code. Please always include tests for your code and remember to use issues and pull requests, like described above:

* create a simulation consisting of cars and an abstract, monolithic road network (meaning it does not yet consist of individual roads - it’s just a single network); each car knows whether it wants to drive and the road network has a total capacity for cars; implement a single simulation step (which is supposed to represent one hour), where:
  * each individual car announces whether it wants to drive or not
  * the network tallies up the number of cars on the road and compares it to its own capacity
  * the network decides for each car whether it drives or is delayed due to traffic jams; that decision is based on how many cars are on the road compared to the network’s capacity:
	* less than or equal to capacity ~> all can drive
	* over capacity ~> all are delayed
* write a scenario function that simulates a scenario with about a dozen cars
* let the cars keep track of whether they can drive or were delayed and print that information at the end of the simulation
* write the main program, which uses Univocity Parsers to parse input (cars and their interest to drive) and write resulting data (drive vs delay) as CSV (this does not touch on the scenario function, which should be kept around)
* extend the README by writing a user documentation, explaining users how to use the program

When all that's done:
* release version 2.0

### Block 3: "Extend Simulation to Cover an Entire Day" - Erweiterte Simulation um einen Tag abzubilden

* randomize the decision for whether each individual car can drive or gets delayed; the chance for a delay depends on how many cars or on the road compared to the network’s capacity:
	* less than at 50% capacity: 5% chance of delay
    * less than at 70% capacity: 10% chance of delay
    * less than at 90% capacity: 20% chance of delay
    * less than at 110% capacity: 30% chance of delay
    * less than at 125% capacity: 50% chance of delay
    * less than at 150% capacity: 70% chance of delay
    * above 150% capacity: 90% chance of delay
* cover an entire day by simulating 24 steps in a row:
    * cars now need to know for each of the 24 hours whether they want to drive or not
    * if a car gets delayed it can not “fulfill” it’s desire to drive, meaning it has to try to drive again in the next step (small example: a car wants to drive in steps 8 and 9 but gets delayed in 9; now it also wants to drive in step 10)
    * extend result tracking by making sure that each car knows for every step whether it could drive or was delayed
    * update the scenario function to the simulation’s new requirements
* extend CSV input/output to match the new requirements and results:
    * extend input to include for each hour whether a car wants to drive
    * extend output to include for each hour whether the car drove or was delayed
* update the user documentation to match the new program behavior

When all that's done:
* release version 3.0

### Block 4: "Extend Simulation with Various Participants" - Erweiterte Simulation mit verschiedenen Teilnehmern

* extend the simulation to allow for other traffic participants:
    * create a suitable interface, of which the car is one implementation
    * make sure the code simulating individual steps only uses that interface
    * add implementations for trucks, trams, and bikes
    * extend the scenario to include a total of about a dozen non-cars
* give each kind of traffic participant a different chance of getting delayed:
    * cars keep the chances that were defined earlier
    * for trucks, each individual chance is 5% higher than for cars
    * for trams, each individual chance is half of that for cars
    * for bikes, the chance is always 5% unless the network is over 150% capacity, in which case the chance increases to 10%.
* change how different kinds of traffic participants clog the road network:
    * cars continue to “cost” 1 capacity
    * trucks cost 3 capacity
    * trams cost 5 capacity
    * bikers cost 0.1 capacity
* extend CSV input to allow defining different participants
* update the user documentation to explain how to define input and read output

When all that's done:
* release version 4.0