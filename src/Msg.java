import javax.swing.*;
import java.lang.Math;

public class Msg {
    /*
     * Declare all private instance variables
     */
    private static int correct = 0;//number of correct
    private static JFrame j = new JFrame() ;
    private static Window _w;

    //GUI images to be used
    private static ImageIcon _i;
    private static ImageIcon _t;
    private static ImageIcon home;
    private static ImageIcon bye;
    private static ImageIcon dog;
    private static ImageIcon nice;
    private static ImageIcon idk;
    private static ImageIcon perf;
    private static ImageIcon end;

    //Give players options to choose from
    private static final String[] OPTIONS = {"ACCEPT INVITATION", "DECLINE INVITATION"};
    private static final String[] HOME = {"BEGIN GAME", "THE BASICS(HELP ME)", "EXIT"};
    private static final String[] DIFFICULTY = {"EASY", "HARD"};


    //Constructor where the game starts/mechanisms of the game
    public Msg() {

        /*
         * Initialize all private instance variables
         */
        _w = new Window();
        _i = new ImageIcon((getClass().getResource("assets/tea.jpg")));
        home = new ImageIcon((getClass().getResource("assets/home.png")));
        _t = new ImageIcon((getClass().getResource("assets/angry.png")));
        dog = new ImageIcon((getClass().getResource("assets/dog.png")));
        bye = new ImageIcon((getClass().getResource("assets/bye.png")));
        nice = new ImageIcon((getClass().getResource("assets/nice.png")));
        end = new ImageIcon((getClass().getResource("assets/end.png")));
        idk = new ImageIcon((getClass().getResource("assets/idkboy.png")));
        perf = new ImageIcon((getClass().getResource("assets/perf.png")));

        start();//Starting screen

        //Opening message
        _w.msg("You have entered the virtual world of the Arithmetic Problem Generator!"
                + "\n Mr. Rico thought your Math was not good enough after failing a Math FRQ."
                + "\n So he has forced you into practicing your basic Math skills."
                + "\n Through this virtual reality, you shall master math.");
        home();//Menu

        int m = _w.option1(DIFFICULTY, "What Level Would You Like", idk);//Gives player option to choose level of difficulty

        if(m == 1) {//Hard mode
            JOptionPane.showMessageDialog(j, "You have chosen Hard mode. "
                    + "\nThis mode includes numbers 1-100 and includes addition, subtraction, and multiplication!");
            Hard();//Starts the game in hard mode
        }

        //Regular-easy mode
        int length = Ask();//number of problems player wants to do

        for(int i=1; i<= length; i++) {//for loop used to give player length amount of questions
            int random = (int)(Math.random()*2);//to randomize the operations of math
            if(random == 0) {
                Addition(i);//gives addition problem
            }
            else if(random ==1) {
                Substraction(i);//gives subtraction problem
            }
            /*
             * At the end, when length amount of question have been given, show the score the player got
             */
            if(i == length) {
                JOptionPane.showMessageDialog(j, "Your total score was: "+ (double)correct/length*100 + "%");
                if((double)(correct/length)*100 == 100.0) {
                    _w.msg2("Awesome, you have master the Martial Arts of Math. :)", perf);
                }
                else if((double)correct/length <100) {
                    _w.msg2("Try better next time!You will master the arts of Math one day :)", end);
                }

            }
        }
        //END CREDITS
        JOptionPane.showMessageDialog(null, "END CREDITS: \n Code: Nathan \n User: You \n Thanks for Playing!");
    }
    /*
     * Method that takes care of the hard mode
     * Hard mode has: ADDITION, SUBTRACTION, and MULTIPLICATION
     */
    public static void Hard() {
        int length = Ask();

        for(int i=1; i<= length; i++) {
            int random = (int)(Math.random()*4);//Gets a random number between 0 and 4

            if(random == 0) {
                Addition1(i);//Addition problem
            }
            else if(random ==1) {
                Substraction1(i);//Subtraction problem
            }
            else if(random ==3) {
                Multiplication1(i);//Multiplication problem
            }
            if(i == length) {//Show player their score and after this if statement, for loop ends
                JOptionPane.showMessageDialog(j, "Your total score was: "+ (double)correct/length*100 + "%");
                if((double)(correct/length)*100 == 100.0) {
                    _w.msg2("Awesome, you have master the Martial Arts of Math. :)", perf);
                }
                else if((double)correct/length <100) {
                    _w.msg2("Try better next time!You will master the arts of Math one day :)", end);
                }

            }
        }
        //END CREDITS and EXIT
        JOptionPane.showMessageDialog(null, "END CREDITS: \n Code: Nathan \n User: You \n Thanks for Playing!");
        System.exit(0);
    }

