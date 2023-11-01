package com.example.crud.Controllers;

import com.example.crud.BlocCard.BlocCard;
import com.example.crud.Entity.BlocEntity;
import com.example.crud.Services.BlocServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiBloc {

    final private BlocServices blocServices;

    public ApiBloc(BlocServices blocServices) {
       this.blocServices = blocServices;
    }

    @GetMapping("findAll")
    public ResponseEntity<List<BlocEntity>> FindAllBloc() {
        return this.blocServices.getAllBloc();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BlocEntity> CreateBloc(@RequestBody BlocCard blocCard) {
        return this.blocServices.createBlocService(blocCard);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BlocEntity> DeleteBloc(@RequestParam(value = "idBloc") Long idBloc) {
        return this.blocServices.deleteBlocService(idBloc);
    }

    @PutMapping("/update")
    public ResponseEntity<BlocEntity> UpdateBloc(@RequestBody BlocCard blocCard, @RequestParam("idBloc") Long idbBloc){
        System.out.println(idbBloc);
        return this.blocServices.updateBlocService(blocCard, idbBloc);
    }
}
