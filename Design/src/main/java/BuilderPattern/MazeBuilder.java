package BuilderPattern;

/**
 *
 * @Description 迷宫构建器抽象类
 * @Author Beta
 * @Date 21:22
 **/
public abstract class MazeBuilder {
    abstract public void builderMaze();

    abstract public void builderRoom();

    abstract public void builderDoor();

    abstract public Maze getMaze();

    protected MazeBuilder() {
    }
}
