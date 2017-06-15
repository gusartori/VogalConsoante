package com.project.test;

import com.project.exception.VowelNotFoundException;
import com.project.model.Stream;
import com.project.model.StreamWord;
import com.project.util.CharRegExUtil;
import com.project.util.CharacterFinder;
import org.junit.Test;

import static org.junit.Assert.*;

public class VowelConsonantTest{

    @Test
    public void shouldStreamMethodsWork(){
        Stream stream = new StreamWord("java");
        assertTrue(stream.hasNext());
        assertEquals('j', stream.getNext());
    }

    @Test
    public void shouldRegExUtilVowelReturnTrue(){
        char c = 'a';
        assertTrue(CharRegExUtil.isVowel(c));
    }

    @Test
    public void shouldRegExUtilVowelReturnFalse(){
        char c = 'c';
        assertFalse(CharRegExUtil.isVowel(c));
    }

    @Test
    public void shouldRegExUtilDigitReturnTrue(){
        char c = '9';
        assertTrue(CharRegExUtil.isNumber(c));
    }

    @Test
    public void shouldRegExUtilDigitReturnFalse(){
        char c = 'c';
        assertFalse(CharRegExUtil.isNumber(c));
    }

    @Test
    public void shouldRegExUtilOtherCharsReturnTrue(){
        char c = '$';
        assertTrue(CharRegExUtil.isOtherChar(c));
    }

    @Test
    public void shouldRegExUtilOtherCharsReturnFalse(){
        char c = 'c';
        assertFalse(CharRegExUtil.isOtherChar(c));
    }

    @Test
    public void characterFinderTest(){
        Stream stream = new StreamWord("aAbBABacafe");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderFailTest(){
        Stream stream = new StreamWord("aAbBABacaf");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderVowelsTest(){
        Stream stream = new StreamWord("aAAaCiEeUu");
        assertEquals('i', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderVowelsFailTest(){
        Stream stream = new StreamWord("aAAaEeUu");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderConsonantTest(){
        Stream stream = new StreamWord("CffVgGarUtS");
        assertEquals('U', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderConsonantFailTest(){
        Stream stream = new StreamWord("CffVgGrtS");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderDigitsTest(){
        Stream stream = new StreamWord("9993afe19949");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderDigitsFailTest(){
        Stream stream = new StreamWord("999319949");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderOtherCharsTest(){
        Stream stream = new StreamWord("##$@@%    ---$     afe&&&&&");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderOtherCharsFailTest(){
        Stream stream = new StreamWord("$!@#$!@#%ˆ#ˆˆˆ%$!@#");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderMixedCharsTest(){
        Stream stream = new StreamWord("o1234i____----f31sd#%!@ba   s$@#!d a f e %iju");
        assertEquals('u', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderSmallStreamTest(){
        Stream stream = new StreamWord("ife");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderSmallStreamFailTest(){
        Stream stream = new StreamWord("if");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test(expected = VowelNotFoundException.class)
    public void characterFinderEmptyStreamFailTest(){
        Stream stream = new StreamWord("");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderLongStreamTest(){
        Stream stream = new StreamWord("aAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafeaAbBABacafefu");
        assertEquals('u', CharacterFinder.firstChar(stream));
    }

    @Test
    public void characterFinderManySequencesTest(){
        Stream stream = new StreamWord("MmmMiFe");
        assertEquals('e', CharacterFinder.firstChar(stream));
    }

}
