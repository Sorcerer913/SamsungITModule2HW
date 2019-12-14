package com.company;

public class Condition {

    //String type0[];
    private String type1[] = {" will ", " won't "};
    private String type2[] = {"ed ", " was ", " were "};
    private String type3[] = {" had ", " has ", " have "};

    private boolean contains(String s, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (s.contains(array[i])) return true;
        }
        return false;
    }

    public byte conditionNumber(String s) {
        String str = s.toLowerCase().replaceAll(",", " ");
        if (contains(str, type1)) return 1;
        if (contains(str, type2)) return 2;
        if (contains(str, type3)) return 3;
        return 0;
    }

}
