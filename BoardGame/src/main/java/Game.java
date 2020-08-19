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

    private void movePawn() {
        if (!canIMakeMove()) {
            return;
        }
        if (pawnPosition.getDirection() == Direction.NORTH) {
            pawnPosition.setY(pawnPosition.getY() + 1);
        } else if (pawnPosition.getDirection() == Direction.SOUTH) {
            pawnPosition.setY(pawnPosition.getY() - 1);
        } else if (pawnPosition.getDirection() == Direction.WEST) {
            pawnPosition.setX(pawnPosition.getX() - 1);
        } else if (pawnPosition.getDirection() == Direction.EAST) {
            pawnPosition.setX(pawnPosition.getX() + 1);
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

    private boolean canIMakeMove() {
        if (pawnPosition.getDirection() == Direction.NORTH) {
            return canIMakeMoveNorthDirection();
        }
        if (pawnPosition.getDirection() == Direction.WEST) {
            return canIMakeMoveWestDirection();
        }
        if (pawnPosition.getDirection() == Direction.EAST) {
            return canIMakeMoveEastDirection();
        }
        if (pawnPosition.getDirection() == Direction.SOUTH) {
            return canIMakeMoveSouthDirection();
        }
        return true;
    }

    private boolean canIMakeMoveNorthDirection() {
        if (pawnPosition.getX() == 0 & pawnPosition.getY() == 0) return false;
        if (pawnPosition.getX() == board.getSizeX() - 1 & pawnPosition.getY() == 0) return false;
        if (pawnPosition.getY() == obstacklePosition.getPositionY() - 1) return false;

        return true;
    }

    private boolean canIMakeMoveEastDirection() {
        if ((pawnPosition.getX() == board.getSizeX() - 1) & pawnPosition.getY() == 0) return false;
        if (pawnPosition.getX() == board.getSizeX() - 1 & pawnPosition.getY() == board.getSizeY() - 1) return false;
        if (obstacklePosition != null && pawnPosition.getX() == obstacklePosition.getPositionX() + 1) return false;

        return true;
    }

    private boolean canIMakeMoveSouthDirection() {
        if (pawnPosition.getX() == 0 & pawnPosition.getY() == board.getSizeY() - 1) return false;
        if (pawnPosition.getX() == board.getSizeX() - 1 & pawnPosition.getY() == board.getSizeY() - 1) return false;
        if (obstacklePosition != null && pawnPosition.getY() == obstacklePosition.getPositionY() + 1) return false;

        return true;
    }

    private boolean canIMakeMoveWestDirection() {
        if (pawnPosition.getX() == 0 & pawnPosition.getY() == 0) return false;
        if (pawnPosition.getX() == 0 & pawnPosition.getY() == board.getSizeY() - 1) return false;
        if (obstacklePosition != null && pawnPosition.getX() == obstacklePosition.getPositionX() - 1) return false;

        return true;
    }
}
