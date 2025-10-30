package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionManeParamTest {

    @Mock
    private Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;

    public LionManeParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void doesHaveManeDependsOnSex() throws Exception {

        Lion lion = new Lion(felineMock, sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedHasMane, actual);
    }
}
