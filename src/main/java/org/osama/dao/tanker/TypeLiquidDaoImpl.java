package org.osama.dao.tanker;

import org.hibernate.SessionFactory;
import org.osama.model.tanker.TypeLiquid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TypeLiquidDaoImpl implements TypeLiquidDao {
    @Autowired
    public SessionFactory sessionFactory;
    @Transactional
    @Override
    public List<TypeLiquid> getTypeLiquids() {
        TypedQuery<TypeLiquid> query = sessionFactory.getCurrentSession().createQuery("from TypeLiquid");
        return query.getResultList();
    }
    @Transactional
    @Override
    public void saveTypeLiquid(TypeLiquid typeLiquid) {
        sessionFactory.getCurrentSession().save(typeLiquid);
    }

    @Override
    public void updateTypeLiquid(TypeLiquid typeLiquid) {
        sessionFactory.getCurrentSession().saveOrUpdate(typeLiquid);
    }
    @Transactional
    @Override
    public void deleteTypeLiquid(int id) {
        TypeLiquid typeLiquid = sessionFactory.getCurrentSession().get(TypeLiquid.class, id);
        sessionFactory.getCurrentSession().delete(typeLiquid);
    }
    @Transactional
    @Override
    public TypeLiquid findTypeLiquidById(int id) {
        TypeLiquid typeLiquid=sessionFactory.getCurrentSession().get(TypeLiquid.class,id);
        return typeLiquid;
    }
}







