package com.amos.springcraft.ticToeGame.model;

public class Player {
    private String name;
    PlayingPiece playingPiece;
    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }
}
