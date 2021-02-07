package com.randomcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> cards = Main.prepareCards();

        if (args[0].equals("Random")) {
            ArrayList<String> randoms = Main.getRandom(cards, Integer.parseInt(args[1]));
            args = randoms.toArray(new String[0]);
        }

        int total = Main.getTotal(cards, args);

        System.out.println("Total: " + total);
    }

    /**
     * Randomized cards
     *
     * @param cards
     * @param totalRandom
     * @return
     */
    public static ArrayList<String> getRandom(HashMap<String, Integer> cards, int totalRandom) {
        int min = 0;
        int max = 52;

        ArrayList<String> randomizedCards = new ArrayList<>();

        /* nak 3 random */
        Object[] cardsArray = cards.keySet().toArray();

        for (int i = 0; i < totalRandom; i++) {
            int r = (int) (Math.random() * (max - min)) + min;

            randomizedCards.add(cardsArray[r].toString());
        }
        System.out.println(randomizedCards);
        return randomizedCards;
    }

    /**
     * Calculate the totals
     *
     * @param cards
     * @param cardTypes
     * @return int
     */
    public static int getTotal(
            HashMap<String, Integer> cards,
            String[] cardTypes) {
        int total = 0;

        for (int a = 0; a < cardTypes.length; a++) {
            if (!Objects.isNull(cards.get(cardTypes[a]))) {
                total += cards.get(cardTypes[a]);
            }
        }

        return total;
    }

    /**
     * Prepare cards
     */
    public static HashMap<String, Integer> prepareCards() {
        HashMap<String, Integer> cards = new HashMap<>();

        String[] types = {"diamond", "heart", "spade", "club"};
        String[] points = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};

        for (int i = 0; i < types.length; i++) {
            for (int a = 0; a < points.length; a++) {
                cards.put(types[i] + points[a], a + 1);
            }
        }

        return cards;
    }
}
