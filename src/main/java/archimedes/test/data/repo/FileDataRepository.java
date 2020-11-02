package archimedes.test.data.repo;

import archimedes.test.data.model.Data;
import org.springframework.stereotype.Repository;

@Repository
public class FileDataRepository<X extends Data> implements DataRepository<X> {
    @Override
    public X getAllData() {
        return null;
    }
}
