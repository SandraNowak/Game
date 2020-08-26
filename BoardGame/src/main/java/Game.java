import java.util.ArrayList;

public class Game {

    public Game() {
        pawnPosition.setX(0);
        pawnPosition.setY(0);
        pawnPosition.setDirection(Direction.NORTH);
    }

    PawnPosition pawnPosition = new PawnPosition();
    Board board = new Board(10, 10);

    public void setBoard(Board board) {
        this.board = board;
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

    public ArrayList<ObstaclePosition> getForbidenArrea() {
        return forbidenArrea;
    }

    public void setForbidenArrea(ArrayList<ObstaclePosition> forbidenArrea) {
        this.forbidenArrea = forbidenArrea;
    }

    ArrayList<ObstaclePosition> forbidenArrea = new ArrayList();

    private boolean ForbidenPawnPosition(PawnPosition pp){
        if(pp.getX()<0 ||   pp.getX() >= board.getSizeX()
                || pp.getY()<0 ||   pp.getY()>=board.getSizeY()) return true;
        for(ObstaclePosition op:forbidenArrea) {
            if (op.getPositionX() == pp.getX() && op.getPositionY() == pp.getY()) return true;
        }
        return false;

    }

    private boolean ForbidenPawnPositionUsingStreams(PawnPosition pp){
        if(pp.getX()<0 ||   pp.getX() >= board.getSizeX()
                || pp.getY()<0 ||   pp.getY()>=board.getSizeY()) return true;

        return forbidenArrea.stream()
                .anyMatch(o ->o.getPositionX()==pp.getX()&& o.getPositionY()==pp.getY());

    }




    private void movePawn() {
        PawnPosition temporaryPawnPosition = new PawnPosition();
        temporaryPawnPosition.setX(pawnPosition.getX());
        temporaryPawnPosition.setY(pawnPosition.getY());
        temporaryPawnPosition.setDirection(pawnPosition.getDirection());

        if (temporaryPawnPosition.getDirection() == Direction.NORTH) {
            temporaryPawnPosition.setY(temporaryPawnPosition.getY() - 1);
        } else if (temporaryPawnPosition.getDirection() == Direction.SOUTH) {
            temporaryPawnPosition.setY(temporaryPawnPosition.getY() + 1);
        } else if (temporaryPawnPosition.getDirection() == Direction.WEST) {
            temporaryPawnPosition.setX(temporaryPawnPosition.getX() - 1);
        } else if (temporaryPawnPosition.getDirection() == Direction.EAST) {
            temporaryPawnPosition.setX(temporaryPawnPosition.getX() + 1);
        }
        if (!ForbidenPawnPositionUsingStreams(temporaryPawnPosition)){
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
