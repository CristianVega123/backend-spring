package com.example.crud.Repository;

import com.example.crud.Entity.BlocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBloc extends JpaRepository<BlocEntity, Long> {
}
