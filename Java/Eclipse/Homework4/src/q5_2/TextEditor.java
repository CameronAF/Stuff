package q5_2;

/**
 * text editor class that benefits from multiple variants of a spell checking algorithm
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/19/2018
 */
public class TextEditor {
	// Private attributes
	private String languageToCheck;
    private LanguageStrategy strategy;

    /**
	*  Main method
	*  @precondition none
	*  @postcondition program will have executed
	*/
    public static void main(String[] args) {
		// two users
        TextEditor firstUser = new TextEditor(new English());
        TextEditor secondUser = new TextEditor(new English());
        firstUser.printLangInUse();
        secondUser.printLangInUse();
        
        // one user changes language and doesn't effect other user
        secondUser.setStrategy(new Spanish());
        firstUser.printLangInUse();
        secondUser.printLangInUse();
	}
    
    /**
	*  Constructor for class Controller
	*  @precondition none
	*  @postcondition a instance of TextEditor would have been initialized
	*/
    public TextEditor(final LanguageStrategy strategy) {
        this.strategy = strategy;
        this.languageToCheck = this.strategy.getLangToUse();
    }

    /**
	*  Print which language is being used
	*  @precondition instance of TextEditor initialized
	*  @postcondition System print line
	*/
    public void printLangInUse() {
        System.out.println("User using " + languageToCheck + " language in spell checker");
    }

    /**
	*  Set Strategy
	*  @precondition instance of TextEditor initialized
	*  @postcondition TextEditor strategy has been changed
	*/
    public void setStrategy(final LanguageStrategy strategy) {
        this.strategy = strategy;
        this.languageToCheck = this.strategy.getLangToUse();
    }
}
