package project.mangaeden.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ImageDeserializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray chapterArray = json.getAsJsonArray();
        return new Image(
                chapterArray.get(0).getAsInt(),
                chapterArray.get(1).getAsString(),
                chapterArray.get(2).getAsInt(),
                chapterArray.get(3).getAsInt()
        );
    }
}
