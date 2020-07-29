package Model.Player;

import Model.Board;

public abstract class AbstractPlayer
{
    private int id;
    private String name;
    private String Color;
    private int Score = 0;//Always start from 0
//    private MoveStrategies Java.Strategy;

    //---------------------Private Methods----------------------------------


    //---------------------Public Methods-----------------------------------
    //Constructor
    public AbstractPlayer(int id, String name/*, MoveStrategies strategy*/){
        this.id =id;
        this.name = name;
//        Java.Strategy = strategy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color){
        Color = color;
    }

    public int getScore(){
        return Score;
    }

    public void IncreaseCount(){
        Score++;
    }

    public abstract boolean isComputer();

//    public MoveStrategies getStrategy(){
//        return Java.Strategy;
//    }

    public abstract int getMove(Board board);
}
