package com.sravan.and.jokelib;


import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

/**
 * Created by HP on 5/2/2017.
 */

public class JokesTest {
    private static final String[] JOKE_FACTORY = {"Today a man knocked on my door and asked for a small donation towards the local swimming pool. " +
            "I gave him a glass of water.",
            "You're not fat, you're just... easier to see.",
            "When my boss asked me who is the stupid one, me or him? I told him everyone knows he doesn't hire stupid people.",
            "I can totally keep secrets. It's the people I tell them to that can't."};

    @Test
    public void test() {
        Jokes joker = new Jokes();
        for (int i = 0; i< 100;i++ ){
            Assert.assertTrue(Arrays.asList(JOKE_FACTORY).contains(joker.getJoke()));
        }
    }
}