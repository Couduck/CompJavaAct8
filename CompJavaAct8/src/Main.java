import javax.swing.*;

public class Main
{
    public static void main(String[] args)  //Metodo Main
    {
        MenuActividad8();
    }

    public static void MenuActividad8()     //Permite poder implementar el JOptionPane al método main
    {
        Deck baraja = new Deck();   //Se crea un objeto de tipo Deck que se usará para el programa

        //Opciones del programa
        String[] opcionesMenuPrincipal = {
                "A) Reordenar baraja",
                "B) Agarrar carta de hasta arriba",
                "C) Agarrar carta aleatoria",
                "D) Pedir mano",
                "E) Salir del programa"};

        String eleccionCompleta;        //Captura el valor de la string elegida completa
        char eleccionSwit ='0';         //Guarda el primer caracter de la opcion elegida para poder utilizarse en un switch
        int salirProceso;               //La opcion que guarda el int que dicta si salir del programa o no
        boolean accionValida = false;   //Boolean que permite que las opciones puedan repetirse indefinidamente hasta que el usuario desee salir del programa

        do
        {
            accionValida = true;

            try
            {
                //Despliega el panel de opciones posibles dentro del programa
                eleccionCompleta = (String) JOptionPane.showInputDialog(null,"Seleccione una opcion: ", "MENU ACTIVIDAD 8: Baraja Poker", JOptionPane.QUESTION_MESSAGE,null, opcionesMenuPrincipal, opcionesMenuPrincipal[0] );
                eleccionSwit = eleccionCompleta.charAt(0);
            }

            catch(NullPointerException a) //El usuario seleccionó la opcion de cerrar el mensaje o de cancelar
            {
                //Se pregunta si el usuario desea salir del programa usando unicamente la opcion de si o no
                salirProceso = JOptionPane.showConfirmDialog(null,"Quieres salir del programa?", "ACTIVIDAD 8: Baraja Poker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                //Si presiona Si
                if(salirProceso == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null,"Programa terminado", "ACTIVIDAD 8", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                //Si presiona No
                else
                {
                    accionValida = false;
                    continue;
                }
            }

            //Dependiendo de la opción elegida, se ejecuta la acción especifica
            switch(eleccionSwit)
            {
                case 'A':
                    baraja.Shuffle(false);
                    accionValida = false;
                    break;

                case 'B':
                    baraja.Head();
                    accionValida = false;
                    break;

                case 'C':
                    baraja.Pick();
                    accionValida = false;
                    break;

                case 'D':
                    baraja.Hand();
                    accionValida = false;
                    break;

                case 'E':
                    System.exit(0);
                    break;
            }
        }
        while(!accionValida);
    }
}