package recursion.fill_paint;

public enum Color {
    RESET("\033[0m"),
    RED("\033[41m"),
    ORANGE("\033[48;5;208m"), //background [48;5;xxx  foreground [38;5;xxx
    YELLOW("\033[48;5;11m"),
    GREEN("\033[42m"),
    BLUE("\033[44m"),
    INDIGO("\033[46m"),
    VIOLET("\033[45m");

    final String color;
    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
