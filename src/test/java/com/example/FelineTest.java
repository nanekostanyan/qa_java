package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class FelineTest {
    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void getFamilyReturnsCatsFamily() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    public void eatMeatReturnsFoodList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutParamsReturnsOne() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void getKittensWithParamsReturnsSameNumber() {
        int kittensCount = 5;
        int kittens = feline.getKittens(kittensCount);
        assertEquals(kittensCount, kittens);
    }
}