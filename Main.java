import java.util.Scanner;


public class Main {
  static int NREF = 0;
  static int BELL = 7;
  static int LUNI = 5;
  static int LUNO = 6;
  static int FAST = 1;

  static int MCH = 0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    MCH = Integer.parseInt(scan.nextLine()); 

    switch (MCH) {
      case 14: break; // GO TO 5300
      case 15: break; // BELL=7
      case 16: break; // "SILENT MODE" BELL=SILENT
      case 17: break; // "SPEED FACTOR" GO TO 17
      case 18: break; // "POINTS" GO TO 18
      case 19: break; // "BETA VALUES" GO TO 59
      case 20: break; // "MILLIMOLES" GO TO 75
      case 21: break; // "NORMALITY BASE" GO TO 5225
      case 22: break; // "MILLIMOLES EXCESS ACID" GO TO 5225
      case 23: break; // "INITIAL VOLUME" GO TO 5225
      case 24: break; // "END OF CHANGES" GO TO 80
      case 25: break; // "PARABOLIC FUNCTION" CALL PARB
      case 26: break; // "APPORTION REMAINDER HYDROGEN TO EXCESS ACID" GO TO 5250
      case 27: break; // "READ CURRENT LOG BETA VALUES" GO TO 5215
      case 28: break; // "READ CURRENT MILLIMOLES" GO TO 5220
      case 29: break; // "CORRECTION ON PH CALCD" GO TO 5225
      case 30: break; // "AUTOREFINE MILLIMOLES" CALL STOICH
      case 31: break; // "ERROR ANALYSIS" CALL ERROR
    }
    // GO TO 70
    // CONTINUE
  }
}