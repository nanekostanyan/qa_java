package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsExpected() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodCallEatMeatOnlyOnce() throws Exception {
        cat.getFood();

        verify(feline, times(1)).eatMeat();
    }
}
