PROJECT TITLE:  Sally from the Alley (Working title)
PURPOSE OF PROJECT: Totally awesome platformer
VERSION or DATE: Alpha 1.1 11/28/2018
HOW TO START THIS PROJECT: Compile and run.
AUTHORS: CCMTP
USER INSTRUCTIONS: a,d to move left and right; f to fire; space to jump

==============================================================

Subsystem Classes
-----------------
World and GameMaster mechanics:  Chandler Clarke
-GameWorld:  The game world.  80% Complete, need to organize and update world creation.
-MainMenu:  The main menu. 0% Complete, will be a simple button to start game.
-GameMaster:  A superclass that holds all non interactive game objects. 100% done, empty class.
    -EasterEgg:  An easter egg.  80% done, need to make it delete itself after a time period.
    -HealthCounter: Displays Health.  100% Done  (InitializeImages is in HealthCounter Class)
    PotionCounter:   Displays Potions. 80% Done, need to add support for planned potion types/bug fixes.
    
    ScoreCounter:  Displays score. 100% Done

Platforms: Camille Otillio
-Platform: A super class that informs how the platforms will behave and interact
    -Mushrooms: A type of platform that will change how Sally moves
    -Branches: Another type of platform that Sally can land on and use to move around
-Tiles: Give the illusion of Sally walking around the forest

Enemies: Philip Jepkes
-Enemy:SuperClass of Badguys (50%)
-- potentially 100% just to consolidate code 
   if not 100% consolidate code from subclasses for orginization
   -WereWolf:A wolf that wil walk back and forth contains an initializeImage(85%)
   --needs fine tuning and some requests from world
     potentially also needs a different Image for howling 
     or just some renaming from howling to projectile 
   -Howl: A projectile  contains an initializeImage (90%)
   --needs an image and some fine tuning based 
     on team level design  and desired jump height
   -Bat: A bat that flys and attacks contains an initializeImage (99%) 
   --fine tuning based on team level design
   -Boss:A boss that moves in a set pattern(0-1%)
   --design and movement pattern needs to be discussed with team 
     did not want to make a pattern team did not like
   -Spider: A spider that will drop and wiggle (75%)
     --needs images and some fine tuning based on team level design
   -Death: An removal animation that will exist when enemies are removed(85%)
   -- needs Images and fine tuning
   
Objex & Helper: Tyler Bakeman
-Objex:SuperClass of Objects
   -Gem: Adds to Score on Touch
   -Potion: Affects Player on Touch
   -Lantern: LIT object, random chance to do something
   -Fireball: LIT object that kills enemies (95%)
     --needs animation for being LIT
-Helper
   Quo, AbsQuo,IncQuo counter,polar 

Main character's and superclasses for all game characters: Marlene Inoue
   -Sprite: superclasses of game character's that "walk" (70%)
     --might need to add more for movement
   -Witch: user-controlled character (80%)
     -- more images, dying code/state, dealing with Objex classes
   -Cat: the NPC that must be rescued (90%)
     -- change image when touch Witch, need more implementation when end game
   -Fireball: LIT object that kills enemies (95%)
     --needs animation for being LIT
Vector CLass: Poul Henriksen Michael Kolling
SmoothMover:Poul Henriksenauthor Michael Kolling (Including improvements suggested by J. Buhl.)
Attributions
==========================================================================
1. Women images from Gothicvania Town, free at
https://ansimuz.itch.io/gothicvania-town
2. Werewolf images
https://rvros/itch.io/pixel-monsters-2
3. Health Bar Images
https://fliflifly.itch.io/hearts-and-health-bar
