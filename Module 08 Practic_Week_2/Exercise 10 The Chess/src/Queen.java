public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkBorder(toLine, toColumn)) return false;
        chessBoard.printBoard();
        System.out.println("int line " + line + ", int column " +column+ ", int toLine "+toLine+ ", int toColumn " + toColumn);
        boolean myPath = false;
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        //for horizontal move
        if (toLine == line && toColumn > column) {
            for (int i = 0; i < 8; i++) {
                if (toColumn == (column + i)) {
                    return true;
                } else if (chessBoard.board[toLine][column + i] != null) {
                    return false;
                }
            }
        }
        if (toLine == line && toColumn < column) {
            for (int i = 0; i < 8; i++) {
                if (toColumn == (column - i)) {
                    return true;
                } else if (chessBoard.board[toLine][column - i] != null) {
                    return false;
                }
            }
        }
        if (toLine > line && toColumn == column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + i)) {
                    return true;
                } else if (chessBoard.board[line + i][toColumn] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn == column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line - i)) {
                    return true;
                } else if (chessBoard.board[line - i][toColumn] != null) {
                    return false;
                }
            }
        }

        //for diagonal move
        if (toLine > line && toColumn > column && Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            //return checkPath(chessBoard, line, column, toLine, toColumn, '>', '>');
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + (i * 1)) && toColumn == (column + (i * (1)))) {
                    return true;
                } else if (chessBoard.board[line + (i * 1)][column + (i * (1))] != null) {
                    return false;
                }
            }
        }
        if (toLine > line && toColumn < column && Math.abs(toLine - line) == Math.abs(column - toColumn)) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + (i * 1)) && toColumn == (column + (i * (-1)))) {
                    return true;
                } else if (chessBoard.board[line + (i * 1)][column + (i * (-1))] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn > column && Math.abs(line - toLine) == Math.abs(toColumn - column)) {
            for (int i = 1; i < 8; i++) {
                if (toLine == (line + (i * (-1))) && toColumn == (column + (i * 1))) {
                    return true;
                } else if (chessBoard.board[line + (i * (-1))][column + (i * 1)] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn < column && Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<' , '<');
        }


        return myPath;
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
        for (int i = 0; i < 8; i++) {
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
        return "Q";
    }
}
