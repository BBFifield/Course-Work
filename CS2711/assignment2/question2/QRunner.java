import java.io.File;
import java.io.IOException;

/**
 * Created by Brandon on 2017-02-02. Student I.D.: 201238730
 * This program creates a QEndnoteProcessor object which converts endnotes into a different format at the end of
 * the document.
 */
public class QRunner {
    public static void main(String[] args) {
        //Set up a new File object which take the document Endnotes.txt.
        File file = new File("Endnotes.txt");
        try {
            //Create a QEndnoteProcessor object and call its process() method.
            QEndnoteProcessor endnoteProcessor = new QEndnoteProcessor(file);
            endnoteProcessor.process();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
