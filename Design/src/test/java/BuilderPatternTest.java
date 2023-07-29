import BuilderPattern.Maze;
import BuilderPattern.MazeGame;
import BuilderPattern.StandMazeBuilder;
import org.junit.Test;

/**
 * 
 * @Description 建造者模式测试类 
 * @Author Beta
 * @Date 21:28
 **/
public class BuilderPatternTest {

    @Test
    public void mockBuilderStandMaze() {
        MazeGame mazeGame = new MazeGame();
        mazeGame.createMaze(new StandMazeBuilder());
        Maze maze = mazeGame.getMaze();
        System.out.println(maze);
    }

}
