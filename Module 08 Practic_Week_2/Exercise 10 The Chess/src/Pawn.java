public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean isWhite() {
        return "White".equals(getColor());
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkBorder(toLine, toColumn)) return false;
        if (
                chessBoard.board[toLine][toColumn] != null &&
                        chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        if (column == toColumn &&
                isWhite() &&
                line == 1 &&
                toLine == 3 &&
                chessBoard.board[2][column] == null) {
            return true;
        }
        if (column == toColumn &&
                !isWhite() &&
                line == 6 &&
                toLine == 4 &&
                chessBoard.board[5][column] == null) {
            return true;
        }

        if (toLine == (line + (isWhite() ? 1 : -1)) &&
                (toColumn == (column + 1) || toColumn == (column - 1)) &&
                !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
