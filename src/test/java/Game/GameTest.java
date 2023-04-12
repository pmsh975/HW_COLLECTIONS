package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 30);
        Player petya = new Player(1, "Петя", 25);

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 20);
        Player petya = new Player(1, "Петя", 25);

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenDraw() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 20);
        Player petya = new Player(1, "Петя", 20);

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenFirstPlayerNoExist() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 20);
        Player petya = new Player(1, "Петя", 25);

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("борис", "Вася")
        );
    }

    @Test
    public void testWhenSecondPlayerNoExist() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 20);
        Player petya = new Player(1, "Петя", 25);

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "сергей")
        );
    }

    @Test
    public void testWhenBothPlayerNoExist() {
        Game game = new Game();
        Player vasya = new Player(1, "Вася", 20);
        Player petya = new Player(1, "Петя", 25);

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("митя", "сергей")
        );
    }

}