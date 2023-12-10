package com.sena.carritocompra.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.carritocompra.IService.IDetalleFacturaService;
import com.sena.carritocompra.Entity.DetalleFactura;


    @CrossOrigin(originPatterns = "*")
    @RestController
    @RequestMapping("v1/api/detalle_factura")

public class DetalleFacturaController {
    @Autowired
    private IDetalleFacturaService service;

    @GetMapping
    public List<DetalleFactura> findAll(){
        return service.findAll();
    }

    /***
     * GetMapping
    Esta anotación indica que el método manejará las solicitudes HTTP GET para la URL que coincide con el patrón especificado 
    entre paréntesis. En este caso, la URL esperada sería algo como "/algunaRuta/{id}", donde "{id}" es una variable de ruta 
    que se puede capturar y usar en el método.
    -----------------------------------------------------------------------------------
    public Optional<DetalleFactura> findById(@PathVariable long id): Este método es un controlador que maneja las solicitudes 
    GET para la URL mencionada anteriormente. El parámetro @PathVariable se utiliza para extraer el valor de la variable de ruta 
    "{id}" y pasarlo como un parámetro al método. El tipo de retorno es Optional<DetalleFactura>, lo que indica que el método 
    puede devolver un objeto DetalleFactura envuelto en un Optional. Optional se utiliza para manejar la posibilidad de que el 
    valor devuelto sea nulo.
    -----------------------------------------------------------------------------------
    return service.findById(id);: Dentro del método, se llama a un método llamado findById en un objeto service. Supongo que 
    este objeto service es un servicio que maneja la lógica de negocio relacionada con la entidad DetalleFactura. La respuesta de 
    este método findById se devuelve directamente como resultado del método controlador. Como se mencionó anteriormente, 
    la respuesta está envuelta en un Optional, lo que implica que el resultado podría ser nulo si no se encuentra ningún 
    detalle de factura con el ID proporcionado.
     */


    @GetMapping("{id}")
    public Optional<DetalleFactura> findById(@PathVariable long id){
        return service.findById(id);
    }

    @PostMapping
    public DetalleFactura save(@RequestBody DetalleFactura detalleFactura) {
        return service.save(detalleFactura);
    }

    @PutMapping("{id}")
    public void save(@RequestBody DetalleFactura detalleFactura, @PathVariable Long id){
        service.update(detalleFactura, id);
    }

    @PutMapping("delete-at/{id}")
    public void deletedAt(@PathVariable Long id){
        service.deletedAt(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    

    



}
