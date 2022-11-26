package com.demo.spring.Application.repository;
import java.util.List;

import com.demo.spring.Application.model.Actor;

public interface ActorRepository {
    public List<Actor> findAllActors();
}
