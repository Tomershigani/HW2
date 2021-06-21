public enum SortingField {

    NAME,
    SIZE,
    DATE;

    public static String returnShape(SortingField sortfiled) {
        switch (sortfiled) {
            case NAME:
                return "by name";
            case SIZE:
                return "by size";
            case DATE:
                return "by date";


        }
        return "";
    }
}


