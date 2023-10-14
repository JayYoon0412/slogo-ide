# DESIGN Document for SLogo Team 02
### Andy Wang (xw214), Jay Yoon (jy320), Trevon Helm (tmh85), Rodrigo Bassi Guerreiro (rb419)


## Role(s)


* Team member #1: Jay Yoon (Model)
    * Interpreting user input to tokens: Interpreter, Input Parser
    * Token: Token types and Token Factory
    * Command: UserDefined, Control, Turtle, TurtleQuery, MultipleTurtle
    * Reader: HelpData, XML Reader
    * Turtle: TurtleModel, Turtle, TurtleSpace, History, and portions of TurtleSingle


* Team member #2: Rodrigo Bassi Guerreiro (Controller, View)
    * View class and subclasses
    * Controller and MasterController
    * Observer and Observable interfaces and Action class and subclasses


* Team member #3: Trevon Helm (View)
  * Frontend Design
  * Canvas, UI Turtle, Trails, and Animations
  * Gridpane and UI Element Placement


* Team member #4: Andy Wang (Model, util)
    * Util
    * Command
    * InitialVersion of Interpreter





## Design Goals
Design a program using JavaFX that provides an IDE for users to command a turtle to create drawings, which enables user-defined variables, complex loops and branches, multiple turtles, etc. Our main focus was to make it able to support:

* easy addition of new commands for extension
* flexibility to handle user-defined variables and commands
* extendable to handle multiple turtle interaction on multiple windows




## High-Level Design
Frontend:

* Canvas that contains and displays turtles, lines, and its animations
* UI Turtle that would contain what the user sees, such as location, rotation, color, image, opacity, etc.
* DefaultView class that unites all elements of the UI (Canvas, input, ToggleableViews, etc.)
* Trail class that allows lines to be of different shapes, colors, etc.
* ToggleableViews that show information related to the program, such as history and documentation.
* User input box


Backend:
* Turtle: TurtleSingle, TurtleModel, Turtle(Composite), History
* Pen, Background, Shape
* Token: Token Types (Constant, Variable, Command, etc.), TokenFactory
* Command: Turtle, Turtle Query, Math, Boolean, User-Defined, Control, Display, MultipleTurtle
* Interpreter: Interpreter, InputParser
* Reader: XMLReader, HelpData


Controller:
* Controller class: handling user input and updating back and frontend accordingly, mainly associated with MainView
* MasterController: handling when different views should be hidden or displayed when program is initialized, or when user input requires a whole new view to be created
* Observer and Observable: interfaces used in specific classes from both the View and the Model sides in order to identify changes that needed to be somehow handled or displayed to the user
Some of these were implemented as variations of the Observer class (e.g. TurtleObserver), but those could be refactored to accommodate the single Observer interface


Util:
* General Parser
* Regular Expression Parser, Location Parser, Argument Number Parser


High-Level Design Summary:

When the user clicks the run button, user input in the textbox is sent to the Interpreter as a parameter. The Interpreter processes user input (handling comments and extra spaces) using InputParser, and tokenizes it into SLogo tokens using the SLogo token types (defined in TokenTypes). It is able to recognize the token types using the RegexMatcher (util). In Interpreter, the Command is executed (with its exact execution outlined in each command subclass), updating turtle.
Updates to the backend turtle are communicated to frontend DefaultCanvas view through the observer pattern. The View displays the updated version of the turtle on the screen.


## Assumptions or Simplifications
* There is no way to remove a turtle from the Canvas.
* When a turtle walks off the edge of a canvas and returns to the other side, the trail it creates will cut across the entire canvas.
* Each window has its own set of user-defined variables and custom commands
* Not all instructions from change implemented, such as multi turtles.
* Every implementation of Observer (excluding variations such as TurtleObserver and BackgroundObserver) can get all the information it needs in the form of two strings (one informing which type of event happened, and the other giving the specific information of the event)
* Turtle Animations are done assuming that curves are created using small line segments (such as fd 1 fifty times) instead of one overarching curve command.
* Step Button is still present on the UI, though it is non-functional.
* Due to a bug in how the turtle is initially presented on the canvas, many tests fail due to small numerical errors.



## Changes from the Plan
* Frontend
    * The Turtle does not display the animation slowly when the command is complicated
    * The Turtle’s initial position is calibrated to 0 degree facing to the up direction.
    * The class that was originally supposed to be named SideView was changed into ToggleableView in order to better represent its functionality and simplify its extension into specific subclasses
    * An abstract View class was added in order to facilitate the general JavaFX interactions of showing and hiding windows, and allowing for more specific screens to be implemented within subclasses (e.g. separating the main view with the turtle and the canvas from the language selection view)


* Controller
    * An additional MasterController was added to initialize the program and keep track of opening and closing all the different views
    * Observer and Observable interfaces, as well as an abstract Action class, were added following the in-class discussion about design patterns (about a week into the project)


* Backend
    * Instead of each command initialized with its own parameter number, read its value from properties file
    * The XML file layout was changed to include everything in one single file (instead of one file for each command), and the alternate name structure was changed to accommodate how the different languages were being handled by the Parser
    * TurtleSpace was created to support multiple windows (to hold its own set of user-defined variables and commands)
    * Turtle was constructed through composition of single turtle and turtle interface to handle multiple turtle interaction


## How to Add New Features


* UI Customizations: new ToggleableView subclass can be made with sliders that directly call UI turtle opacity, color, or image commands.
* Different color profiles can be made by creating a new CSS file and replacing the default one with it in resources/UI/cssfiles.
* New trail types can be added by creating a new subclass of TrailMaker.


* Adding new Category of Command
    * Specifying location/argument/Regex … in property files
    * new command subclass extends Command abstract class, by specifying the token parameter list
    * overrides the execute() method with its appropriate content
* More flexible command. E.g. fd sum 10 10 10 10 10
    * Change the number of arguments for each command in the property files from a fixed number to an arbitrary range, like for sum [2, infty).
* Adding new Language options
    * Make a new file specifying the set of command keywords in resources (ex. French.properties)
    * When user selects language from splash screen, use its language value to initialize Interpreter of the language chosen	
