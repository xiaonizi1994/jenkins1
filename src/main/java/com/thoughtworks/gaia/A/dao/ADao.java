package com.thoughtworks.gaia.A.dao;

/**
 * Created by cypc on 4/7/17.
 */
import com.thoughtworks.gaia.A.model.AModel;
import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import org.springframework.stereotype.Component;

@Component
public class ADao extends BaseDaoWrapper<AModel> {
    public ADao(){super(AModel.class);}
}
