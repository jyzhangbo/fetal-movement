/*******************************************************************************
 数据库Bean
 创建程序 Program 版本(3.0)
 程序设计 张建设 EMAIL:zhangjianshe@gmail.com PHONE:15910868680
/******************************************************************************/

package com.github.dataSource.repository;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.sql.Timestamp;

@Table("fetal_count")
public class FETAL_COUNTObj {

  @Id
  public Integer ID;

  @Column("COUNT")
  public Integer COUNT;

  @Column("TIME")
  public java.sql.Timestamp TIME;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }

    public Timestamp getTIME() {
        return TIME;
    }

    public void setTIME(Timestamp TIME) {
        this.TIME = TIME;
    }
}
