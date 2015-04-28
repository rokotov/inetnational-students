package kotov.interstudents.common.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vkotov on 28.04.2015.
 */
public class JsonStdDateSerializer extends JsonSerializer<Date> {
    private static final DateFormat iso8601Format = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        // clone because DateFormat is not thread-safe
        DateFormat myformat = (DateFormat) iso8601Format.clone();
        String formattedDate = myformat.format(date);
        jgen.writeString(formattedDate);
    }
}
