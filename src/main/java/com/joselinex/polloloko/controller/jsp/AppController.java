package com.joselinex.polloloko.controller.jsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.joselinex.polloloko.model.Camarero;
import com.joselinex.polloloko.model.Categoria;
import com.joselinex.polloloko.model.Pedido;
import com.joselinex.polloloko.model.Producto;
import com.joselinex.polloloko.repositories.CamareroRepository;
import com.joselinex.polloloko.repositories.PedidoRepository;
import com.joselinex.polloloko.repositories.ProductoRepository;

@Controller
@RequestMapping("/pollolokoapp")
public class AppController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	CamareroRepository camareroRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	@RequestMapping(value = {"","/","/index.html","index","home"})
	public String home() {
		
		return "home";
		
	}

	@RequestMapping("/fichaProducto")
	public ModelAndView paginaPrueba3() {
		
		ModelAndView mav = new ModelAndView();
		
		//Vamos a buscar un Producto a la base de datos.
		
		Optional<Producto> optional = productoRepository.findById(10L);
		Producto producto = optional.isPresent()? optional.get():null;
		
		//Se lo pasamos al JSP
		
		mav.addObject("erProducto",producto);
		
		//Indicamos qué página JSP
		
		mav.setViewName("fichaProducto");
		return mav;
	}
	
	@RequestMapping("/fichaCamarero/{id}")
	
	public ModelAndView paginaPrueba4(@PathVariable ("id") Long id) {
		
		ModelAndView mav = new ModelAndView();
		
		//Vamos a buscar un Camarero a la base de datos.
		
		Optional<Camarero> optional = camareroRepository.findById(id);
		Camarero camarero = optional.isPresent()? optional.get():null;
		
		//Se lo pasamos al JSP
		
		mav.addObject("erCamarero",camarero);
		
		//Indicamos qué página JSP
		
		mav.setViewName("fichaCamarero");
		return mav;
	}
	
	@RequestMapping("/listadoProductos")
	public ModelAndView paginaPrueba5() {
		
		ModelAndView mav = new ModelAndView();
		
		//Vamos a buscar un Producto a la base de datos.
		
		List<Producto> productos = productoRepository.findAll();
		
		//Se lo pasamos al JSP
		
		mav.addObject("productos",productos);
		
		//Indicamos qué página JSP
		
		mav.setViewName("listadoProductos");
		
		return mav;
	}
	
	@RequestMapping("/listadoCamareros")
	public ModelAndView paginaPrueba6() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Camarero> camareros = camareroRepository.findAll();
		
		mav.addObject("camareros", camareros);
		
		mav.setViewName("listadoCamareros");
		
		return mav;
	}
	
	@RequestMapping("/listadoPedidos")
	public ModelAndView paginaPrueba7() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		mav.addObject("pedidos", pedidos);
		
		mav.setViewName("listadoPedidos");
		
		return mav;
	}
	
	//Esto te da el formulario
	@RequestMapping("/altaCamarero")
	public String getAltaCamareroForm() {
		return "altaCamarero";
	}
	
	@RequestMapping(value="/altaCamarero",
					method=RequestMethod.POST)
	public String getAltaCamarero(@RequestParam("codigo") Long id,
									  @RequestParam("nombre") String nombre) {
		
		Camarero camarero = new Camarero();
		camarero.setId(id);
		camarero.setNombre(nombre);
		
		//Ahora que tenemos el camarero, le damos "vida eterna"
		
		camareroRepository.save(camarero);
		
		//Vamos a responder con una redirección
		
		return "redirect:listadoCamareros";
		
	}
	
	//Formulario producto
	@RequestMapping("/altaProducto")
	public ModelAndView getAltaProductoForm() {
		
		//Tengo que enviar al formulario la colección de categorías
		//para que estas se pinten en forma de <option> dentro
		//del selector...
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("altaProducto");
		
		//Pasamos al JSP el array de las categorías
		
		mav.addObject("categorias",Categoria.values());
		
		return mav;
	}
	
	@RequestMapping(value="/altaProducto",
			method=RequestMethod.POST)
	public String getAltaProducto(
			@RequestParam("codigo") Long codigo,
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") double precio,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("fecha") String strFecha,
			@RequestParam(value="descatalogado", required=false) String strDescatalogado,
			@RequestParam("categoria") Categoria categoria) {
	
	System.out.println("codigo:" + codigo);
	System.out.println("nombre:" + nombre);
	System.out.println("precio" + precio);
	System.out.println("descripcion:"+ descripcion);
	System.out.println("fecha" + strFecha);
	System.out.println("descatalogado"+ strDescatalogado);
	System.out.println("categoria" + categoria);
	
	boolean descatalogado = (strDescatalogado == null) ? false : true;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fechaAlta = null;
	
	try {
		fechaAlta = sdf.parse(strFecha);
	}catch (ParseException e) {
		e.printStackTrace();
	}
		
	Producto producto = new Producto();
	producto.setCodigo(codigo);
	producto.setNombre(nombre);
	producto.setPrecio(precio);
	producto.setDescripcion(descripcion);
	producto.setFechaAlta(fechaAlta);
	producto.setDescatalogado(descatalogado);
	producto.setCategoria(categoria);
	
	//Ahora que tenemos el camarero, le damos "vida eterna"
	
	productoRepository.save(producto);
	
	//Vamos a responder con una redirección
	
	return "redirect:listadoProductos";
	
	}
	
	@RequestMapping("/altaPedido")
	public ModelAndView getAltaPedidoForm() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("altaPedido");
		
		List<Camarero> camareros = camareroRepository.findAll();
		mav.addObject("camareros", camareros);
		
		return mav;
		
	}
	
	
	public ModelAndView getAltaPedido(
			@RequestParam("fecha") Date fecha,
			@RequestParam("mesa") int mesa,
			@RequestParam("camarero") Camarero camarero,
			
			
			)
	


}