    /*
     * Addition method
     * Hard Mode(# 0 - 100)
     */
    public static void Addition1(int numQ) {
        try { //tries the code and if there is an exception, it will stop error and move on catch

            int num1 = (int)(Math.random()*100);
            int num2 = (int)(Math.random()*100);
            String user = JOptionPane.showInputDialog(null, "Question #"+ numQ +": " + num1 + "+" + num2);
            if(user.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "You cannot leave the box blank.");
            }

            int result = Integer.parseInt(user);//Converts the integer input to a String

            if(result == num1 + num2) {
                _w.msg2("You got this question correct!", nice);
                correct++;
            }
            else {
                _w.msg2("You are wrong!", _t);
                JOptionPane.showMessageDialog(j, "The correct answer is: " + (num1 + num2));
            }
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You can only put integers in the box. You have been penalized and will get this question immediatedly wrong!");
        }
        catch(NullPointerException n) {
            _w.msg("You have left your teacher sad and formally rejected your invitation. \n Taking you back to homescreen now");
            start();
        }

    }

    /*
     * Multiplication method
     * Hard Mode(# 0 - 100)
     */
    public static void Multiplication1(int numQ) {
        try { //tries the code and if there is an exception, it will stop error and move on catch

            int num1 = (int)(Math.random()*100);
            int num2 = (int)(Math.random()*100);
            String user = JOptionPane.showInputDialog(null, "Question #"+ numQ +": " + num1 + "*" + num2);
            if(user.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "You cannot leave the box blank.");
            }

            int result = Integer.parseInt(user);//Converts the integer input to a String

            if(result == num1*num2) {
                _w.msg2("You got this question correct!", nice);
                correct++;
            }
            else {
                _w.msg2("You are wrong!", _t);
                JOptionPane.showMessageDialog(j, "The correct answer is: " + (num1*num2));
            }
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You can only put integers in the box. You have been penalized and will get this question immediatedly wrong!");
        }
        catch(NullPointerException n) {
            _w.msg("You have left your teacher sad and formally rejected your invitation. \n Taking you back to homescreen now");
            start();
        }

    }

    /*
     * Subtraction method
     * Hard Mode(# 0 - 100)
     */
    public static void Substraction1(int numQ) {
        try {//tries the code and if there is an exception, it will stop error and move on catch
            int num1 = (int)(Math.random()*100);
            int num2 = (int)(Math.random()*(num1+1));
            String user = JOptionPane.showInputDialog(null, "Question #"+ numQ +": " + num1 + "-" + num2);

            if(user.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "You cannot leave the box blank.");
            }
            int result = Integer.parseInt(CheckStr(user));//Converts the integer input to a String

            if(result == num1 - num2) {
                _w.msg2("You got this question correct!", nice);
                correct++;
            }
            else {
                _w.msg2("You are wrong!", _t);
                JOptionPane.showMessageDialog(j, "The correct answer is: " + (num1 - num2));
            }
        } catch(NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "You can only put integers in the box. You have been penalized and will get this question immediatedly wrong!");
        }
        catch(NullPointerException n) {
            _w.msg("You have left your teacher sad and formally rejected your invitation. \n Taking you back to homescreen now");
            start();
        }
    }

    /*
     * Basically acts as a menu screen
     */
    public static void home() {
        int x = _w.option1(HOME, "What will you do now?", home);
        if( x==2) {
            _w.msg2("You should still practice though!", dog);
            System.exit(0);
        }
        else if(x==1) {
            _w.msg("You have entered the virtual world of the Arithmetic Problem Generator!"
                    + "\n How to PLAY:"
                    + "\n Your goal is to get as many questions correct."
                    + "\n All questions are randomly generated, and no question will result in a negative number."
                    + "\n You can only input numbers and not inputting one will cause you to be penalized. "
                    + "\n Typing 'exit' will start the process of closing the program. Hope you think Math is easy like lemon pie.");
            home();
        }
    }

    //Begins the math generator with an invitation to the player
    public static void start() {
        int m = _w.option1(OPTIONS, "Accept this Invitation to this Math Challenge?", _i);
        if(m == 1) {
            System.exit(0);
            _w.msg2("Quitting already!", dog);
        }
    }

    /*
     * Converts the int to a string and returns the input(as a string)
     */
    public static String CheckStr(String input)

    {
        try {//tries the code and if there is an exception, it will stop error and move on catch
            Integer.parseInt(input);
        } catch (Exception e) {
            if(input.equalsIgnoreCase("exit"))
            {
                JOptionPane.showMessageDialog(null, "You have exited the Arithmetic Problem Generator. \n You will be sent back to the real world in 3...");
                JOptionPane.showMessageDialog(null, "2....");
                JOptionPane.showMessageDialog(null, "1....");
                _w.msg2("Hasta la vista!", bye);
                System.exit(0);
            }

        }

        return input;
    }

    /*
     * Addition method
     * Easy MODE(# 0 -10)
     */
    public static void Addition(int numQ) {
        try { //tries the code and if there is an exception, it will stop error and move on catch

            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*10);
            String user = JOptionPane.showInputDialog(null, "Question #"+ numQ +": " + num1 + "+" + num2);
            if(user.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "You cannot leave the box blank.");
            }

            int result = Integer.parseInt(user);//Converts the integer input to a String

            if(result == num1 + num2) {
                _w.msg2("You got this question correct!", nice);
                correct++;
            }
            else {
                _w.msg2("You are wrong!", _t);
                JOptionPane.showMessageDialog(j, "The correct answer is: " + (num1 + num2));
            }
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You can only put integers in the box. You have been penalized and will get this question immediatedly wrong!");
        }
        catch(NullPointerException n) {
            _w.msg("You have left your teacher sad and formally rejected your invitation. \n Taking you back to homescreen now");
            start();
        }

    }

    /*
     * Subtraction Method
     * Easy Mode(# 0-10)
     */
    public static void Substraction(int numQ) {
        try {//tries the code and if there is an exception, it will stop error and move on catch

            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*(num1+1));
            String user = JOptionPane.showInputDialog(null, "Question #"+ numQ +": " + num1 + "-" + num2);

            if(user.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "You cannot leave the box blank.");
            }
            int result = Integer.parseInt(CheckStr(user));//Converts the integer input to a String

            if(result == num1 - num2) {
                _w.msg2("You got this question correct!", nice);
                correct++;
            }
            else {
                _w.msg2("You are wrong!", _t);
                JOptionPane.showMessageDialog(j, "The correct answer is: " + (num1 - num2));
            }
        } catch(NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "You can only put integers in the box. You have been penalized and will get this question immediatedly wrong!");
        }
        catch(NullPointerException n) {
            _w.msg("You have left your teacher sad and formally rejected your invitation. \n Taking you back to homescreen now");
            start();
        }
    }

    /*
     * Returns a the number of questions the player wants to answer
     */
    public static int Ask() {
        int length = 0;
        boolean b = false;
        while(!b) {//Makes sure an answer is given
            try {//try-catch to prevent any errors/exceptions revolving around the use of Strings/Ints
                String c = JOptionPane.showInputDialog(null, "How many questions would you like to answer?");
                length = Integer.parseInt(CheckStr(c));//Converts the integer input to a String
                b = true;
                if(length == 0) {//if player says zero times
                    JOptionPane.showMessageDialog(j, "You should really try to do some math :(");
                }

            }catch(Exception e) {//makes sure the player is only using integers
                JOptionPane.showMessageDialog(null, "You can only put integers in the box. Please reenter the # of problems you want to do.");
            }
        }
        return length;
    }
}
