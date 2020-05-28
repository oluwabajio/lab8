package mazegame.control;

import java.io.IOException;
import java.util.ArrayList;

import mazegame.SimpleConsoleClient;
import mazegame.boundary.IMazeClient;
import mazegame.boundary.IMazeData;
import mazegame.entity.Player;

public class DungeonMaster {
	private IMazeClient gameClient;
	private IMazeData gameData;
	private Player thePlayer;
    private boolean continueGame;
    private ArrayList<String> commands;
    private Parser theParser;


    public DungeonMaster(IMazeData gameData, IMazeClient gameClient)
     {
         this.gameData = gameData;     //----new HardcodedData (implementing IMazeDate)
         this.gameClient = gameClient;   //----new SimpleConsoleClient (ImplementingImazeClint)
         this.continueGame = true;
         commands = new ArrayList<String>();
         commands.add("quit");
         commands.add("move");
         theParser = new Parser (commands); //

     }


    public void runGame()
    {
        printWelcome();
        setupPlayer();

        while (continueGame) {
            continueGame = processPlayerTurn();
        }

    }

     public void printWelcome()
     {
         gameClient.playerMessage(gameData.getWelcomeMessage());
     }

     public void setupPlayer()
     {
         String playerName = gameClient.getReply("What name do you choose to be known by?");
         thePlayer = new Player(playerName);
         gameClient.playerMessage("Welcome " + playerName + "\n\n");
         gameClient.playerMessage("You find yourself looking at ");
         gameClient.playerMessage(gameData.getStartingLocation().getDescription());

        // gameClient.getReply("<<Hit Enter to exit>>");
     }

    public boolean processPlayerTurn() {
        ParsedInput userInput = theParser.parse(gameClient.getCommand());
        if (commands.contains(userInput.getCommand())) {
            if (userInput.getCommand().equals("quit"))
                return false;
            if (userInput.getCommand().equals("move")) {
                gameClient.playerMessage("You entered the move command");
                return true;
            }
        }
        gameClient.playerMessage("We don't recognise that command - try again!");
        return true;
    }


}


/////SimpleConsoleClientClass (implementing ImazeClient)
//playermessage - display information
//getReply - toask for input

/////HardcodedData implementing ImazeData
//getStartingLocation  - get startup location which is of typeLocation (description,label) and can also call addExits
//getWelcomeMessage - gets welcome message, returns a string