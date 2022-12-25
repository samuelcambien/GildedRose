# Gilded Rose Java kata

Some remarks:
* The quality/sellin changing behaviour of the items is determined by their name. One could argue that this is not an optimal design, but I've kept it like this in order not to change the existing functionality. I've created String constants though in the ItemType classes.
* It is not entirely clear from the description, but the original code makes aged brie increase in quality twice as fast after the sell date has passed. So I've written my tests conform to this, and kept this behaviour when refactoring.
* For Sulfuras items, I didn't take into account the use case where someone could create an item with the name 'Sulfuras, Hand of Ragnaros' but with a quality different than 80. This would make an item inconsistent with the specifications. But again, this is how the program initially worked and changing this seemed out of scope of this work package.
* I have taken the following steps in separate commits:
  * I've added regression tests for the initial functionality
  * I've refactored the GildedRose#updateQuality method to use the quality update methods from the relevant item type, with a fallback update method if there is no specific item type for a particular item
  * I've added the Conjured item type and related tests
* At each of these commits, the 'mvn clean package' command (which executes all the tests) runs without errors.
* I've used Maven to run the tests, I didn't use Gradle since I am used to Maven and I have no experience with Gradle, but I guess it's quite similar.
