package org.osama.dao.tanker;


import org.hibernate.SessionFactory;
import org.osama.model.tanker.NumberTanker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NumberTankerDaoImpl implements NumberTankerDao {
    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public List<NumberTanker> getNumberTankers() {
        TypedQuery<NumberTanker> query = sessionFactory.getCurrentSession().createQuery("from NumberTanker");
        return query.getResultList();
    }
    @Override
    public void saveNumberTanker(NumberTanker numberTanker) {
        sessionFactory.getCurrentSession().save(numberTanker);
    }
    @Override
    public void updateNumberTanker(NumberTanker numberTanker) {
        sessionFactory.getCurrentSession().saveOrUpdate(numberTanker);
    }
    @Override
    public void deleteNumberTanker(int id) {
        NumberTanker numberTanker = sessionFactory.getCurrentSession().get(NumberTanker.class, id);
        sessionFactory.getCurrentSession().delete(numberTanker);
    }
    @Override
    public NumberTanker findNumberTankerById(int id) {
        NumberTanker numberTanker=sessionFactory.getCurrentSession().get(NumberTanker.class,id);
        return numberTanker;
    }
}
