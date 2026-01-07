package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void getKittensReturnsExpected() throws Exception {
        int expected = 1;
        when(felineMock.getKittens()).thenReturn(expected);
        Lion lion = new Lion(felineMock, "Самец");

        int actual = lion.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void innerGetKittensCallsOnlyOnce() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");

        lion.getKittens();

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void getFoodReturnsExpected() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion(felineMock, "Самка");

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        verify(felineMock, times(1)).getFood("Хищник");
    }

    @Test
    public void innerGetFoodCallsOnlyOnce() throws Exception {
        Lion lion = new Lion(felineMock, "Самка");

        lion.getFood();

        verify(felineMock, times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void getFoodWithInvalidAnimalKindThrowsException() throws Exception {
        Feline felineSpy = spy(new Feline());
        doAnswer(invocation -> {
            return new Feline().getFood("Бублик");
        }).when(felineSpy).getFood(anyString());

        Lion lion = new Lion(felineSpy, "Самка");

        lion.getFood();
    }

    @Test(expected = Exception.class)
    public void constructorInvalidSexThrowsException() throws Exception {
        new Lion(felineMock, "Кто-то");
    }
}
