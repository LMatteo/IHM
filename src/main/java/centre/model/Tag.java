package centre.model;

/**
 * A tag of a store, containing both the english and frecnh version of the tag.
 *
 * @author Guillaume André
 */
public class Tag {

    private String english;
    private String french;

    /**
     * Creates a tag with its english of french version.
     *
     * @param french  - the french version of the tag
     * @param english - the english translation of the tag
     */
    public Tag(String french, String english) {
        this.english = english;
        this.french = french;
    }

    public String getFrench() {
        return french;
    }

    public String getEnglish() {
        return english;
    }


}
