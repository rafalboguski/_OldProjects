package Library.serializers;

import Library.entities.Book;
import com.google.gson.*;
import java.lang.reflect.Type;


public class BookSerializer implements JsonSerializer {


    @Override
    public JsonElement serialize(Object book, Type type, JsonSerializationContext jsonSerializationContext) {
        final Book b = (Book) book;
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", b.getId());
        jsonObject.addProperty("title", b.getTitle());
        jsonObject.addProperty("release_year", b.getReleaseYear());
        jsonObject.addProperty("author", b.getAuthor());
        jsonObject.addProperty("library_id", b.getLibrary().getId());
        jsonObject.addProperty("owner_id", b.getOwner()!=null?b.getOwner().getId():null);
        return jsonObject;
    }


}