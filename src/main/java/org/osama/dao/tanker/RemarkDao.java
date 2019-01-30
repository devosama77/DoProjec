package org.osama.dao.tanker;

import org.osama.model.tanker.Remark;

import java.util.List;

public interface RemarkDao {
    public List<Remark> getRemarks();
    public void saveRemark(Remark remark);
    public void updateRemark(Remark remark);
    public void deleteRemark(int id);
    public Remark findRemarkById(int id);
}
