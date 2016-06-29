package fr.latombe.jenkins.junit.attachments;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
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
