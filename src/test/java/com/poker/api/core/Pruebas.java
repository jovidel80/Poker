package com.poker.api.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class Pruebas {

    @Test
    public void test() {

        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, hasSize(3));
        assertThat(list, contains(5, 2, 4));
        assertThat(list, containsInAnyOrder(4, 2, 5));
        assertThat(list, everyItem(greaterThanOrEqualTo(2)));
        assertThat(list, not(hasItem(9)));
    }
}
