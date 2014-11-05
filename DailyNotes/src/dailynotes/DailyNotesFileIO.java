/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dailynotes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A class to manage saving and reading of files.
 * @author Jeff Crone
 */
public class DailyNotesFileIO {

    /**
     * Saves the text in textToSave to a file pointed to by filename.
     * @param filename The file to save to.
     * @param textToSave The text to save to the file.
     * @return True if the save was successful, false if the save was unsuccessful.
     */
    public static boolean saveFile( String filename, String textToSave )
    {
        File outputFile = new File( filename );
        FileWriter outputWriter = null;
        PrintWriter outputPrinter = null;
        boolean fileSaved = false;//Whether the file has been saved or not. This will be the return value.

        //Split textToSave into lines and put them in an array for easier preservation of the lines.
        String[] textLines = textToSave.split("\\n");

        try
        {
            outputWriter = new FileWriter( outputFile );
            outputPrinter = new PrintWriter( outputWriter );

            for( String line : textLines )
            {//Go through each line and print it to the file.
                outputPrinter.println( line );
            }
            //outputWriter.write(textToSave);
            fileSaved = true;//The file has been saved, so record that.
        }
        catch (IOException ex)
        {
            System.err.println( "Error saving to file \"" + filename + "\": " + ex.getLocalizedMessage() );
            ex.printStackTrace();
            fileSaved = false;//The file didn't save, so record that.
        }
        finally
        {
            //try {
                //outputWriter.close();
                outputPrinter.close();
                return fileSaved;
                //return true;
            //} catch (IOException ex) {
            //    System.err.println( "Error closing file \"" + filename + "\": " + ex.getLocalizedMessage() );
            //    ex.printStackTrace();
            //    return false;
            //}
        }
    }
}
