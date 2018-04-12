package com.github.service;

import com.github.dataSource.repository.FETAL_COUNTObj;
import com.github.model.FetalInfo;
import com.github.tools.Times;
import org.nutz.dao.Cnd;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.mapl.impl.compile.ObjCompileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Service
public class HomeService {

    @Autowired
    public NutDao dao;

    public List<FetalInfo> home(){
        List<FetalInfo> infos=new ArrayList<>();

        List<FETAL_COUNTObj> counts = dao.query(FETAL_COUNTObj.class, Cnd.orderBy().desc("TIME"));

        counts.stream().forEach(obj -> {
            FetalInfo info=new FetalInfo();
            info.id=obj.getID();
            info.time= Times.formatTime(obj.getTIME());
            info.count=obj.getCOUNT();
            infos.add(info);
        });

        return infos;
    }

    public void fetal(Integer count) {

        FETAL_COUNTObj obj=new FETAL_COUNTObj();
        obj.setCOUNT(count);
        obj.setTIME(Times.now());
        dao.insert(obj);

    }
}
