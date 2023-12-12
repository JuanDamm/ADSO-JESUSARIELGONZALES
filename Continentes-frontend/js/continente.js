function save(){
    var data = {
        'nombre': $('#nombre').val(),
        'codigo': $('#codigo').val(),
        'estado': parseInt($('#estado').val()),
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/v1/api/continentes',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data) {
          alert("Registro agregado con éxito");
          loadData();
          clearData();
        },
        error: function (error) {
          console.error('Error en la solicitud:', error);
        }
      });
    }

    function update(id) {
        // Construir el objeto data
        var data = {
          'nombre': $('#nombre').val(),
          'codigo': $('#codigo').val(),
          'estado': parseInt($('#estado').val()),
        };
      
        var jsonData = JSON.stringify(data);
        $.ajax({
          url: 'http://localhost:9000/v1/api/continentes/' + id,
          method: 'PUT',
          dataType: 'json',
          contentType: 'application/json',
          data: jsonData,
          success: function (data) {
            alert("Registro actualizado con éxito");
            loadData();
            clearData();
      
            // actualizar botón
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
          },
          error: function (error) {
            console.error('Error en la solicitud:', error);
      
            // Agregar más detalles del error a la consola
            console.log('Error status:', error.status);
            console.log('Error response:', error.responseText);
          }
        });
      }
      
      

      function loadData() {
        $.ajax({
          url: 'http://localhost:9000/v1/api/continentes',
          method: 'GET',
          dataType: 'json',
          success: function (data) {
            var html = '';
      
            data.forEach(function (item) {
              // Construir el HTML para cada objeto
              html += `<tr>
                      <td>`+ item.nombre + `</td>
                      <td>`+ item.codigo + `</td>
                      <td>`+ (item.estado == true ? 'Activio' : 'Inactivo') + `</td>
                      <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(`+ item.id + `)"></th>
                      <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(`+ item.id + `)"></th>
                  </tr>`;
            });
      
            $('#resultData').html(html);
          },
          error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error('Error en la solicitud:', error);
          }
        });
      }
      
      function findById(id) {
        $.ajax({
          url: 'http://localhost:9000/v1/api/continentes/' + id,
          method: 'GET',
          dataType: 'json',
          success: function (data) {
            $('#id').val(data.id);
            $('#nombre').val(data.nombre);
            $('#codigo').val(data.codigo);
            $('#estado').val(data.estado == true ? 1 : 0);
      
            // Cambiar botón.
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update(' + data.id + ')');
          },
          error: function (error) {
            console.error('Error en la solicitud:', error);
          }
        });
      }
      
      
      function deleteById(id) {
        $.ajax({
          url: 'http://localhost:9000/v1/api/continentes/' + id,
          method: "delete",
          headers: {
            "Content-Type": "application/json"
          }
        }).done(function (result) {
          alert("Registro eliminado con éxito");
          loadData();
          clearData();
        })
      }
      
      function clearData() {
        $('#id').val('');
        $('#nombre').val('');
        $('#codigo').val('');
        $('#estado').val('');
      }