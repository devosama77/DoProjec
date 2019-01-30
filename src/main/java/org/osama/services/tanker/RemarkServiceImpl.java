package org.osama.services.tanker;

import org.osama.dao.tanker.RemarkDao;
import org.osama.model.tanker.Remark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RemarkServiceImpl implements RemarkService {

    @Autowired
    RemarkDao remarkDao;
    @Transactional
    @Override
    public List<Remark> getRemarks() {
        return remarkDao.getRemarks();
    }
    @Transactional
    @Override
    public void saveRemark(Remark remark) {
              remarkDao.saveRemark(remark);
    }
    @Transactional
    @Override
    public void updateRemark(Remark remark) {
           remarkDao.updateRemark(remark);
    }
    @Transactional
    @Override
    public void deleteRemark(int id) {
        remarkDao.deleteRemark(id);
    }
    @Transactional
    @Override
    public Remark findRemarkById(int id) {
        Remark remarkById = remarkDao.findRemarkById(id);
        return remarkById;
    }
}
