package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.Prep;

public interface PrepDAO {
    public void insert(Prep prep);
    public Prep findPrepById(int id);
}
