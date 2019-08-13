## Tabletop Character and Dice Bot

This project is designed to be a text-driven bot that will run on either Discord 
or the Command Line. The tool is made to be useful for both DMs and players, storing
information on an entire Party, as well as on individual Characters. 

The bot comes equipped with a robust dice-rolling suite, as well as the ability to combine
regular rolls with attributes from different characters.

#### Usage:
To use the bot, you simply enter the command '#ttbot', followed by any dice rolling, character,
or party command. All commands and arguments are case insensitive, with the exception of '#ttbot' itself

#### Commands Currently Supported:
* Who/whois -> Will make the bot list all of the members of the currently set party
    * syntax: '#ttbot who' or ' #ttbot whois'
* Add -> Will create a new character using the provided name, setting their current level to 0. 
   * syntax: '#ttbot add CHARACTERNAME'
* Character-Specific Saving Throws -> Will roll a 5th Edition saving throw of the appropriate type, getting the 
appropriate modifier from the character's ability scores, and applying the character's proficiency
bonus if the character's classes are proficient in that save. The type of save can be abbreviated or fully spelled out
    * syntax: '#ttbot ABILITYTYPE save CHARACTERNAME'
    * Examples:
        * '#ttbot dex save bob' -> will roll a DEX saving throw, using Bob's DEX save modifier
        * '#ttbot dexterity save bob' -> same as above
        * '#ttbot INT save Phil' -> will roll an INT saving throw, using Phil's INT save modifier

#### Commands on the roadmap:
* Remove character -> Will take a character name and remove that character and it's data from the active party
* Add Level -> Will take a character name and a 5th edition PHB character class, and increase the 
character's level in that class
* Remove Level -> inverse of above command
* Add Skill Proficiency -> Will take a character name and a 5th edition skill name, and will set that character
to be proficient in the referenced skill if it is not already
* Remove Skill Proficiency -> inverse of above command
* Set Ability Score -> Will take a character name, an ability score name, and a value, and set the relevant ability score to that value
* Skill checks -> Will take a character name and a skill name, and will roll a skill check using a specified 
character's relevant ability scores and proficiency modifier if applicable
* Attack setup -> Will take a character name, an attack "name", an attack ability to use, a YES/NO field for proficiency, and a 
dice roller command for damage (embedded in "[ ]"s), and store that as an attack option for a character to use.
* Attack roll -> will take a character name, an attack name (created by the attack setup command), and make an attack roll using the modifiers set, and also roll damage based on the damage macro
* Hit Points tracking -> commands like 'Add', 'Remove', and 'AddTemp' commands to keep track of character HP
* Spell slot tracking -> Goal is to have max spell slots based on character level in classes, but initially it will be manually controlled
* Rest commands -> commands that will apply the benefits of short/long rests to the currently active party
