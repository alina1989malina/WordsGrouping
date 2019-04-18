package pack.words.grouping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test1() {
        String input = "sapog sarai arbuz bolt boks birja";
        String expected = "{b=[birja, boks, bolt], s=[sapog, sarai]}";
        assertEquals(new SortedWordGroup(input).toString(), expected);
    }

    @Test
    public void test2() {
        String input = "арбуз болт бокс биржа";
        String expected = "{б=[биржа, бокс, болт]}";
        assertEquals(new SortedWordGroup(input).toString(), expected);
    }

    @Test
    public void test3() {
        String input = "сапог сарай арбуз болт бокс биржа";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";
        assertEquals(new SortedWordGroup(input).toString(), expected);
    }

    @Test
    public void test4() {
        String input = "";
        String expected = "{}";
        assertEquals(new SortedWordGroup(input).toString(), expected);
    }

    @Test
    public void test5() {
        String input = null;
        String expected = "{}";
        assertEquals(new SortedWordGroup(input).toString(), expected);
    }

    @Test
    public void test6() {
        String input = "СаПоГ саРАЙ арбуз БОЛТ Бокс бИРЖА";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";
        assertEquals(new SortedWordGroup(input).toString(), expected);
    }

    @Test
    public void test7() {
        String inputString = "сапог +++ ' ' 58935735 сарай ||||| арбуз _ ~@$ $@$ 2323болт бокс биржа";
        String expected = "{'=[', '], б=[биржа, бокс], с=[сапог, сарай]}";
        assertEquals(new SortedWordGroup(inputString).toString(), expected);
    }

    @Test
    public void test8() {
        String inputString = "сапог сарай арбуз болт бокс биржа table duck deer";
        String expected = "{d=[deer, duck], б=[биржа, бокс, болт], с=[сапог, сарай]}";
        assertEquals(new SortedWordGroup(inputString).toString(), expected);
    }
}
