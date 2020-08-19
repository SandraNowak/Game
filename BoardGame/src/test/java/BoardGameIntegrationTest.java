import org.junit.Assert;
import org.junit.Test;

public class BoardGameIntegrationTest {

    @Test
    public void ShouldGiveValidResoult(){
        //Assign
        Game game = new Game();

        //Act


        PawnPosition pawnPosition = game.move("M");

        //Assert
        Assert.assertEquals(pawnPosition.getX() , 0);
        Assert.assertEquals(pawnPosition.getY() , 0);
        Assert.assertEquals(pawnPosition.getDirection() , Direction.NORTH);

    }


    @Test
    public void ShouldGiveValidResoult2(){
        //Assign
        Game game = new Game();
        PawnPosition pawnPosition = null;

        //Act


        pawnPosition = game.move("RRMM");

        //Assert
        Assert.assertEquals(pawnPosition.getX() , 0);
        Assert.assertEquals(pawnPosition.getY() , -2);
        Assert.assertEquals(pawnPosition.getDirection() , Direction.SOUTH);

    }

    @Test
    public void ShouldGiveValidResoult3(){
        //Assign
        Game game = new Game();
        PawnPosition pawnPosition = new PawnPosition();

        //Act


        pawnPosition = game.move("LMM");

        //Assert
        Assert.assertEquals(pawnPosition.getX() , 0);
        Assert.assertEquals(pawnPosition.getY() , 0);
        Assert.assertEquals(pawnPosition.getDirection() , Direction.WEST);

    }



    @Test
    public void ShouldGiveValidResoult4(){
        //Assign
        Game game = new Game();
        PawnPosition pawnPosition = new PawnPosition();

        //Act


        pawnPosition = game.move("RMMRM");

        //Assert
        Assert.assertEquals(pawnPosition.getX() , 2);
        Assert.assertEquals(pawnPosition.getY() , -1);
        Assert.assertEquals(pawnPosition.getDirection() , Direction.SOUTH);

    }

    @Test
    public void ShouldNotAllowToGoOnAnObstackle(){
        //Assign
        Game game = new Game();
        PawnPosition pawnPosition = new PawnPosition();
        ObstaclePosition obstaclePosition =  new ObstaclePosition();
        obstaclePosition.setPositionX(0);
        obstaclePosition.setPositionY(-2);
        game.setObstacklePosition(obstaclePosition);


        //Act

        pawnPosition = game.move("RRMM");

        //Assert
        Assert.assertEquals(pawnPosition.getX(),0);
        Assert.assertEquals(pawnPosition.getY(), -1);
        Assert.assertEquals(pawnPosition.getDirection(), Direction.SOUTH);
    }

    @Test
    public void ShouldNotGoBeyondBoardSize(){
        //Assign
        Game game = new Game();
        PawnPosition pawnPosition = new PawnPosition();
        Board board = new Board(10,10);
        game.setBoard(board);


        //Act

        pawnPosition = game.move("RMMMMMMMMMM");

        //Assert
        Assert.assertEquals(pawnPosition.getX(),9);
        Assert.assertEquals(pawnPosition.getY(), 0);
        Assert.assertEquals(pawnPosition.getDirection(), Direction.EAST);

    }

    @Test
    public void ShouldMoveWhenOffObstacleWhenOnObstacle(){
        //Assign
        Game game = new Game();
        PawnPosition pawnPosition = new PawnPosition();
        Board board = new Board(10,10);
        game.setBoard(board);

        ObstaclePosition obstaclePosition =  new ObstaclePosition();
        obstaclePosition.setPositionX(0);
        obstaclePosition.setPositionY(0);
        game.setObstacklePosition(obstaclePosition);

        //Act

        pawnPosition = game.move("RMMMMMMMMMM");

        //Assert
        Assert.assertEquals(pawnPosition.getX(),9);
        Assert.assertEquals(pawnPosition.getY(), 0);
        Assert.assertEquals(pawnPosition.getDirection(), Direction.EAST);

    }

}
