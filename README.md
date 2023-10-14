# slogo
## TEAM NUMBER 02
## Trevon Helm (tmh85), Jay Yoon (jy320), Rodrigo Bassi Guerreiro (rb419), Andy Wang (xw214)


This project implements a Simple Logo interpreter.

### Timeline

* Start Date: February 20th, 2023

* Finish Date: March 11th, 2023

* Hours Spent: 300


### Attributions

* Resources used for learning (including AI assistance):
  * https://refactoring.guru/design-patterns

* Resources used directly (including AI assistance)
   * https://digitalsynopsis.com/design/color-schemes-palettes/
   * https://commons.uncyclomedia.org/wiki/Image:Broom_icon.svg
   * https://commons.wikimedia.org/wiki/File:Wikibooks-help-icon.svg
   * https://commons.wikimedia.org/wiki/File:Font_Awesome_5_solid_history.svg
   * https://commons.wikimedia.org/wiki/File:Emojione_1F3A8.svg
   * https://freesvg.org/1538154643
   * https://freesvg.org/vector-image-of-a-dark-blue-labelled-floppy-disk-icon
   * https://freesvg.org/vector-clip-art-of-striped-folder-icon
   * https://commons.wikimedia.org/wiki/File:Pedestrian_%2813079%29_-_The_Noun_Project.svg
   * https://commons.wikimedia.org/wiki/File:Running_icon_-_Noun_Project_17825.svg
   * https://www.pngall.com/turtle-png
   * https://freesvg.org/small-turtle-silhouette


### Running the Program

* Main class: Press the play button on the main class, then select a language when prompted!

* Data files needed:
   * Language properties files that are included in the Resources folder.
   * CSS file included in the resources folder is needed for styling.
   * Images included in the UI folders required.

* Interesting data files:
   * Slogo examples files!

* Key/Mouse inputs:
   * Enter Slogo commands into the input box. Click on the Run button to the right of the input box
     to run the desired command.
   * There are two windows to the left of the Canvas.
      * The top window has three tabs: Help, History, and Customize
         * Help lists all the documentation for Slogo.
         * History lists all previously run commands.
         * Customize tab will allow you to customize elements of the turtle and the canvas. (Note: Not fully functioning)
      * The bottom window has two tabs: Variables and Functions.
         * Each lists user-created variables and functions.
   * The buttons beside the title do the following on a mouse click:
      * Save: Save what is inside the input box to a .slogo file.
      * Load: Open a slogo file to put inside the input box
      * About: View a window of information about who created the program!
      * Clear: Clear all trails and reset the turtles back to their initial position
      * New Window: Open a new Slogo window.



### Notes/Assumptions

* Assumptions or Simplifications:
   * There is no way to remove a turtle from the Canvas.
   * When a turtle walks off the edge of a canvas and returns to the other side, the trail it creates
     will cut across the entire canvas.

* Known Bugs:
   * The first command entered will cause the turtle to move itself slightly up and left. As such,
     the first command is always slightly off from what is expected, though all other commands
     are correct.

* Features implemented:
  * All basic SLogo commands
  * Animation for turtle movement across canvas
  * SLogo file upload and download
  * Visualization of workspace information (variables and functions) and command history
  * Display of additional information on available commands
  * Support for different languages
  * Possibility of running unlimited IDE windows simultaneously

* Features unimplemented:
  * View customization (colors and turtles)
  * Run commands directly from history
  * User-defined movement speed for turtle(s)

* Noteworthy Features:
  * Successfully implemented / displayed user-defined commands and variables
  * User-friendly error catching
  * Display of unlimited independent windows



### Assignment Impressions
This was a very interesting assignment to work on, mainly because a good design was fundamental in 
making the implementation of the functionalities manageable. It was fun to think about how to parse
the different required commands (organizing information properly in order to allow for command
execution and the appropriate processing of return values). 

In terms of the controller, what stood out the most was dealing with the different data dependencies 
that came up when getting information from the view to the model and _vice-versa_. It was particularly
rewarding to think about different design patterns when implementing this, and comparing how much
things improved once these were properly embedded into the code.

For the view, it was great to explore different functionalities of JavaFX, and to think about how to
organize the large amounts of information present in this project in a manageable way. Specifically,
it was noticeable how useful properties files can be when it comes to designing the frontend, and how
the contexts in which they come up can vastly differ.

Overall, this project was very gratifying to execute. We got to implement a great deal of the features
we expected to have, and the way the code was designed would not make it too hard to add on most of
the remaining functionalities later on.


