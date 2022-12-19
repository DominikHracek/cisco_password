import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

class Main{

    // int cnt;
    // Recursive helper function, adds/removes characters
    // until len is reached
    static void generate(String[] arr, int i, String s, int len) throws IOException, UnsupportedFlavorException, AWTException, InterruptedException {
        // base case
        if (i == 0) // when len has been reached
        {
            // print it out
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection clipboard = new StringSelection(s);
            c.setContents(clipboard, clipboard);
            Transferable t = c.getContents(null);
            String stringclipboard = (String) t.getTransferData(DataFlavor.stringFlavor);
            Robot robot = new Robot();
            robot.mouseMove(215, 100);
            robot.delay(20);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(20);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(20);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(20);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(20);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(20);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(20);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println(stringclipboard);
            robot.delay(1000);
            // cnt++;

            return;
        }
        for (int j = 0; j < len; j++)
        {

            // Create new string with next character
            // Call generate again until string has
            // reached its len
            String appended = s + arr[j];
            generate(arr, i - 1, appended, len);
            System.out.println("");
        }

        // iterate through the array

        return;
    }

    // Driver code
    public static void main(String[] args) throws IOException, UnsupportedFlavorException, AWTException, InterruptedException {
        String[] input = {
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "1", "2" ,"3" , "4", "5", "6", "7", "8", "9", "0",
                "#","&","@","{","}","<",">","*","đ","Đ","[","]","ł","Ł","$","ß","¤","×","÷","€","|","\"",
                ")", "(", "ú","/", "=", "%", "´", "ˇ", String.valueOf('"'), "ů", "§", "!", "¨", "'", "?", ":", ",", ".", "-", "_"
        };
        int len = input.length;
        for (int i = 4; i <= len; i++)
        {
            generate(input, i, "", len);
        }
    }

}