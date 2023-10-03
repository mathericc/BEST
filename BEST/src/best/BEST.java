/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package best;

import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class BEST {
    Scanner scan = new Scanner(System.in);

    int NREF = 0;
    int BELL = 7;
    int LUNI = 5;
    int LUNO = 6;
    double FAST = 1;
    int NOPT = 1;
    int MCH = 0;
    
    int ISPEED;

    public BEST() {
        this.OPTIONS();
    }

    /**
     * @param args the command line arguments
     */
    void OPTIONS() { // 70:
        MCH = Integer.parseInt(scan.nextLine());

        switch (MCH) {
            case 14: // GO TO 5300
                break;
            case 15: // BELL=7
                BELL = 7;
                break;
            case 16: // "SILENT MODE" BELL=SILENT
                BELL = 0;
                break;
            case 17: // "SPEED FACTOR" GO TO 17
                SPEED_FACTOR();
                break;
            case 18: // "POINTS" GO TO 18
                break;
            case 19: // "BETA VALUES" GO TO 59
                break;
            case 20: // "MILLIMOLES" GO TO 75
                break;
            case 21: // "NORMALITY BASE" GO TO 5225
                break;
            case 22: // "MILLIMOLES EXCESS ACID" GO TO 5225
                break;
            case 23: // "INITIAL VOLUME" GO TO 5225
                break;
            case 24: // "END OF CHANGES" GO TO 80
                break;
            case 25: // "PARABOLIC FUNCTION" CALL PARB
                break;
            case 26: // "APPORTION REMAINDER HYDROGEN TO EXCESS ACID" GO TO 5250
                break;
            case 27: // "READ CURRENT LOG BETA VALUES" GO TO 5215
                break;
            case 28: // "READ CURRENT MILLIMOLES" GO TO 5220
                break;
            case 29: // "CORRECTION ON PH CALCD" GO TO 5225
                break;
            case 30: // "AUTOREFINE MILLIMOLES" CALL STOICH
                break;
            case 31: // "ERROR ANALYSIS" CALL ERROR
                break;
        }
        this.OPTIONS(); // GO TO 70
        // CONTINUE
    }

    void SPEED_FACTOR() { // 17:
        System.out.println("ENTER SPEED FACTOR 1-5 or hit RETURN");
        int I = Integer.parseInt(scan.nextLine());
        if (I < 0) {
            NOPT = 0;
        }
        if (I > 6) {
            NOPT = 1;
        }
        if (I > 0 && I < 6) {
            FAST = Math.pow(10, I);
        }
        ISPEED = I;
        this.OPTIONS(); // GO TO 70
    }
}
