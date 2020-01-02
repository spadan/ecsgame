package com.zhenai.ecsgame.framwork.entity;

import com.zhenai.ecsgame.framwork.component.ICompontent;
import com.zhenai.ecsgame.framwork.gameEngine.EntityManager;
import com.zhenai.ecsgame.framwork.gameEngine.IEntityManager;
import com.zhenai.ecsgame.framwork.gameEngine.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntity implements IEntity {


    IEntityManager entityManager;

    public AbstractEntity(){
        entityManager = BeanUtils.getBean(IEntityManager.class);
        entityManager.onCreatEntity(this);
    }

    @Override
    public void destroy() {
        entityManager.onRemoveEntity(this);
    }

    private Map<String, ICompontent> compontentMap = new HashMap<>();




    @Override
    public <T extends ICompontent> T getCompontent(Class<T> clz) {
        if (compontentMap.containsKey(clz.getName())){
            return (T)compontentMap.get(clz.getName());
        }else {
            return null;
        }
    }

    @Override
    public ICompontent getCompontent(String clzName) {
        return compontentMap.get(clzName);
    }

    @Override
    public <T extends ICompontent> IEntity addCompontent(T t) {
        compontentMap.put(t.getClass().getName(),t);
        return this;
    }



    @Override
    public  void removeCompontent(Class<? extends ICompontent> t) {
        if (compontentMap.containsKey(t.getName())){
            compontentMap.remove(t.getName());
        }
    }


    @Override
    public void clearAllCompontents() {
        compontentMap.clear();
    }


    @Override
    public boolean isContainCompontents(Collection<Class<? extends ICompontent>> clzs) {
        if (clzs==null||clzs.size()==0){
            return false;
        }
        boolean result = true;
        for (Class<? extends ICompontent> clz : clzs) {
            if (!compontentMap.containsKey(clz.getName())){
                result = false;
                break;
            }
        }
        return result;
    }
}
