package examples.flowanalysis;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for XMLInjection
 *
 * @see examples.flowanalysis.XMLInjection
 * @author yoneta
 */
public class XMLInjectionTest
{

    /**
     * Parasoft Jtest UTA: Test for createXMLDocumentAndStoreData(Document, String, String, String, String)
     *
     * @see examples.flowanalysis.XMLInjection#createXMLDocumentAndStoreData(Document, String, String, String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCreateXMLDocumentAndStoreData() throws Throwable
    {
        // Given
        XMLInjection underTest = new XMLInjection();

        // When
        Document document = mock(Document.class);
        Element createElementResult = mock(Element.class);
        Element createElementResult2 = mock(Element.class);
        when(document.createElement(nullable(String.class))).thenReturn(createElementResult, createElementResult2);
        String sUserId = "sUserId"; // UTA: デフォルト値
        String sUserName = "sUserName"; // UTA: デフォルト値
        String sDataType = "sDataType"; // UTA: デフォルト値
        String sData = "sData"; // UTA: デフォルト値
        underTest.createXMLDocumentAndStoreData(document, sUserId, sUserName, sDataType, sData);

    }
}
