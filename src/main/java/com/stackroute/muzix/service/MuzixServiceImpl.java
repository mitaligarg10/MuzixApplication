package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Muzix;
import com.stackroute.muzix.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {

    MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    @Override
    public Muzix saveMuzix(Muzix muzix) {
        Muzix savedMuzix = muzixRepository.save(muzix);
        return savedMuzix;
    }

    @Override
    public List<Muzix> displayMuzix() {
        return muzixRepository.findAll();
    }

    @Override
    public Muzix UpdateMuzix(Muzix muzix) {
        Optional<Muzix> updatedMuzix = muzixRepository.findById(muzix.getTrackId());
        if (updatedMuzix.isPresent()) {
            Muzix muzixRecords = updatedMuzix.get();
            muzixRecords.setTrackName(muzix.getTrackName());
            muzixRecords.setTrackComments(muzix.getTrackComments());
            muzixRecords.setYearOfRelease(muzix.getYearOfRelease());
            muzixRecords = muzixRepository.save(muzixRecords);
            return muzixRecords;
        } else {
            muzix = muzixRepository.save(muzix);
            return muzix;
        }
    }

    @Override
    public void removeMuzixById(long trackId) throws Exception {
        Optional<Muzix> remMuzix = muzixRepository.findById((long) trackId);
        if (remMuzix.isPresent()) {
            muzixRepository.deleteById((long) trackId);
        } else {
            throw new Exception("No track record exist for given trackId");

        }
    }
}
