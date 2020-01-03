package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Muzix;

import java.util.List;

public interface MuzixService {

    public Muzix saveMuzix(Muzix muzix);

    public List<Muzix> displayMuzix();

    public void removeMuzixById(long trackId) throws Exception;

    public Muzix UpdateMuzix(Muzix muzix);

}
