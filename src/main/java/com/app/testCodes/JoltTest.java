package com.app.testCodes;

import java.util.List;
import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;


/**
 * JOLT framework POC.
 */
public class JoltTest {

    public static void main(String[] args) {
        List<Object> specs = JsonUtils.filepathToList("src/main/resources/inputs/jolt/spec_1.json");
        Chainr chainr = Chainr.fromSpec(specs);

        Object inputJSON = JsonUtils.filepathToObject("src/main/resources/inputs/jolt/input_1.json");
        Object transformedOutput = chainr.transform(inputJSON);
        System.out.println(JsonUtils.toPrettyJsonString(transformedOutput));
    }
}
