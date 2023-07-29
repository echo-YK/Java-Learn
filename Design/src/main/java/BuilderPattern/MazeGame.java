package BuilderPattern;

/**
 *
 * @Description 迷宫游戏
 * @Author Beta
 * @Date 21:21
 **/
public class MazeGame {

    /**
     * 保存构建后的迷宫
     */
    private Maze maze;

    /**
     *
     * @Description 使用指定的迷宫构建器构建迷宫
     * 该方法使用抽象类MazeBuilder作为接口
     * 使得用户可以定制不同的MazeBuilder，并且在MazeGame层面，简化了构建过程
     * 复合对对扩展开发，对修改闭合的原则
     * @Param mazeBuilder 指定的迷宫构建器实现类
     * @Return void
     * @Author Beta
     * @Date 21:22
     **/
    public void createMaze(MazeBuilder mazeBuilder) {
        mazeBuilder.builderMaze();
        mazeBuilder.builderDoor();
        mazeBuilder.builderRoom();
        this.maze = mazeBuilder.getMaze();
    }

    /**
     *
     * @Description 返回构建好的迷宫
     * 这里做了一些调整，设计模式原书是使用builder对象获取迷宫
     * 但是从逻辑上来看，不够合理，所以使用MazeGame返回迷宫
 * @Return BuilderPattern.Maze
     * @Author Beta
     * @Date 21:23
     **/
    public Maze getMaze() {
        return this.maze;
    }

}
