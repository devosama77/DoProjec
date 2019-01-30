package org.osama.dao.tanker;

import org.hibernate.SessionFactory;
import org.osama.model.tanker.Remark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class RemarkDaoImpl implements RemarkDao {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public List<Remark> getRemarks() {
        TypedQuery<Remark> query = sessionFactory.getCurrentSession().createQuery("from Remark");
        return query.getResultList();
    }

    @Override
    public void saveRemark(Remark remark) {
        sessionFactory.getCurrentSession().save(remark);
    }

    @Override
    public void updateRemark(Remark remark) {
        sessionFactory.getCurrentSession().saveOrUpdate(remark);
    }

    @Override
    public void deleteRemark(int id) {
        Remark remark = sessionFactory.getCurrentSession().get(Remark.class, id);
        sessionFactory.getCurrentSession().delete(remark);
    }
    @Override
    public Remark findRemarkById(int id) {
        Remark remark=sessionFactory.getCurrentSession().get(Remark.class,id);
        return remark;
    }


}