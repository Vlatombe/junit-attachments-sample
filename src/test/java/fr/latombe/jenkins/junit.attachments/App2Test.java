package fr.latombe.jenkins.junit.attachments;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class App2Test {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws IOException {

        assertTrue(true);
        File myattachment = new File("myattachment");

        myattachment.createNewFile();
        FileWriter fileWriter = new FileWriter(myattachment);
        try {
            fileWriter.append("This is a JUnit-attachment sample");
            System.out.println("[[ATTACHMENT|" + myattachment.getAbsolutePath() + "]]");
        } finally {
            fileWriter.close();
        }
    }
}
