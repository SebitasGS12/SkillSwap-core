package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.CategoriaHabilidad;
import com.skillswap.skillswap_core.entity.ChatUsuario;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.ChatUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Estandares.API + "ChatUsuario")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class ChatUsuarioController {

    private final ChatUsuarioService service;

    @GetMapping
    public ResponseEntity<List<ChatUsuario>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatUsuario> buscar(@PathVariable int id) {
        try {
            ChatUsuario chatUsuario = service.findById(id);
            return ResponseEntity.ok(chatUsuario);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @PostMapping
    public ResponseEntity<ChatUsuario> guardar(@RequestBody ChatUsuario chatUsuario) {
        ChatUsuario nuevo = service.saveChatUsuario(chatUsuario);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatUsuario> actualizar(@PathVariable int id, @RequestBody ChatUsuario chatUsuario) {
        validarExistencia(id);
        chatUsuario.setChatUsuarioId(id);
        ChatUsuario update = service.saveChatUsuario(chatUsuario);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        validarExistencia(id);
        service.delteChatUsuarioById(id);
        String msg = "ChatUsuario Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            service.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
