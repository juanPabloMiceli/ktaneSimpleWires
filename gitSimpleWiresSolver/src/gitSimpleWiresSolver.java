import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Scanner;



public class gitSimpleWiresSolver
{
    static final int yellowQuantity = 7;
    static final int blueQuantity = 8;
    static final int blackQuantity = 9;
    static final int whiteQuantity = 10;
    static final int redQuantity = 11;



    private static void clearScreen(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }


    private static String[] askForWiresData()
    {
        String[] simpleWiresData = new String[6];

        Scanner input = new Scanner(System.in);
        boolean whileflag = false;
        int i = 0;

        clearScreen();

        System.out.println("Colores y como escribirlos: ");
        System.out.println("ROJO = RO");
        System.out.println("AZUL = AZ");
        System.out.println("AMARILLO = AM");
        System.out.println("BLANCO = BL");
        System.out.println("NEGRO = NE");
        System.out.println("READY = R");

        while(!whileflag) {
            for (int j = 0; (j < 6) && (!whileflag); j++) {
                whileflag = false;
                System.out.println("Ingrese el color del cable numero " + (i + 1) + "como se indica arriba, o presione la R para terminar: ");

                switch (input.next()) {
                    case "RO":
                    case "ro":
                        simpleWiresData[i] = "RO";
                        break;
                    case "AZ":
                    case "az":
                        simpleWiresData[i] = "AZ";
                        break;
                    case "AM":
                    case "am":
                        simpleWiresData[i] = "AM";
                        break;
                    case "BL":
                    case "bl":
                        simpleWiresData[i] = "BL";
                        break;
                    case "NE":
                    case "ne":
                        simpleWiresData[i] = "NE";
                        break;
                    case "R":
                    case "r":
                        simpleWiresData[i] = "R";
                        whileflag = true;
                        break;
                    default:
                        clearScreen();
                        System.out.println("Ingresaste ese color mal boludito.");
                        i--;
                }
                i++;
            }
        }

        return simpleWiresData;
    }

    private static synchronized void Wait(int timeout) {
        try {
            gitSimpleWiresSolver.class.wait(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private static void controlMouse(int dir, int[] screenSize)
    {
        int x, y;
        try {
            Robot robot = new Robot();

            switch (dir)
            {
                case 0:
                    x = (193*screenSize[0])/396;
                    y = (5*screenSize[1])/12;
                    break;
                case 1:
                    x = (53*screenSize[0])/96;
                    y = (109*screenSize[1])/216;
                    break;
                case 2:
                    x = (193*screenSize[0])/384;
                    y = (65*screenSize[1])/108;
                    break;
                case 3:
                    x = (29*screenSize[0])/64;
                    y = (109*screenSize[1])/216;
                    break;
                default:
                    x = (193*screenSize[0])/384;
                    y = (109*screenSize[1])/216;
            }
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            Wait(25);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        String[] simpleWiresData;
        simpleWiresData = askForWiresData();

        for(int i=0;(i<simpleWiresData.length) && (simpleWiresData[i]!="R");i++)
        {
            System.out.println(simpleWiresData[i]);
        }

    }

}
