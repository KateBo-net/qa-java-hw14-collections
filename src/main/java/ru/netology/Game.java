package ru.netology;

import java.util.HashMap;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        return players.get(name);
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
