package jku.mms.snakegame.model;

import java.util.LinkedList;

/**
 * Snake represents the snake object which moves through the GameBoard and can eat Collectibles.
 */
public class Snake {
    Tile head;
    LinkedList<Tile> body = new LinkedList();

    //TODO: moveUp(), moveDown(), moveLeft(), moveRight(), eat(Collectible)
}
