package org.osama.dao.tanker;


import org.osama.model.tanker.TypeLiquid;

import java.util.List;

public interface TypeLiquidDao {
    public List<TypeLiquid> getTypeLiquids();
    public void saveTypeLiquid(TypeLiquid typeLiquid);
    public void updateTypeLiquid(TypeLiquid typeLiquid);
    public void deleteTypeLiquid(int id);
    public TypeLiquid findTypeLiquidById(int id);
}
