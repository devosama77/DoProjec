package org.osama.services.tanker;

import org.osama.dao.tanker.TypeLiquidDao;
import org.osama.model.tanker.TypeLiquid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TypeLiquidServiceImpl implements TypeLiquidService {
    @Autowired
    TypeLiquidDao typeLiquidDao;
    @Override
    public List<TypeLiquid> getTypeLiquids() {
        List<TypeLiquid> typeLiquids = typeLiquidDao.getTypeLiquids();
        return typeLiquids;
    }
    @Transactional
    @Override
    public void saveTypeLiquid(TypeLiquid typeLiquid) {
       typeLiquidDao.saveTypeLiquid(typeLiquid);
    }
    @Transactional
    @Override
    public void updateTypeLiquid(TypeLiquid typeLiquid) {
            typeLiquidDao.updateTypeLiquid(typeLiquid);
    }
    @Transactional
    @Override
    public void deleteTypeLiquid(int id) {
             typeLiquidDao.deleteTypeLiquid(id);
    }
    @Transactional
    @Override
    public TypeLiquid findTypeLiquidById(int id) {
        TypeLiquid typeLiquidById = typeLiquidDao.findTypeLiquidById(id);
        return typeLiquidById;
    }
}
