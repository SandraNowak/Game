import java.util.ArrayList;

public class Game {

    public Game() {
        pawnPosition.setX(0);
        pawnPosition.setY(0);
        pawnPosition.setDirection(Direction.NORTH);
    }

    PawnPosition pawnPosition = new PawnPosition();
    ObstaclePosition obstacklePosition = null;
    Board board = new Board(10, 10);

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setObstacklePosition(ObstaclePosition obstacklePosition) {
        this.obstacklePosition = obstacklePosition;

    }

    public PawnPosition move(String comand) {
        char[] com = convertToCharArray(comand);
        for (char ch : com) {
            switch (ch) {
                case 'R':
                    rotateRight();
                    break;
                case 'L':
                    rotateLeft();
                    break;
                case 'M':
                    movePawn();
                    break;

            }
        }
        return pawnPosition;
    }

    ArrayList<ObstaclePosition> forbidenArrea = new ArrayList();

    private boolean ForbidenPawnPosition(PawnPosition pp){
        for(ObstaclePosition op:forbidenArrea) {
            if (op.getPositionX() == pp.getX() && op.getPositionY() == pp.getY()) return true;
        } return false;
    }


    private void movePawn() {
        PawnPosition temporaryPawnPosition = new PawnPosition();
        temporaryPawnPosition.setX(pawnPosition.getX());
        temporaryPawnPosition.setY(pawnPosition.getY());
        temporaryPawnPosition.setDirection(pawnPosition.getDirection());

        if (temporaryPawnPosition.getDirection() == Direction.NORTH) {
            temporaryPawnPosition.setY(temporaryPawnPosition.getY() + 1);
        } else if (temporaryPawnPosition.getDirection() == Direction.SOUTH) {
            temporaryPawnPosition.setY(temporaryPawnPosition.getY() - 1);
        } else if (temporaryPawnPosition.getDirection() == Direction.WEST) {
            temporaryPawnPosition.setX(temporaryPawnPosition.getX() - 1);
        } else if (temporaryPawnPosition.getDirection() == Direction.EAST) {
            temporaryPawnPosition.setX(temporaryPawnPosition.getX() + 1);
        }
        if (!ForbidenPawnPosition(temporaryPawnPosition)){
            pawnPosition.setX(temporaryPawnPosition.getX());
            pawnPosition.setY(temporaryPawnPosition.getY());
            pawnPosition.setDirection(temporaryPawnPosition.getDirection());
        }
    }

    private void dontMovePawn() {
    }

    private void rotateLeft() {
        if (pawnPosition.getDirection() == Direction.NORTH) {
            pawnPosition.setDirection(Direction.WEST);
        } else if (pawnPosition.getDirection() == Direction.WEST) {
            pawnPosition.setDirection(Direction.SOUTH);
        } else if (pawnPosition.getDirection() == Direction.SOUTH) {
            pawnPosition.setDirection(Direction.EAST);
        } else if (pawnPosition.getDirection() == Direction.EAST) {
            pawnPosition.setDirection(Direction.NORTH);
        }
    }

    private void rotateRight() {
        if (pawnPosition.getDirection() == Direction.NORTH) {
            pawnPosition.setDirection(Direction.EAST);
        } else if (pawnPosition.getDirection() == Direction.EAST) {
            pawnPosition.setDirection(Direction.SOUTH);
        } else if (pawnPosition.getDirection() == Direction.SOUTH) {
            pawnPosition.setDirection(Direction.WEST);
        } else if (pawnPosition.getDirection() == Direction.WEST) {
            pawnPosition.setDirection(Direction.NORTH);
        }
    }

    public char[] convertToCharArray(String comand) {
        char[] ch = comand.toCharArray();
        return ch;
    }


}
