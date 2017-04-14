package com.thoughtworks.gaia.A.service;

import com.thoughtworks.gaia.A.AMapper;
import com.thoughtworks.gaia.A.dao.ADao;
import com.thoughtworks.gaia.A.entity.A;
import com.thoughtworks.gaia.A.model.AModel;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.sun.jersey.spi.inject.Errors.error;

/**
 * Created by cypc on 4/7/17.
 */
@Component
@Transactional
public class AService {
    @Autowired
    private AMapper mapper;
    @Autowired
    private ADao aDao;
    public A getA(Long id) {
        AModel aModel = aDao.idEquals(id).querySingle();
        if (aModel == null) {
            error("Product not found with id: " + id);
            throw new NotFoundException();
        }

        return mapper.map(aModel, A.class);
    }

    public A addA(A a) {
        AModel aModel = mapper.map(a,AModel.class);
        aDao.save(aModel);
        return mapper.map(aModel, A.class);
    }
    public A deleteA(Long a_id){
        AModel aModel = aDao.idEquals(a_id).querySingle();
        aDao.remove(aModel);
        return mapper.map(aModel,A.class);
    }
}
