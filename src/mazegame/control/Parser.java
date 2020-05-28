package mazegame.control;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    private ArrayList<String> dropWords;
    private ArrayList<String> validCommands;

    public Parser(ArrayList<String> validCommands) {  //valid command is the only constructor and its an arraylist of string
        dropWords = new ArrayList<String>(Arrays.asList("an", "and", "the", "this", "to")); //initialize list of drop words
        this.validCommands = validCommands; //initialize valid commands
    }

    public ParsedInput parse(String rawInput) { //parse method accepts raw string, split and extract earch words check if the word
        // is in the valid commands (set in constructor), if it is, then setit as the command of the parser object it is returning
        //Alsoacheck is done if its in the drop words,if its not, it adds it to athe argument arraylist of the parser object its returning
        ParsedInput parsedInput = new ParsedInput();
        String lowercaseInput = rawInput.toLowerCase();
        ArrayList<String> stringTokens = new ArrayList<String>(Arrays.asList(lowercaseInput.split(" ")));

        for (String token : stringTokens) {

            if (validCommands.contains(token)) {
                parsedInput.setCommand(token);
            } else if (!dropWords.contains(token))
                parsedInput.getArguments().add(token);
        }
        return parsedInput;
    }

}


//Parser class accepts our list of valid commands, then the parse in parser class accepts raw user inputs,
//extracts the valid commands and other arguments thats not in dropwords and output it in the parsedInput format.