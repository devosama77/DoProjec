package org.osama.dao.tanker;


import org.osama.model.tanker.SizeTanker;

import java.util.List;

public interface SizeTankerDao {
    public List<SizeTanker> getSizeTankers();
    public void saveSizeTanker(SizeTanker sizeTanker);
    public void updateSizeTanker(SizeTanker sizeTanker);
    public void deleteSizeTanker(int id);
    public SizeTanker findSizeTankerById(int id);
}
