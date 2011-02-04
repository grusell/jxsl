package xsltestengine.engine;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.servicelibre.jxsl.xsltestengine.DocumentSource;
import com.servicelibre.jxsl.xsltestengine.XslTestEngine;

/**
 * A system test that verifies the components of the XslTestEngine framework
 * work together successfully. Uses Spring to bootstrap the application for use
 * in a test environment.
 */
@ContextConfiguration
/* Note that if no file is specified to @ContextConfiguration, it is derived as <classname>-context.xml, 
 * so in this case, it expects to find XslTestEngineIntegrationTest-context.xml in the current directory */
@RunWith(SpringJUnit4ClassRunner.class)
public class XslTestEngineIntegrationTest
{

    // The object being tested
    @Autowired
    private XslTestEngine engine;

    @Autowired
    private File rootFolder;

    @Autowired
    private DocumentSource documentSource;

    @Test
    public void testXslTestEngine()
    {
        assertNotNull(rootFolder);
        assertTrue(rootFolder.exists());

        assertNotNull(documentSource);
        assertTrue(documentSource.getDocumentIds().size() > 0);
        System.out.println(documentSource.getDocumentIds());
        
        assertNotNull(engine);
        // TODO return a list of runReport or something similar?
        int run = engine.run();

        assertNotNull(run);
        
        System.err.println(run);
        
    }

}
