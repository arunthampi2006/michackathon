/**
 * Created by pankajmisra on 10/16/16.
 */
public class SampleEntityDAO extends CouchbaseEntityDAO<SampleEntity> {
    public SampleEntityDAO(CouchbaseClient couchbaseClient, Class<SampleEntity> type) {
        super(couchbaseClient, type);
    }
}
