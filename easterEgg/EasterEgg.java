package easterEgg;

import codigo.GestionarRistra;

public class EasterEgg {

    public EasterEgg(GestionarRistra ristra) {
        System.out.println("");
        System.out.println(
                "\n____________________________$$$$$$$$_______________________________\n"
                + "C__________________$$$$$$$____________$$$$$$$$$____________________\n"
                + "R________________$$____________________________$$$$________________\n"
                + "E_______________$$_________________________________$$______________\n"
                + "A______________$______________________________________$$___________\n"
                + "D______________$$_______________________________________$$_________\n"
                + "O____________$$__$$__________________________$$__________$$_______\n"
                + "____________$$__$$___$$$$____________$$$$_____$$__________$$$$_____\n"
                + "P_________$$___$$__$$$$__$$________$$$$__$$__$$_____________$$$____\n"
                + "O__I______$$___$$____$$$$____________$$$$____$$_______________$$___\n"
                + "R__A______$$___$$____________________________$$_______________$$___\n"
                + "___G______$$____$$___________________________$$_____________$$_____\n"
                + "___O________$$__$$____$$$$$$_________________$$___________$$$______\n"
                + "____________$$__$$__$$______$$_______________$$_________$$_________\n"
                + "___G________$$__$$__$$______$$_______________$$_______$$___________\n"
                + "___O__________$$$$____$$$$$$_________________$$$$____$$$$__________\n"
                + "___N__________$$$$_________________________$$__$$____$$$___________\n"
                + "___Z___________$$_$$$$$$$$$$$$_________$$$$______$$$$_$$___________\n"
                + "___A_____________$$___$$__________$$$$$_______________$$___________\n"
                + "___L_____________$$_____$$$$$$$________________________$$__________\n"
                + "___E_____________$$____________________________________$$__________\n"
                + "___Z____________$$_____________________________________$$__________\n"
                + "_________________$$_____________________________________$$__________\n");

        ristra.setPuntuacion(ristra.getPuntuacion() + 100);
    }

}
