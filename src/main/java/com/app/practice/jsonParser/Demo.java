package com.app.practice.jsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.api.platform.csi.csdp.EstimateWaitTime;
import com.paypal.api.platform.csi.csdp.EstimateWaitTimeResponse;


public class Demo {

    private static enum ApiType {
        DEFAULT("default"),
        ALL_QUEUE("all_queue"),
        QUEUE_SPECIFIC("queue_specific");

        private String value;

        ApiType(String string) {
            this.value = string;
        }

        public static ApiType fromString(String text) {
            for (ApiType b : ApiType.values()) {
                if (b.value.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        
        /*double d = 3.51342;

        String str = "-1";

        double parseDouble = Double.parseDouble(str);

        int intVal = (int) parseDouble;
        
        System.out.println(intVal);*/

        ApiType sUgyan = ApiType.fromString("all_queue");

        System.out.println(sUgyan);

        String jsonString =
                "{\"Ingrid_Voice_IB\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":10000,\"ewt\":10000,\"hit\":0,\"clc\":\"CDAA100\"},\"NA_Limitations_NM_IB\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":10000,\"ewt\":10000,\"hit\":0,\"clc\":\"CDAA100\"},\"IT_QA\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":9.999,\"ewt\":9.999,\"hit\":87,\"clc\":\"CFAA100\"},\"de_ssp_le_livechat\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":9.999,\"ewt\":9.999,\"hit\":0,\"clc\":\"CFAA100\"},\"I_IB\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":10000,\"ewt\":10000,\"hit\":0,\"clc\":\"CDAA100\"},\"e2e_disputes_automation_livechat\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":9.999,\"ewt\":9.999,\"hit\":14,\"clc\":\"CFAA100\"},\"na_ssp_le_livechat\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":604.76663176919,\"ewt\":604.76663176919,\"hit\":95,\"clc\":\"CDAA100\"},\"Ingrid_Voice_Voice\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":740.968361431922,\"ewt\":740.968361431922,\"hit\":100,\"clc\":\"CDAA100\"},\"na_limitations_le_livechat\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":9.999,\"ewt\":9.999,\"hit\":-1,\"clc\":\"CFAA100\"},\"na_disputes_le_livechat\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":5864.67464528069,\"ewt\":5864.67464528069,\"hit\":40,\"clc\":\"CDAA100\"},\"NA_QA_Voice\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":9.999,\"ewt\":9.999,\"hit\":0,\"clc\":\"CFAA100\"},\"I_CB\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":9.999,\"ewt\":9.999,\"hit\":0,\"clc\":\"CFAA100\"},\"na_pss_le_livechat\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":3033.00875003223,\"ewt\":3033.00875003223,\"hit\":100,\"clc\":\"CDAA100\"},\"_IB\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":10000,\"ewt\":10000,\"hit\":0,\"clc\":\"CDAA100\"},\"IT_TEST\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":740.968361431922,\"ewt\":740.968361431922,\"hit\":84,\"clc\":\"CDAA100\"},\"NA_QA_IB\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":10000,\"ewt\":10000,\"hit\":0,\"clc\":\"CDAA100\"},\"NA_Limitations_NM_Voice\":{\"time\":1551242134,\"wt\":0,\"calls\":0,\"wcalls\":0,\"pos\":1,\"wpos\":1,\"aqt\":740.968361431922,\"ewt\":740.968361431922,\"hit\":100,\"clc\":\"CDAA100\"}}";



        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, EstimateWaitTime> map = null;
        try {
             map = objectMapper.readValue(jsonString, new TypeReference<Map<String, EstimateWaitTime>>() {});
        } catch (IOException e) {

        }

        System.out.println("OK");

        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey()+" -- "+entry.getValue().getTime()));


        try {
            JsonNode model = objectMapper.readTree(jsonString);

            EstimateWaitTimeResponse response = new EstimateWaitTimeResponse();

            Iterator<Map.Entry<String, JsonNode>> rootIterator = model.fields();

            rootIterator.forEachRemaining(mapEntry -> {
                EstimateWaitTime waitTimeDetail = new EstimateWaitTime();

                String queueName = mapEntry.getKey();
                waitTimeDetail.setQueueName(queueName);
                JsonNode details = mapEntry.getValue();
                addDetails(waitTimeDetail, details);
                response.getEstimateWaitTimes().add(waitTimeDetail);
            });

            //System.out.println("\nFinally.. " + response.getEstimateWaitTimes().size());

            System.out.println(objectMapper.writeValueAsString(response));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addDetails(final EstimateWaitTime waitTimeDetail, final JsonNode details) {
        if (details != null && waitTimeDetail!=null) {
            details.fields().forEachRemaining(mapEntry -> {
                String key = mapEntry.getKey();

                switch (key) {
                    case "time":
                        waitTimeDetail.setTime(mapEntry.getValue().asText());
                        break;
                    case "wt":
                        waitTimeDetail.setWt(mapEntry.getValue().asText());
                        break;
                    case "calls":
                        waitTimeDetail.setCalls(mapEntry.getValue().asText());
                        break;
                    case "wcalls":
                        waitTimeDetail.setWcalls(mapEntry.getValue().asText());
                        break;
                    case "pos":
                        waitTimeDetail.setPos(mapEntry.getValue().asText());
                        break;
                    case "wpos":
                        waitTimeDetail.setWpos(mapEntry.getValue().asText());
                        break;
                    case "aqt":
                        waitTimeDetail.setAqt(mapEntry.getValue().asText());
                        break;
                    case "ewt":
                        waitTimeDetail.setEwt(mapEntry.getValue().asText());
                        break;
                    case "hit":
                        waitTimeDetail.setHit(mapEntry.getValue().asText());
                        break;
                    case "clc":
                        waitTimeDetail.setClc(mapEntry.getValue().asText());
                        break;
                }
            });
        }
    }
}
