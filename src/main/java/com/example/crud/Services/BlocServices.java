package com.example.crud.Services;

import com.example.crud.BlocCard.BlocCard;
import com.example.crud.Entity.BlocEntity;
import com.example.crud.Repository.RepositoryBloc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class BlocServices {
    @Autowired
    private RepositoryBloc repositoryBloc;
    @Value("${url.server}")
    private String urlServer;

    public ResponseEntity<List<BlocEntity>> getAllBloc() {
        List<BlocEntity> listBloc = repositoryBloc.findAll();

        return ResponseEntity.ok().body(listBloc);
    }

    public ResponseEntity<BlocEntity> createBlocService(BlocCard blocCard) {

        BlocEntity blocEntity = BlocEntity.builder().titulo(blocCard.getTitulo())
                .asunto(blocCard.getAsunto())
                .descripcion(blocCard.getDescripcion())
                .color(blocCard.getColor()).build();

        BlocEntity dataRepository =  repositoryBloc.save(blocEntity);

        URI uri = UriComponentsBuilder.fromUriString(urlServer).encode().build().toUri();
        System.out.println(dataRepository);

        return ResponseEntity.created(uri).body(dataRepository);
    }

    public ResponseEntity<BlocEntity> deleteBlocService(Long id) {

        this.repositoryBloc.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<BlocEntity> updateBlocService(BlocCard blocCard, Long idBloc){

        BlocEntity blocEntity = BlocEntity.builder().titulo(blocCard.getTitulo())
                .asunto(blocCard.getAsunto())
                .descripcion(blocCard.getDescripcion())
                .color(blocCard.getColor()).idBloc(idBloc).build();

        BlocEntity entityBlocUpdate = this.repositoryBloc.save(blocEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(entityBlocUpdate);
    }
}
