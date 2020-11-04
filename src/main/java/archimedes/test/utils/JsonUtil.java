package archimedes.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class JsonUtil {

    private JsonUtil(){
        throw new IllegalStateException();
    }

    public static List<Object> getAllData(File file, Class klass, Predicate<Object> validation) throws IOException {
        var mapper = new ObjectMapper();
        var rootNode = mapper.readTree(file);
        return StreamSupport.stream(rootNode.findValue("data").spliterator(), false)
                .map(jsonNode -> {
                    try {
                        @SuppressWarnings("unchecked") var obj = mapper.treeToValue(jsonNode, klass);
                        if(validation.test(obj)) return obj;
                        else throw new IllegalArgumentException();
                    } catch (JsonProcessingException e){
                        throw new IllegalStateException("serialisation failed", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
