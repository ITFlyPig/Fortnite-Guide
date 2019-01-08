package com.statstracker.forfornitegame.pic.model;

import com.statstracker.forfornitegame.base.PubgApplication;
import com.statstracker.forfornitegame.pic.bean.WallPaperBean;
import com.statstracker.forfornitegame.util.DBHepler;

import java.util.List;

public class WallPaperModle {

    /**
     * 获取全部的壁纸数据
     * @return
     */
    public List<WallPaperBean> getAllWallPaper() {
        DBHepler.getInstance().OpenDatabase(PubgApplication.getInstance());
        return DBHepler.getInstance().getAllWallPapers();
    }
}
