package com.podd.WeatherTracker.dao.impl;

import com.podd.WeatherTracker.dao.BaseDAO;
import com.podd.WeatherTracker.dao.api.CrudDAO;
import com.podd.WeatherTracker.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class CityDAO extends BaseDAO implements CrudDAO<City> {

private static CityDAO cityDAO=null;
public static CityDAO getCityDAO(){
        if(cityDAO==null){
        cityDAO=new CityDAO();
        }
        return cityDAO;
        }
@Override
public City findById(int id){
        City city;
        Session session=getActiveSession();
        city=(City) session.createCriteria(City.class)
        .add(Restrictions.eq("id",id))
        .uniqueResult();
        System.out.println(city);
        return city;
        }

        public City findIdByCity(String name){
            City city;
            Session session = getActiveSession();
            city = (City) session.createCriteria(City.class)
                    .add(Restrictions.eq("city", name))
                    .uniqueResult();
            System.out.println(city);
            return city;
        }


@Override
public List<City> findAll(){
        Session session=null;
        List city=new ArrayList<City>();
        try{
        session=getActiveSession();
        city=session.createCriteria(City.class).list();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage(),"Error 'findAll'",JOptionPane.OK_OPTION);
        }finally{
        if(session!=null&&session.isOpen()){
        session.close();
        }
        }
        return city;
        }

@Override
public void create(City city){
        Session session=getActiveSession();
        Transaction tx=null;
        try{
        tx=session.beginTransaction();
        session.save(city);
        session.flush();
        tx.commit();
        }catch(Exception e){
        if(tx!=null)tx.rollback();
        e.printStackTrace();
        }finally{
        session.close();
        }
        }


@Override
public void update(City city){
        Session session=getActiveSession();
        Transaction tx=null;
        try{
        tx=session.beginTransaction();
        session.update(city);
        tx.commit();
        }catch(Exception e){
        if(tx!=null)tx.rollback();
        e.printStackTrace();
        }finally{
        session.close();
        }
        }

@Override
public void delete(City city){
        Session session=getActiveSession();
        Transaction tx=null;
        try{
        tx=session.beginTransaction();
        session.delete(city);
        tx.commit();
        }catch(Exception e){
        if(tx!=null)tx.rollback();
        e.printStackTrace();
        }finally{
        session.close();
        }
        }
        }