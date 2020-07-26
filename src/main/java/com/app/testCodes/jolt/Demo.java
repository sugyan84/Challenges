package com.app.testCodes.jolt;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Demo {

    public static void main(String[] args) throws Exception {
        OuterBox outerBox = new OuterBox();
        outerBox.setDomainName("Finance");
        outerBox.setPrice(10700);
        Box smallBox = new Box();
        smallBox.setName("Demo Box");
        smallBox.setNickName("box");
        smallBox.setSize(5);
        outerBox.setSmallBox(smallBox);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        //Encoding Starts
        String jsonRepresentation = objectMapper.writeValueAsString(outerBox);
        System.out.println("Obj as JSON String = " + jsonRepresentation);
        String encodedString = Base64.getEncoder().encodeToString(jsonRepresentation.getBytes("UTF-8"));

        System.out.println("encodeString = " + encodedString);

        //-------------------------------------------------------------------------------------------------------
        System.out.println("\n");

        //Decoding Starts
        byte[] decode = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decode, "UTF-8");
        System.out.println("Obj decoded as JSON String = " + decodedString);

        //Read Jolt Spec
        List<Object> specs = JsonUtils.filepathToList("src/main/resources/inputs/jolt/spec_1.json");
        Chainr chainr = Chainr.fromSpec(specs);

        Object inputJSON = JsonUtils.jsonToObject(decodedString);
        Object transformedOutput = chainr.transform(inputJSON);

        System.out.println("Transformed O/P = " + JsonUtils.toPrettyJsonString(transformedOutput));

        //Read in the form of Map.
        Map<String, Object> map = objectMapper
                .readValue(JsonUtils.toJsonString(transformedOutput), new TypeReference<Map<String, Object>>() {
                });

        System.out.println("\n\nRBO Structure:\n--------------");
        map.entrySet().stream().forEach(System.out::println);

    }
}

class Box {
    private String name;
    private int size;
    private String nickName;

    Box() {
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    int getSize() {
        return size;
    }

    void setSize(final int size) {
        this.size = size;
    }

    String getNickName() {
        return nickName;
    }

    void setNickName(final String nickName) {
        this.nickName = nickName;
    }
}

class OuterBox {
    private String domainName;
    private int price;
    private Box smallBox;

    OuterBox() {
    }

    String getDomainName() {
        return domainName;
    }

    void setDomainName(final String domainName) {
        this.domainName = domainName;
    }

    int getPrice() {
        return price;
    }

    void setPrice(final int price) {
        this.price = price;
    }

    Box getSmallBox() {
        return smallBox;
    }

    void setSmallBox(final Box smallBox) {
        this.smallBox = smallBox;
    }
}
