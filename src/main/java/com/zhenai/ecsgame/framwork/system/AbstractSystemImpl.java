package com.zhenai.ecsgame.framwork.system;

import com.zhenai.ecsgame.framwork.component.ICompontent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.EntityManager;
import com.zhenai.ecsgame.framwork.gameEngine.GameDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/10:18
 * @Description:
 */
public abstract class AbstractSystemImpl implements ISystem {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private GameDriver gameDriver;


    public AbstractSystemImpl() {
        System.out.println(this.getClass().getName()+" : start");
    }

    @PostConstruct
    public  void init(){
        gameDriver.addObj(this);
    }

    public abstract Collection<Class<? extends ICompontent>> interestCompontent();

    @Override
    public Collection<? extends IEntity> getEntities(){
        Collection<Class<? extends ICompontent>> compontentClzs =  interestCompontent();
        if (compontentClzs!=null&& compontentClzs.size()>0){
            return entityManager.getFilterEntity(compontentClzs);
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public abstract void GameUpdate();



    /**
     * system 得全程保持，不能结束
     * @throws Exception
     */
    @Override
    public final void destory() throws Exception {
        throw new Exception();
    }

    @Override
    public GameState getGameState() {
        return GameState.STATE_ING;
    }

    /**
     * system 不能改变state
     * @throws Exception
     */
    @Override
    public void setGameState(GameState state) throws Exception {
        throw new Exception();
    }
}
