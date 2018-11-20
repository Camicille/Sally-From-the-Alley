PROJECT TITLE:  Sally from the Alley (Working title)
PURPOSE OF PROJECT: Totally awesome platformer
VERSION or DATE: Alpha 1.0 11/19/2018
HOW TO START THIS PROJECT: Compile and run.
AUTHORS: CCMTP
USER INSTRUCTIONS:

==============================================================

Subsystem Classes
-----------------
World and GameMaster mechanics:  Chandler Clarke
-GameWorld:  The game world.
-MainMenu:  The main menu.
-GameMaster:  A superclass that holds all non interactive game objects.
    -EasterEgg:  An easter egg.
    -HealthCounter, PotionCounter, ScoreCounter:  Objects that display health, potions, and score.
-Pause Menu:  A pause menu. (May or may not implement).

Platforms: Camille Otillio
-Platform: A super class that informs how the platforms will behave and interact
    -Mushrooms: A type of platform that will change how Sally moves
    -Branches: Another type of platform that Sally can land on and use to move around
-Tiles: Give the illusion of Sally walking around the forest

Enemies: Philip Jepkes
-Enemy:SuperClass of Badguys
   -WereWolf:A wolf that wil walk back and forth
   -Howl: A projectile that will exsist
   -Bat: A bat that flys and attacks
   -Boss:A boss that moves in a set pattern
   -Spider: A spider that will drop and wiggle
   -Death: An removal animation that will exist when enemies are removed
   
Objex: Tyler Bakeman
-Objex:SuperClass of Objects
   -Gem: Adds to Score on Touch
   -Potion: Affects Player on Touch
   -Lantern: LIT object, random chance to do something

Main character's and superclasses for all game characters: Marlene Inoue
   -Sprite: superclasses of game character's that "walk"
   -Sally: user-controlled character
   -Sebastian: the NPC that must be rescued

