
import java.io.*;

public class LineBreaker {
    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);
        StringBuffer FormattedText = new StringBuffer();
        int LineLenght = Integer.parseInt(args[1]);
        String encoding;
        switch (args[2]) {
            case "windows-1251":
                encoding = "windows-1251";
                break;
            case "Windows-1251":
                encoding = "windows-1251";
                break;
            case "ISO-8859-1":
                encoding = "ISO-8859-1";
                break;
            case "US-ASCII" :
                encoding = "US-ASCII";
                break;
            case "Macintosh":
                encoding = "x-MacCyrillic";
                break;
            default:
                encoding = "UTF-8";
        }

        if (file.exists()) {
            try {
                BufferedReader stream = new BufferedReader(new InputStreamReader (new FileInputStream(file), encoding));
                String line;
                while ((line = stream.readLine()) != null) {
                   // System.out.println(line);
                    FormattedText = FormattedText.append(line);
                }
            }
            catch (IOException ei) {
                ei.printStackTrace();
            }

            int count = 0;
            for (int i = 0; i < FormattedText.length(); i++) {

                if (count >= LineLenght && FormattedText.charAt(i) == ' ') {
                    FormattedText.deleteCharAt(i);
                    //FormattedText.insert(i,'\n');
                    //FormattedText.insert(i,'\r\n');
                    FormattedText.insert(i, System.getProperty("line.separator"));
                    count = -1;
                }
                count++;
            }
            System.out.println();
            System.out.println("Display preview? [y]/[n]");
            try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                if (reader.readLine().equalsIgnoreCase("y")) {
                    System.out.println();
                    System.out.println(FormattedText);
                }
                else {}
            }
            catch (IOException eio) {eio.getMessage();}

            // cast StringBuffer to char Array
            char chars[] = FormattedText.toString().toCharArray();

            // create new file path in the same directory
            int dotIndex = args[0].indexOf(".");
            StringBuilder NewFilePath = new StringBuilder(args[0]).insert(dotIndex, "_formatted");

            try {
                OutputStream os = new FileOutputStream(new File(NewFilePath.toString()));
                //write contents of chars to a file
                for (char c : chars) {
                    os.write(c);
                }
                os.close();

                System.out.println();
                System.out.println("Success! Content written to File.");
            }
            catch (IOException eo) {
                eo.printStackTrace();
            }
        }
        else {
            System.out.println("File doesn't exist or incorrect file path");
        }
    }
}
