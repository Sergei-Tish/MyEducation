public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!inBound(toLine, toColumn)) return false;
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        //for horizontal move
        if (toLine == line && toColumn > column) return checkPath(chessBoard, line, column, toLine, toColumn, '=', '>');
        if (toLine == line && toColumn < column) return checkPath(chessBoard, line, column, toLine, toColumn, '=', '<');
        if (toLine > line && toColumn == column) return checkPath(chessBoard, line, column, toLine, toColumn, '>', '=');
        if (toLine < line && toColumn == column) return checkPath(chessBoard, line, column, toLine, toColumn, '<', '=');

        return false;
    }

    private boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, char ratioLines, char ratioColumns) {
        int intIndexLine = 0;
        switch (ratioLines) {
            case '>':
                intIndexLine = 1;
                break;
            case '<':
                intIndexLine = -1;
                break;
        }
        int intIndexColumn = 0;
        switch (ratioColumns) {
            case '>':
                intIndexColumn = 1;
                break;
            case '<':
                intIndexColumn = -1;
                break;
        }
        for (int i = 1; i < 8; i++) {
            if (toLine == (line + (i * intIndexLine)) && toColumn == (column + (i * intIndexColumn))) {
                return true;
            } else if (chessBoard.board[line + (i * intIndexLine)][column + (i * intIndexColumn)] != null) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
