package archimedes.test.data;

import archimedes.test.data.model.Data;
import archimedes.test.data.repo.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class DataService<X extends Data> {
    private final DataRepository<X> dataRepository;

    public DataService(DataRepository<X> dataRepository) {
        this.dataRepository = dataRepository;
    }
}
