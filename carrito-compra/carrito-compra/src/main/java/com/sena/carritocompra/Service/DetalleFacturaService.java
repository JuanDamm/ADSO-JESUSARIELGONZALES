package com.sena.carritocompra.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carritocompra.Entity.DetalleFactura;
import com.sena.carritocompra.IRepository.IDetalleFacturaRepository;
import com.sena.carritocompra.IService.IDetalleFacturaService;

@Service
public class DetalleFacturaService implements IDetalleFacturaService{
    @Autowired
    private IDetalleFacturaRepository repository;



    @Override
    public List<DetalleFactura> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DetalleFactura> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public DetalleFactura save(DetalleFactura detalleFactura) {
        detalleFactura.setFechaCreacion(LocalDateTime.now());
        return repository.save(detalleFactura);
    }

    @Override
    public void update(DetalleFactura detalleFactura, Long id) {
        //Consultar si existe el registro
        Optional<DetalleFactura> op = repository.findById(id);
        if(op.isEmpty()){
            System.out.println("Registro no existente");
        }
        else {
            DetalleFactura updateDetalleFactura = op.get(); //obtiene todo los datos de la base de datos
            updateDetalleFactura.setCantidad(detalleFactura.getCantidad());
            updateDetalleFactura.setValorPagar(detalleFactura.getValorPagar());
            updateDetalleFactura.setProductoId(detalleFactura.getProductoId());
            updateDetalleFactura.setFacturaId(detalleFactura.getFacturaId());
            updateDetalleFactura.setEstado(detalleFactura.getEstado());
            updateDetalleFactura.setFechaModificacion(detalleFactura.getFechaModificacion());

            repository.save(updateDetalleFactura);

        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deletedAt(Long id) {
        Optional<DetalleFactura> op = repository.findById(id);
        if (op.isEmpty()) {
            System.out.println("Registro no encontrado");
        }else{
            DetalleFactura updateDetalleFactura = op.get();
            updateDetalleFactura.setFechaEliminacion(LocalDateTime.now());	
            repository.save(updateDetalleFactura);

        }
    }

}
