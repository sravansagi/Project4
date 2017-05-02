package com.sravan.and.jokelib;


import java.util.Random;

public class Jokes {
    private static final String[] JOKE_FACTORY = {"Today a man knocked on my door and asked for a small donation towards the local swimming pool. " +
            "I gave him a glass of water.",
            "You're not fat, you're just... easier to see.",
            "When my boss asked me who is the stupid one, me or him? I told him everyone knows he doesn't hire stupid people.",
            "I can totally keep secrets. It's the people I tell them to that can't."};

    public String getJoke(){
        return JOKE_FACTORY[new Random().nextInt(JOKE_FACTORY.length)];
    }
}
