package launch;

/**
 * Exception thrown when using the program with incorrect arguments.
 *
 * @author Guillaume André
 */
public class BadArgumentsException extends Exception {

    private static final String INVALID_ARGS = "Invalid arguments. Possible arguments are one of the following : (-a) (--centre | --enseigne |" +
            " --magasin) \nCheck Readme for more information. ";

    /**
     * Displays an error message, then quits the program.
     */
    public BadArgumentsException() {
        super(INVALID_ARGS);
        System.out.println(INVALID_ARGS);
        System.exit(1);
    }
}
