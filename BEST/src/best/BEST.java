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

    static class AINP {

        static int SIGFIT, IS, IC, VB, PH, LBETA, MMC, NAME, TITLE;
    }

    static class AAAA {

        static int BELL, I1, I2, ISTEP, NDP, NS, NC, AA, RCC, T;
    }

    static class BBBB {

        static int PHCOR, VO, NB, MMACID;
    }

    static class CCCC {

        static int CC, CS, PHCALC;
    }

    static class DDDD {

        static int NOPT;
        static double FAST;
    }

    static class EEEE {

        static int A;
    }

    static class GGGG {

        static int NREF;
    }

    static class LLLL {

        static int LUNI, LUNO;
    }

    int K1, K2, KSTEP = 0;

    public BEST() {
        GGGG.NREF = 0;
        AAAA.BELL = 7;
        LLLL.LUNI = 5;
        LLLL.LUNO = 6;
        DDDD.FAST = 1;

        this.OPTIONS();
    }

    int MCH;

    /**
     * @param args the command line arguments
     */
    void OPTIONS() { // 70:
        System.out.println("OPTIONS: ");
        MCH = Integer.parseInt(scan.nextLine());

        switch (MCH) {
            case 14: // GO TO 5300
                break;
            case 15: // BELL=7
                AAAA.BELL = 7;
                break;
            case 16: // "SILENT MODE" BELL=SILENT
                AAAA.BELL = 0;
                break;
            case 17: // "SPEED FACTOR" GO TO 17
                SPEED_FACTOR();
                break;
            case 18: // "POINTS" GO TO 18
                POINTS();
                break;
            case 19: // "BETA VALUES" GO TO 59
                BETA_VALUES();
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

    int ISPEED;

    void SPEED_FACTOR() { // 17:
        System.out.println("ENTER SPEED FACTOR 1-5 or hit RETURN");
        int I = Integer.parseInt(scan.nextLine());
        if (I < 0) {
            DDDD.NOPT = 0;
        }
        if (I > 6) {
            DDDD.NOPT = 1;
        }
        if (I > 0 && I < 6) {
            DDDD.FAST = Math.pow(10, I);
        }
        ISPEED = I;
        this.OPTIONS(); // GO TO 70
    }

    void POINTS() { // 18:
        System.out.println("INITIAL, FINAL (or -1), STEP (312) or RETURN"); // 10:
        String[] inp = scan.nextLine().split(" ", 3);
        K1 = Integer.parseInt(inp[0]);
        K2 = Integer.parseInt(inp[1]);
        KSTEP = Integer.parseInt(inp[2]);
        if (K1 > 0 && K1 <= AAAA.NDP) {
            AAAA.I1 = K1;
        }
        if (K2 > 0 && K2 <= AAAA.NDP) {
            AAAA.I2 = K2;
        }
        if (KSTEP > 0) {
            ISPEED = KSTEP;
        }
        if (K2 < 0) {
            AAAA.I2 = AAAA.NDP;
        }
        this.OPTIONS(); // GO TO 70
    }
    
    void BETA_VALUES() { // 59:
        while (true) { // 48:
            System.out.println("ENTER \"I\" OF LOG BETA TO CHANGED or RETURN"); // 49:
            int I = Integer.parseInt(scan.nextLine());
            if (I < 1) { 
                this.OPTIONS(); // GO TO 70
            }
            if (I > AAAA.NS) { 
                continue; // GO TO 48
            }
            System.out.println("ENTER NEW LOG BETA"); // 53:
            AINP.LBETA = Integer.parseInt(scan.nextLine());
            // GO TO 59
        }
    }
}
