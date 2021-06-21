public enum SortingField {

    SPADES,
    DIAMONDS,
    CLUBS,
    HEARTS;

    public static String returnShape(Shape shape) {
        switch (shape) {
            case SPADES:
                return  "♠";
            case DIAMONDS:
                return "♦";
            case CLUBS:
                return "♣";
            case HEARTS:
                return "♥";

        }
        return "";
    }
}

}
