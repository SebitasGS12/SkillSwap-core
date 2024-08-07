package com.skillswap.skillswap_core.service;

import java.util.List;

import com.skillswap.skillswap_core.entity.Usuario;
import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Sesion;
import com.skillswap.skillswap_core.repository.ISesionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SesionService {

    private final ISesionRepository reses;

    public int ultimoId(){
        return 1 ;
    }

    public void openSesion(Usuario usuario){
        deleteAllSesion();
        reses.save(newSesion(usuario));
    }
    public Sesion getSesion(){
        return findAll().stream().findFirst().orElseThrow();
    }

    public void closeSesion(){
        deleteAllSesion();
    }


    public List<Sesion> findAll(){
        return reses.findAll();
    }
    public Sesion findById(int id){
        return  reses.findById(id).orElseThrow();
    }

    public Sesion saveSesion(Sesion sesion) {
        if (sesion.getSesionId() == null ){
            sesion.setSesionId(ultimoId());
        }
        return reses.save(sesion);
    }
    public void deleteSesionById(Integer id) {
        reses.deleteById(id);
    }
    public void deleteAllSesion(){
        reses.deleteAll();
    }

    public Sesion nullSesion() {
        Sesion sesion = new Sesion();
        sesion.setSesionId(null);
        sesion.setObj_Usuario(null);
        return sesion;
    }
    public Sesion newSesion(Usuario usuario) {
        Sesion sesion = new Sesion();
        sesion.setSesionId(ultimoId());
        sesion.setObj_Usuario(usuario);
        return sesion;
    }
}
