package com.zhenai.ecsgame.framwork.system;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.EntityManager;
import com.zhenai.ecsgame.framwork.gameEngine.GameDriver;
import com.zhenai.ecsgame.framwork.gameEngine.NotifyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/10:18
 * @Description:
 */
@DependsOn(value = "entityManagerIml")
public abstract class AbstractSystemImpl implements ISystem {


    @Autowired
    private EntityManager entityManagerIml;

    @Autowired
    private GameDriver gameDriver;


    Collection<IEntity> entities = new HashSet<>();
    private GameState state = GameState.STATE_START;


    public AbstractSystemImpl() {
        System.out.println(this.getClass().getName()+" : start");
    }

    @PostConstruct
    public  void init(){
        register(getRegisters());
        gameDriver.addObj(this);

    }

    public abstract Collection<Class<? extends IEntity>> getRegisters();

    @Override
    public abstract void GameUpdate();

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof NotifyBean) {
            NotifyBean notifyBean = (NotifyBean) arg;
            if (notifyBean.getOpt() == NotifyBean.Opt.Notify_Add) {
                entities.add(notifyBean.getEntity());
            } else if (notifyBean.getOpt() == NotifyBean.Opt.Notify_Remove) {
                entities.remove(notifyBean.getEntity());
            }
        }
    }

    private void register(Collection<Class<? extends IEntity>> arr) {
        if (arr != null) {
            for (Class entityClass : arr) {
                register(entityClass);
            }
        }
    }

    public void register(Class<? extends IEntity> entityClass) {
        if (entityClass != null) {
            entityManagerIml.registerListener(entityClass, this);
        }
    }

    /**
     * system 得全程保持，不能结束
     * @throws Exception
     */
    @Override
    public final void destory() throws Exception {
        throw new Exception();
//        setGameState(GameState.);
    }

    @Override
    public GameState getGameState() {
        return state;
    }

    @Override
    public void setGameState(GameState state) {
        this.state = state;
    }
}
