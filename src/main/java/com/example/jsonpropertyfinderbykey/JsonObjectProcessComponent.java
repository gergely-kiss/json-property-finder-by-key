package com.example.jsonpropertyfinderbykey;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    static List<String> keyList = new ArrayList<String>();
    static int i = 0;

    public void printData()
    {
        String jsonObject = service.getMockObject().toString();
        String keyToFind = "name";
        System.out.println("JSON: " + jsonObject);
        check(keyToFind, JsonParser.parseString(jsonObject));
        System.out.println("list size: " + list.size());
        System.out.println(list);

    }

    private static void check(String key, JsonElement jsonElement)
    {
        i++;
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
                System.out.println("---entrySet----next-level- " + i);
                System.out.println(entrySet);
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
