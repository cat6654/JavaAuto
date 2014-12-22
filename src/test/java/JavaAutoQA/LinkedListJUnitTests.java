package JavaAutoQA;

import LinkedCollection.LinkedList;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by akosatuchenko on 12/18/2014.
 */
public class LinkedListJUnitTests {

    @Test
    public void TestLinkedListAdd(){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("normal string");
        linkedList.add("@#$%^&blablabla~!@#$%^&*(");
        linkedList.add("another normal string");
        Assert.assertTrue("Expected element is \"@#$%^&blablabla~!@#$%^&*(\" " , linkedList.contains("@#$%^&blablabla~!@#$%^&*("));
    }

    @Test
    public void TestLinkedListRemove(){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("normal string");
        linkedList.add("@#$%^&blablabla~!@#$%^&*(");
        linkedList.add("another normal string");
        linkedList.remove("@#$%^&blablabla~!@#$%^&*(");
        Assert.assertFalse("Expected removed is \"@#$%^&blablabla~!@#$%^&*(\" ", linkedList.contains("@#$%^&blablabla~!@#$%^&*("));
    }

}
