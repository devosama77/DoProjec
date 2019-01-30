package org.osama.services.tanker;

import org.osama.dao.tanker.NumberTankerDao;
import org.osama.model.tanker.NumberTanker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class NumberTankerServiceImpl implements NumberTankerService {
    @Autowired
    NumberTankerDao numberTankerDao;

    @Transactional
    @Override
    public List<NumberTanker> getNumberTankers() {
        return numberTankerDao.getNumberTankers();
    }
    @Transactional
    @Override
    public void saveNumberTanker(NumberTanker numberTanker) {
        numberTankerDao.saveNumberTanker(numberTanker);
    }
    @Transactional
    @Override
    public void updateNumberTanker(NumberTanker numberTanker) {
        numberTankerDao.updateNumberTanker(numberTanker);

    }
    @Transactional
    @Override
    public void deleteNumberTanker(int id) {
        numberTankerDao.deleteNumberTanker(id);

    }
    @Transactional
    @Override
    public NumberTanker findNumberTankerById(int id) {
        NumberTanker numberTankerById = numberTankerDao.findNumberTankerById(id);
        return numberTankerById;
    }
}
