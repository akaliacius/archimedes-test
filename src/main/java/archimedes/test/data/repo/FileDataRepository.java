package archimedes.test.data.repo;

import archimedes.test.data.model.CallData;
import archimedes.test.data.model.OperatorData;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static archimedes.test.utils.JsonUtil.getAllData;

@Repository
public class FileDataRepository {
    public List<CallData> getAllCalls(String file) throws IOException {
        return getAllData(new File(file), CallData.class, obj -> obj instanceof CallData)
                .stream()
                .filter(object -> object instanceof CallData)
                .map(object -> (CallData) object)
                .collect(Collectors.toList());
    }

    public List<OperatorData> getAllOperators(String file) throws IOException {
        return getAllData(new File(file), OperatorData.class, obj -> obj instanceof OperatorData)
                .stream()
                .filter(object -> object instanceof OperatorData)
                .map(object -> (OperatorData) object)
                .collect(Collectors.toList());
    }
}
