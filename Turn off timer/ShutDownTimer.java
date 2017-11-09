import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShutDownTimer {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int HoursToSeconds = Integer.parseInt(args[0])*3600;
        int MinutesToSeconds = Integer.parseInt(args[1])*60;
        int Seconds = Integer.parseInt(args[2]);

        String command = "shutdown /s /t " + String.valueOf(HoursToSeconds + MinutesToSeconds + Seconds);
        try
        {
            Process process = Runtime.getRuntime().exec(command);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
