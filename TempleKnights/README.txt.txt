Patrick Dunning = g00284875
Text Adventure Templer Knights

Project: TempleKnights
Package: gmit
Classes:
-AbstractGameCharacter
-AStar
-Attackable
-Commands
-DeadlyTemplerKnights
-Directions
-Exits
-Folk
-GameCharacter
-HeuristicCalculator
-HeuristicNodeComparator
-InnKeeper
-Item
-Location
-Lookable
-Nazgul
-Node
-Parser
-PathLocations
-Saracen
-Talkable
-TestKnight(FuzzyLogic)
-Thief
-Weapon

File:fcl
TemplerKnights.fcl
-Fuzzy Logic file with commands for the knight.

TempleKnights.xml
-XML file containing all descriptions for the locations, Items and Characters

fuzzy.jar
-Jar file

What the Program Actually does:
-You can run everything from the Parsar class
-It will first print out all of the Location Details,
-The id, name, description, exits,direction, characters and items.
-For some reason it is giving me a null response for the characters 
and only printing out one exit with its Correct direction.
- After that it will greet you and ask for your name, it will then show you all locations,
then it asks what would you like to do and type in
-LOOK
-GO 
as they are the only ones that work(make sure in capital letters)
also QUIT works aswel.
thats basically everything it does.