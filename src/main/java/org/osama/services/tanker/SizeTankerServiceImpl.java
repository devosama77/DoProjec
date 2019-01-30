package org.osama.services.tanker;

import org.osama.dao.tanker.SizeTankerDao;
import org.osama.model.tanker.SizeTanker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SizeTankerServiceImpl implements SizeTankerService {
    @Autowired
    SizeTankerDao sizeTankerDao;
    @Transactional
    @Override
    public List<SizeTanker> getSizeTankers() {
        return sizeTankerDao.getSizeTankers();
    }
    @Transactional
    @Override
    public void saveSizeTanker(SizeTanker sizeTanker) {
           sizeTankerDao.saveSizeTanker(sizeTanker);
    }
    @Transactional
    @Override
    public void updateSizeTanker(SizeTanker sizeTanker) {
           sizeTankerDao.updateSizeTanker(sizeTanker);
    }
    @Transactional
    @Override
    public void deleteSizeTanker(int id) {
         sizeTankerDao.deleteSizeTanker(id);
    }
    @Transactional
    @Override
    public SizeTanker findSizeTankerById(int id) {
        SizeTanker sizeTankerById = sizeTankerDao.findSizeTankerById(id);
        return sizeTankerById;
    }
}
