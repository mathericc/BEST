/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package best;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class BEST {

    Scanner scan = new Scanner(System.in);

    static class AINP {

        static int SIGFIT, IC, PH, MMC, NAME, TITLE;
        static int IS[][];
        static double[] LBETA;
        static int[] VB;
    }

    static class AAAA {

        static int BELL, I1, I2, ISTEP, NDP, NS, NC, AA, T;
        static double[][] RCC;
    }

    static class BBBB {

        static int PHCOR, NB, VO, MMACID;
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

    static class HHHH {

        static int DLB, KCVERR, BETERR, SGF, BERBET;
    }

    int I, K;
    int K1, K2, KSTEP = 0;
    int MM;

// TODO: INPUT ROUTINE (Página 18 do livro)
//    int V, CB;
//    void INPUT() { // 111:
//        I = 1;
//        for (; I <= AAAA.NDP; I++) {
//            V = BBBB.VO + AINP.VB[I];
//            CB = AINP.VB[I] * BBBB.NB / V;
//            K = 1;
//            for (; K <= 1; K++) {
//                if (MM == 0 && AAAA.RCC[I][K] < 0) {
//                    AAAA.RCC[I][K] = Math.pow(10, AAAA.RCC[I][K]);
//                }
//            }
//        }
//    }
    
    void BODY() { // SUBROUNTINE BODY (Página 22 do livro)
        int NFIR = 1;
        double SW = 0;
        
        if (N == -2 || N == 1) { 
            NFIR = 1; 
        }
            
    }

    public BEST() {
        GGGG.NREF = 0;
        AAAA.BELL = 7;
        LLLL.LUNI = 5;
        LLLL.LUNO = 6;
        DDDD.FAST = 1;

        System.out.println("PROGRAMA BEST");
        System.out.println("RAMUNMAS J. MONTEKAITIS");
        System.out.println("VERSION 10/10/91");
        System.out.println("REAL*8 VARIABLES");

        System.out.println("FILE USAGE:");
        System.out.println("FOR001.DAT - OUTPUT");
        System.out.println("FOR002.DAT - SCRATCH (COMPONENTS)");
        System.out.println("FOR003.DAT - SCRATCH (LOG BETA VALUES)");
        System.out.println("FOR004.DAT - INPUT (ORIGINAL DATA)");
        System.out.println("ERROR.DAT - (LOGGING OPTION 31)");

        K = 1;
        for (; K <= 7; K++) {
            I = 1;
            for (; I <= 111; I++) {
                AAAA.RCC[I][K] = 0;
            }
        }

        MM = 0;

        // CALL INPUT
        AAAA.I1 = 1;
        AAAA.I2 = AAAA.NDP;
        AAAA.ISTEP = 1;

        this.OPTION(); // CALL OPTION
    }

    int MCH;
    int NDUM;

    void OPTION() { // SUBROUNTINE OPTION 70: 
        System.out.println("OPTIONS: ");
        MCH = Integer.parseInt(scan.nextLine());
        NDUM = 1;

        // CALL BODY
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
        this.OPTION(); // GO TO 70
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
        this.OPTION(); // GO TO 70
    }

    void POINTS() { // 18:
        System.out.println("INITIAL, FINAL (or -1), STEP (3I2) or RETURN"); // 10:
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
            AAAA.ISTEP = KSTEP;
        }
        if (K2 < 0) {
            AAAA.I2 = AAAA.NDP;
        }
        this.OPTION(); // GO TO 70
    }

    void BETA_VALUES() { // 59:
        // TODO
//        for (int i = 1; i < AAAA.NS; i++) {
//            System.out.println(AINP.LBETA[i]);
//            System.out.println(IS[I, K
//            ]);
//            
//            System.out.println(, NAME(K), K = 1, NC);
//        }
        while (true) { // 48:
            System.out.println("ENTER \"I\" OF LOG BETA TO CHANGED or RETURN"); // 49:
            int I = Integer.parseInt(scan.nextLine());
            if (I < 1) {
                this.OPTION(); // GO TO 70
            }
            if (I > AAAA.NS) {
                continue; // GO TO 48
            }
            System.out.println("ENTER NEW LOG BETA (" + AAAA.I2 + ")?"); // 53:
            AINP.LBETA[I] = Integer.parseInt(scan.nextLine());
            // GO TO 59
        }
    }
}
