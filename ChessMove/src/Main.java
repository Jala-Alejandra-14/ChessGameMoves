import java.util.Scanner;

public class Main {

    public static String[] PIECE_CHESS = {  "Pawn", "Knight", "Bishop", "Rook", "Queen",
            "King","pawn", "knight", "bishop", "rook",
            "queen", "king"};
    public static String[][] CHESSBOARD = { {"a8","b8","c8","d8","e8","f8","g8","h8"},
            {"a7","b7","c7","d7","e7","f7","g7","h7"},
            {"a6","b6","c6","d6","e6","f6","g6","h6"},
            {"a5","b5","c5","d5","e5","f5","g5","h5"},
            {"a4","b4","c4","d4","e4","f4","g4","h4"},
            {"a3","b3","c3","d3","e3","f3","g3","h3"},
            {"a2","b2","c2","d2","e2","f2","g2","h2"},
            {"a1","b1","c1","d1","e1","f1","g1","h1"}};

    public static String [] letters = {"a","b","c","d","e","f","g","h"};

    public static String piece;
    public static String positionInitial;
    public static String positionTarget;

    public static void main(String[] args) {
        showChessBoard();
        chessPiece ();
        initialPosition ();
        targetPosition ();
        canMove();
    }
    public static void showChessBoard() {
        for (int x=0; x < CHESSBOARD.length; x++) {
            System.out.print("|");
            for (int y=0; y < CHESSBOARD[x].length; y++) {
                System.out.print (CHESSBOARD[x][y]);
                if (y!=CHESSBOARD[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    public static void chessPiece (){
        Scanner inPut = new Scanner(System.in);
        boolean verificationPiece = false;
        while(verificationPiece == false){
            System.out.println("Name of the chess piece");
            String pieceChess = inPut.nextLine();
            verificationPiece = verifyThatThePartExists(pieceChess);
            piece = pieceChess;
        }
    }

    public static boolean verifyThatThePartExists(String pieceChess){
        for(int i=0; i<PIECE_CHESS.length;i++) {
            if(PIECE_CHESS[i].equals(pieceChess)){
                return true;
            }
        }
        return false;
    }

    public static void initialPosition (){
        Scanner inPut = new Scanner(System.in);
        boolean verificationPositionInitial= false;

        while(verificationPositionInitial == false){
            System.out.println("Initial position: ");
            String positionChess = inPut.nextLine();
            verificationPositionInitial = verifyThatPosition(positionChess);
            positionInitial = positionChess;
        }
    }

    public static void targetPosition (){
        Scanner inPut = new Scanner(System.in);
        boolean verificationPositiontarget= false;

        while(verificationPositiontarget == false){
            System.out.println("Target position: ");
            String positionTargetChess = inPut.nextLine();
            verificationPositiontarget = verifyThatPosition(positionTargetChess);
            positionTarget = positionTargetChess;
        }
    }

    public static boolean verifyThatPosition(String position){
        for (int x=0; x < CHESSBOARD.length; x++) {
            for (int y=0; y < CHESSBOARD[x].length; y++) {
                if(CHESSBOARD[x][y].equals(position)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void outOfPlace(){
        System.out.println("False");
        System.exit(0);
    }

    public static void canMove(){
        switch (piece){
            case "Pawn":
                if(moviePawn()){
                    System.out.println("True");
                }else{
                    outOfPlace();
                }
                break;
            case "Knight":
                System.out.println("Entre en caballo");
                if(movieKnight()){
                    System.out.println("True");
                }else{
                    outOfPlace();
                }
                break;
            case "Bishop":
                if(movieBishop()){
                    System.out.println("True");
                }else{
                    outOfPlace();
                }
                break;
            case "Rook":
                if(movieRook()){
                    System.out.println("True");
                }else{
                    outOfPlace();
                }
                break;
            case "Queen":
                if(movieBishop() || movieRook()){
                    System.out.println("True");
                }else{
                    outOfPlace();
                }
                break;
            case "King":
                if(movieKing() || moviePawn() || movieKingBack()){
                    System.out.println("True");
                }else{
                    outOfPlace();
                }
                break;
        }
    }
    public static boolean moviePawn(){
        String[] parts = positionInitial.split("|");
        String letterInitial = parts[0];
        int numberInitial = Integer.parseInt(parts[1]);

        String[] partsTwo = positionTarget.split("|");
        String letterTarget = partsTwo[0];
        int numberTarget = Integer.parseInt(partsTwo[1]);

        if(letterInitial.equals(letterTarget)){
            int numberFinal = numberInitial + 1;
            if(numberFinal == numberTarget){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean movieRook(){
        String[] parts = positionInitial.split("|");
        String letterInitial = parts[0];
        int numberInitial = Integer.parseInt(parts[1]);

        String[] partsTwo = positionTarget.split("|");
        String letterTarget = partsTwo[0];
        int numberTarget = Integer.parseInt(partsTwo[1]);

        if(letterInitial.equals(letterTarget) || numberInitial == numberTarget){
            if(numberTarget>= 1 || numberTarget<= 8){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    public static boolean movieBishop() {

        String[] parts = positionInitial.split("|");
        String letterInitial = parts[0];
        int numberInitial = Integer.parseInt(parts[1]);

        String[] partsTwo = positionTarget.split("|");
        String letterTarget = partsTwo[0];
        int numberTarget = Integer.parseInt(partsTwo[1]);

        int positionStart = positionOfTheLetter(letterInitial);
        int positionFinal = positionOfTheLetter(letterTarget);

        int numberToAdvance = numberTarget - numberInitial;

        if(letters[positionStart - numberToAdvance] == letters[positionFinal]){
            return true;
        } else if (letters[positionStart + numberToAdvance] == letters[positionFinal]) {
            return true;
        }

        return false;
    }

    public static boolean movieKing() {

        String[] parts = positionInitial.split("|");
        String letterInitial = parts[0];
        int numberInitial = Integer.parseInt(parts[1]);

        String[] partsTwo = positionTarget.split("|");
        String letterTarget = partsTwo[0];
        int numberTarget = Integer.parseInt(partsTwo[1]);

        int positionStart = positionOfTheLetter(letterInitial);
        int positionFinal = positionOfTheLetter(letterTarget);

        int movieFinallyBack = numberInitial + 1;
        int movieFinallyBack2 = numberInitial - 1;

        if(letters[positionStart - 1] == letters[positionFinal]){
            if(movieFinallyBack2 == numberTarget){
                return true;
            }
            return true;
        } else if (letters[positionStart + 1] == letters[positionFinal]) {
            if(movieFinallyBack == numberTarget){
                return true;
            }
        }

        return false;
    }
    public static boolean movieKingBack(){
        String[] parts = positionInitial.split("|");
        String letterInitial = parts[0];
        int numberInitial = Integer.parseInt(parts[1]);

        String[] partsTwo = positionTarget.split("|");
        String letterTarget = partsTwo[0];
        int numberTarget = Integer.parseInt(partsTwo[1]);

        if(letterInitial.equals(letterTarget)){
            int numberFinal = numberInitial - 1;
            if(numberFinal == numberTarget){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean movieKnight(){
        String[] parts = positionInitial.split("|");
        String letterInitial = parts[0];
        int numberInitial = Integer.parseInt(parts[1]);

        String[] partsTwo = positionTarget.split("|");
        String letterTarget = partsTwo[0];
        int numberTarget = Integer.parseInt(partsTwo[1]);

        int positionStart = positionOfTheLetter(letterInitial);
        int positionFinal = positionOfTheLetter(letterTarget);

        int boxesTraveled = numberInitial + 2;
        int movieBack = numberInitial - 2 ;


        if(letters[positionStart - 1] == letters[positionFinal]){
            System.out.println(movieBack);
            if(boxesTraveled == numberTarget){
                return true;
            } else if (movieBack == numberTarget) {
                return true;
            }
        } else if (letters[positionStart + 1] == letters[positionFinal]) {
            if(boxesTraveled == numberTarget){
                return true;
            } else if (movieBack == numberTarget) {
                return true;
            }
        }
        return false;
    }

    public static int positionOfTheLetter(String letterInitial) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(letterInitial)) {
                return i;
            }
        }
        return 0;
    }

}