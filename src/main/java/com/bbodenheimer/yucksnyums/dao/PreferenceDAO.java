package com.bbodenheimer.yucksnyums.dao;

import com.bbodenheimer.yucksnyums.model.Preference;

public interface PreferenceDAO {
    public void inset(Preference preference);
    public Preference findPreferenceById(int id);
}
