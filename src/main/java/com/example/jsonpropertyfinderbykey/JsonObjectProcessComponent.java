package com.example.jsonpropertyfinderbykey;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Component
@AllArgsConstructor
public class JsonObjectProcessComponent
{
    private final MockJsonProviderService service;
    static List<String> list = new ArrayList<String>();

    public void printData()
    {
        String jsonObject = service.getMockObject().toString();
        String keyToFind = "name";
        System.out.println("JSON: " + jsonObject);
        check(keyToFind, JsonParser.parseString(jsonObject));
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("------------------------");
        list = new ArrayList<String>();
        check("flat", JsonParser.parseString(jsonObject));
        System.out.println(list.size());
        System.out.println(list);
    }

    private static void check(String key, JsonElement jsonElement)
    {
        if (jsonElement.isJsonArray())
        {
            for (JsonElement jsonElement1 : jsonElement.getAsJsonArray())
            {
                check(key, jsonElement1);
            }
        } else
        {
            if (jsonElement.isJsonObject())
            {
                Set<Map.Entry<String, JsonElement>> entrySet = jsonElement
                    .getAsJsonObject().entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet)
                {
                    String key1 = entry.getKey();
                    if (key1.equals(key))
                    {
                        list.add(entry.getValue().toString());
                    }
                    check(key, entry.getValue());
                }
            } else
            {
                if (jsonElement.toString().equals(key))
                {
                    list.add(jsonElement.toString());
                }
            }
        }
    }
}
