package org.osama.dao.tanker;

import org.osama.model.tanker.NumberTanker;

import java.util.List;

public interface NumberTankerDao {
    public List<NumberTanker> getNumberTankers();
    public void saveNumberTanker(NumberTanker numberTanker);
    public void updateNumberTanker(NumberTanker numberTanker);
    public void deleteNumberTanker(int id);
    public NumberTanker findNumberTankerById(int id);
}
