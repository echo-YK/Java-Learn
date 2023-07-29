package BuilderPattern;

import lombok.Data;

@Data
public class StandMazeBuilder extends MazeBuilder {

    private Maze curMaze;

    public StandMazeBuilder() {
    }

    @Override
    public void builderMaze() {
        this.curMaze = new Maze();
    }

    @Override
    public void builderRoom() {
        this.curMaze.setRooms(10);
    }

    @Override
    public void builderDoor() {
        this.curMaze.setDoors(8);
    }

    @Override
    public Maze getMaze() {
        return this.curMaze;
    }


}
