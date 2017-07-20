package com.dipegroup.sample.services.mongo;

import com.dipegroup.sample.models.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Service
public class SequenceService {

    private final MongoOperations mongoOperations;

    @Autowired
    public SequenceService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Long getNextSequenceId(String key) {
        /** Get <code>Sequence</code> object by collection name*/
        Query query = new Query(Criteria.where("id").is(key));

        /** Increase field sequence by 1*/
        Update update = new Update();
        update.inc("sequence", 1);

        // указываем опцию, что нужно возвращать измененный объект
        /** Set option about returning new object*/
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Sequence sequence = mongoOperations.findAndModify(query, update, options, Sequence.class);

        // if no sequence set id value 'key'
        if (sequence == null) {
            sequence = setSequenceId(key, 1L);
        }

        return sequence.getCurrent();
    }

    public void cleanSequences(String key) {
        Query query = new Query(Criteria.where("id").is(key));
        if (mongoOperations.exists(new Query(), Sequence.class)) {
            mongoOperations.remove(query, Sequence.class);
        }
    }

    public Sequence setSequenceId(String key, Long id) {
        Sequence sequence = new Sequence();
        sequence.setId(key);
        sequence.setCurrent(id);
        mongoOperations.save(sequence);
        return sequence;
    }

    public void updateSequence(String key, Long delta) {
        Query query = new Query(Criteria.where("id").is(key));
        Update update = new Update();
        update.inc("sequence", delta);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);

        mongoOperations.findAndModify(query, update, options, Sequence.class);
    }

}
