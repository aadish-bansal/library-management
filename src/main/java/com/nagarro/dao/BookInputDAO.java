package com.nagarro.dao;


import java.util.LinkedHashMap;

public interface BookInputDAO {
    public LinkedHashMap<Integer,String> populateAuthorName();
    public String setCurrentDate();
}
