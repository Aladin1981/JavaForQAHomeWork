package HwJavaForQA.AccuweatherProject;

import java.io.IOException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    Controller controller = new Controller();

    public void runInterface(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter City");
            String city = scanner.nextLine();

            System.out.println("enter 1 for today weather, 2 for 5 days weather or q for exit");
            String command = scanner.nextLine();
            if(command.equals("q")){
                break;
            }else if (command.equals("2")){

            }else if (command.equals("1")){

            }else {
                System.out.println("Wrong choose, Try again" );
                continue;
            }

            try {
                controller.getWeather(command, city);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                continue;
            }
        }
    }

    // TODO exeption vibrosit i prervat
    public void checkUserInput(String userInput){
//        String i = userInput;
//        if ( i == "q" ) {
//            System.out.println(" exit ");
//        }
//
//    }
//
    }
}