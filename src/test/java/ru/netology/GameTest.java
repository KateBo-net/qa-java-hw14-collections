package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Player player1 = new Player(1, "Sam", 25);
    Player player2 = new Player(2, "Bob", 50);
    Player player3 = new Player(3, "Karl", 35);
    Player player4 = new Player(4, "Max", 50);

    @Test
    public void shouldRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        game.register(player2);

        List<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player3);
        expected.add(player2);
        List<Player> actual = game.getPlayers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotRegisteredException() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player3.getName(), player2.getName()));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1.getName(), player4.getName()));
    }

    @Test
    public void shouldRoundWinFirstPlayer() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round(player2.getName(), player3.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWinSecondPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round(player1.getName(), player2.getName());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundEndWithDraw() {
        Game game = new Game();
        game.register(player2);
        game.register(player4);

        int expected = 0;
        int actual = game.round(player2.getName(), player4.getName());
        Assertions.assertEquals(expected, actual);
    }
}

