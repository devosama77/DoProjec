package org.osama.dao.tanker;

import org.hibernate.SessionFactory;
import org.osama.model.tanker.SizeTanker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class SizeTankerDaoImpl implements SizeTankerDao {
    @Autowired
    public SessionFactory sessionFactory;
    @Override
    public List<SizeTanker> getSizeTankers() {
        TypedQuery<SizeTanker> query = sessionFactory.getCurrentSession().createQuery("from SizeTanker");
        return query.getResultList();
    }

    @Override
    public void saveSizeTanker(SizeTanker sizeTanker) {
        sessionFactory.getCurrentSession().save(sizeTanker);
    }

    @Override
    public void updateSizeTanker(SizeTanker sizeTanker) {
        sessionFactory.getCurrentSession().saveOrUpdate(sizeTanker);
    }

    @Override
    public void deleteSizeTanker(int id) {
        SizeTanker book = sessionFactory.getCurrentSession().get(SizeTanker.class, id);
        sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    public SizeTanker findSizeTankerById(int id) {
        SizeTanker sizeTanker=sessionFactory.getCurrentSession().get(SizeTanker.class,id);
        return sizeTanker;
    }


}