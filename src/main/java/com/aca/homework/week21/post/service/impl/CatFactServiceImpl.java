package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week15.service.user.Service;
import com.aca.homework.week21.post.entity.CatFact;
import com.aca.homework.week21.post.repository.CatFactRepository;
import com.aca.homework.week21.post.service.core.CatFactCreationParams;
import com.aca.homework.week21.post.service.core.CatFactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

@Service
public class CatFactServiceImpl implements CatFactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatFactServiceImpl.class);
    private final CatFactRepository catFactRepository;

    public CatFactServiceImpl(CatFactRepository catFactRepository) {
        this.catFactRepository = catFactRepository;
    }

    public CatFact create(CatFactCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Creating a new cat fact according to the cat fact creation params - {}", params);
        CatFact catFact = catFactRepository.save(new CatFact(params.getContent(), params.getLength()));
        LOGGER.info("Successfully saved a new car fact according to the cat fact creation params - {}, result - {}", params, catFact);
        return catFact;
    }
}
