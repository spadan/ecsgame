package com.zhenai.ecsgame.framwork.gameEngine;


import com.zhenai.ecsgame.framwork.gameEngine.util.BeanUtils;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:30
 * @Description:
 */
public abstract class AbstractGameObject implements IGameObject {

    private GameState gameState = GameState.STATE_START;


    private IGameDriver gameDriver;

    public AbstractGameObject(){
        gameDriver = BeanUtils.getBean(IGameDriver.class);
        gameDriver.addObj(this);
    }


    @Override
    public void gameUpdate() {

    }

    @Override
    public void destory() throws Exception {
        setGameState(GameState.STATE_END);
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public void setGameState(GameState state)  {
        this.gameState = state;
    }
}
