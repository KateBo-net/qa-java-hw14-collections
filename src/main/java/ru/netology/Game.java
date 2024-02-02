package ru.netology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Player with name" + playerName1 + "not found");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player with name" + playerName2 + "not found");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
