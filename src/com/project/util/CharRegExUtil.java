package com.project.util;

public class CharRegExUtil {

    private static final String VOWELS_REGEX = "(?i)[AÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮİÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖUŨŪŬŮŰŲÙÚÛÜȔȖṲṴṶṸṺỤỦỨỪỬỮỰYẙỲỴỶỸŶŸÝ]";

    private static final String OTHER_CHARS_REGEX = "[^\\w]";

    private static final String NUMBERS_REGEX = "\\d";

    public static boolean isVowel(char c) {
        return String.valueOf(c).matches(VOWELS_REGEX);
    }

    public static boolean isConsonant(char c) {
        return !isVowel(c) && !isOtherChar(c) && !isNumber(c);
    }

    public static boolean isOtherChar(char c){
        return String.valueOf(c).matches(OTHER_CHARS_REGEX);
    }

    public static boolean isNumber(char c){
        return String.valueOf(c).matches(NUMBERS_REGEX);
    }
}
