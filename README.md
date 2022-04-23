# The-Lord-of-The-Chores
SUMMARY:
By making chores into "Quests", this program sets out to make chores more doable by rewarding the player with in-game items after each completed task.

HOW TO CLONE:
If you have the EGIT plug in on your Eclipse, just switch to the Git Perspective, click on the "Clone a Git Repository", copy and paste the repo URL, type in your GitHub user name and personal access token, click Next, then check the "Add project to working sets" box and click Finish. Make sure your Java Compiler is set to Java 1.8 or has a JDK of 1.8 and not 17. The "data' directory in the project folder is where we stored our pictures for the images shown in the app as well as the .txt files that store the user information, so please do not attempt to alter it in any capacity.

OVERVIEW:
There's no visual UI to show what the current user has equiped, but there is functionality for equipping any of the purchased items from the shop in the Inventory scene. Everything else, however, is functional.

CharCreation.fxml and CharCreationController.java have not been implemented, but the .fxml file and the .java file have not been altered with.

The classes are seperated into different packages: the "application" package holds the Main class and the .css file. The "application.controller" package holds the controller classes for the .fxml files, while the "application.model" package holds the classes that handle the logic behind the controller classes.
