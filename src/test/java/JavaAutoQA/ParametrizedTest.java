package JavaAutoQA;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sergey.belonozhko@hp.com
 */
@RunWith(Parameterized.class)
public class ParametrizedTest {
    @Parameterized.Parameter(0)
    public Integer val;
    @Parameterized.Parameter(1)
    public String str;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{1, "1"});
        params.add(new Object[]{5, "5"});

        return params;
    }

    @Test
    public void testSum() throws Exception {
        Assert.assertEquals(val.toString(), str);
    }
}
