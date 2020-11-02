package archimedes.test.data.repo;

import archimedes.test.data.model.Data;

public interface DataRepository<X extends Data> {
    X getAllData();
}
