package com.joyce.jpa;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joyce.jpa.model.ResponseModel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonTest {
    static Logger logger = LoggerFactory.getLogger(JsonTest.class);

    @Test
    public void test1() throws JsonProcessingException {
        ResponseModel model = new ResponseModel();
        model.setCode("9999").setError("未知错误");

        String jsonStr = buildJsonStrBy(model);
        logger.info("jsonStr == " + jsonStr);

    }

    String buildJsonStrBy(ResponseModel model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper.writeValueAsString(model);
    }

    ResponseModel deserializingToCouponUserBy(String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL , false);
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT , false);
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT , false);
//        mapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES , false);
//        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES , false);
        return mapper.readValue(jsonStr, ResponseModel.class);
    }

}
