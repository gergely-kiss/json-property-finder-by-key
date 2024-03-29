package com.example.jsonpropertyfinderbykey;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class MockJsonProviderService
{

    public JSONObject getMockObject()
    {
        JSONObject mockObject = new JSONObject();
        mockObject.put("date", "today");
        mockObject.put("time", "now");
        mockObject.put("color", "blue");
        mockObject.put("temp", "hot");
        JSONObject mockObjectLevel11 = new JSONObject();
        mockObjectLevel11.put("flat", "marina");
        mockObjectLevel11.put("name", 12L);
        JSONObject mockObjectLevel12 = new JSONObject();
        mockObjectLevel11.put("flat", "kemp town");
        mockObjectLevel12.put("name", mockObjectLevel11);
        JSONObject mockObjectLevel13 = new JSONObject();
        mockObjectLevel11.put("flat", "station");
        mockObjectLevel13.put("name", true);
        mockObject.put("place_1", mockObjectLevel11);
        mockObject.put("place_2", mockObjectLevel12);
        mockObject.put("place_3", mockObjectLevel13);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(0, "d");
        jsonArray.put(1, "a");
        jsonArray.put(2, "b");
        jsonArray.put(3, mockObjectLevel13);
        mockObject.put("list", jsonArray);
        mockObject.put("list_2", jsonArray);
        return mockObject;
    }
}
