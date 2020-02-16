package project.mangaeden.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class ChapterDeserializer implements JsonDeserializer {
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray chapterArray = json.getAsJsonArray();
        return new Chapter(
                chapterArray.get(0).getAsInt(),
                chapterArray.get(1).getAsLong(),
                chapterArray.get(2) instanceof JsonNull ? "***" : chapterArray.get(2).getAsString(),
                chapterArray.get(3).getAsString()
        );
    }
}
