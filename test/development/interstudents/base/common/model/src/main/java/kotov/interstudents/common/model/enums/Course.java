package kotov.interstudents.common.model.enums;

/**
 * Created by vkotov on 04.03.2015.
 */
public enum Course {
    first("I"),
    second("II"),
    third("III"),
    four("IV"),
    five("V");

    private final String title;

    private Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
