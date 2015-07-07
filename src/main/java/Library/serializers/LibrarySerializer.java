package Library.serializers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Library.entities.Book;
import Library.entities.Employee;
import Library.entities.Library;
import com.google.gson.*;
import org.hibernate.Hibernate;

public class LibrarySerializer implements JsonSerializer {


    @Override
    public JsonElement serialize(Object library, Type type, JsonSerializationContext jsonSerializationContext) {
        final Library b = (Library) library;
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", b.getId());
        jsonObject.addProperty("name", b.getName());
        jsonObject.addProperty("city", b.getCity());
        jsonObject.addProperty("street", b.getStreet());
        jsonObject.addProperty("post_code", b.getPostCode());
        jsonObject.addProperty("books_id", new Gson().toJson(b.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList())));
        jsonObject.addProperty("employees_id", new Gson().toJson(b.getEmployees().stream().map(e -> e.getId()).collect(Collectors.toList())));

        return jsonObject;
    }


}