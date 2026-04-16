package com.example.ejemplo.controller;

import com.example.ejemplo.entity.*;
import com.example.ejemplo.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Logincontroller {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductosService productosService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private Detalle_VentaService detalleVentaService;

    @PostMapping("/login")
    public String login(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            HttpSession session,
            Model model) {

        if (username == null || password == null) {
            return "login";
        }

        Usuarios u = usuarioService.login(username, password);

        if (u != null) {
            session.setAttribute("usuario", u);
            return "redirect:/home";
        }

        model.addAttribute("error", "Credenciales incorrectas");
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password) {

        Usuarios u = new Usuarios();
        u.setUsername(username);
        u.setEmail(email);
        u.setPasword(password);

        u.setRol("USER");
        u.setEstado(1);

        usuarioService.saveUsuarios(u);

        return "redirect:/login";
    }

    //================= Usuario ================//
    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuarios usuario) {

        if (usuario.getCodigousuario() == null) {
            usuarioService.saveUsuarios(usuario);
        } else {
            usuarioService.updateUsuarios(usuario.getCodigousuario(), usuario);
        }

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model) {

        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        model.addAttribute("usuario", usuarioService.getUsuariosByid(id));

        return "usuarios";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {

        usuarioService.deleteUsuarios(id);

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/buscar")
    public String buscarUsuario(@RequestParam Integer id, Model model) {

        Usuarios usuario = usuarioService.getUsuariosByid(id);

        model.addAttribute("usuarios", java.util.List.of(usuario));

        return "usuarios";
    }
    // =============================================================//

    // ================= CLIENTES ================= //

    @PostMapping("/clientes/guardar")
    public String guardarCliente(Clientes clientes) {

        if (clientes.getDpicliente() == null) {
            clienteService.saveClientes(clientes);
        } else {
            clienteService.updateClientes(clientes.getDpicliente(), clientes);
        }

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editarCliente(@PathVariable Integer id, Model model) {

        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("cliente", clienteService.getClientesById(id));

        return "clientes";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {

        clienteService.deleteClientes(id);

        return "redirect:/clientes";
    }
    //==========================================================================//
    // ================= PRODUCTOS ================= //

    @PostMapping("/productos/guardar")
    public String guardarProducto(Productos producto) {

        if (producto.getCodigoproducto() == null) {
            productosService.saveproductos(producto);
        } else {
            productosService.updateproductos(producto.getCodigoproducto(), producto);
        }

        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable Integer id, Model model) {

        model.addAttribute("productos", productosService.getAllproductos());
        model.addAttribute("producto", productosService.getproductosById(id));

        return "productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {

        productosService.deleteproductos(id);

        return "redirect:/productos";
    }

    // ===========================================================//

    // ========================Ventas=============================//

    // ================= VENTAS ================= //
    @PostMapping("/ventas/guardar")
    public String guardarVenta(@ModelAttribute Venta venta) {
        if (venta.getCodigoventa() == null) {
            ventaService.saveVenta(venta);
        } else {
            ventaService.updateVenta(venta.getCodigoventa(), venta);
        }
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/editar/{id}")
    public String editarVenta(@PathVariable Integer id, Model model) {
        model.addAttribute("ventas", ventaService.getAllVenta());
        model.addAttribute("venta", ventaService.getVentaById(id));
        return "ventas";
    }

    @GetMapping("/ventas/eliminar/{id}")
    public String eliminarVenta(@PathVariable Integer id) {
        ventaService.deleteVenta(id);
        return "redirect:/ventas";
    }
    // ============================================================================//

    // =============================== detalle venta ==================================//
    @GetMapping("/detalle-venta")
    public String listarDetalleVenta(Model model) {
        model.addAttribute("detalles", detalleVentaService.getAllDetalle_Venta());
        model.addAttribute("detalle", new Detalle_Venta());
        return "detalle-venta";
    }

    @PostMapping("/detalle-venta/guardar")
    public String guardarDetalle(@ModelAttribute Detalle_Venta detalle) {

        if (detalle.getCodigodetalleventa() == null) {
            detalleVentaService.saveDetalle_Venta(detalle);
        } else {
            detalleVentaService.updateDetalle_Venta(detalle.getCodigodetalleventa(), detalle);
        }

        return "redirect:/detalle-venta";
    }

    @GetMapping("/detalle-venta/editar/{id}")
    public String editarDetalle(@PathVariable Integer id, Model model) {

        model.addAttribute("detalles", detalleVentaService.getAllDetalle_Venta());
        model.addAttribute("detalle", detalleVentaService.getDetalle_VentaById(id));

        return "detalle-venta";
    }

    @GetMapping("/detalle-venta/eliminar/{id}")
    public String eliminarDetalle(@PathVariable Integer id) {

        detalleVentaService.deleteDetalle_Venta(id);

        return "redirect:/detalle-venta";
    }
    // ================================================================================//

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("cliente", new Clientes());
        return "clientes";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        model.addAttribute("usuario", new Usuarios());
        return "usuarios";
    }

    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productosService.getAllproductos());
        model.addAttribute("producto", new Productos());
        return "productos";
    }

    @GetMapping("/ventas")
    public String ventas(Model model) {
        model.addAttribute("ventas", ventaService.getAllVenta());
        model.addAttribute("venta", new Venta());
        return "ventas";
    }

    @GetMapping("/detalle-venta/")
    public String detalleVenta(Model model) {
        model.addAttribute("detalles", detalleVentaService.getAllDetalle_Venta());
        return "detalle-venta";
    }

    @GetMapping("/login")
    public String mostrarlogin() {
        return "login";
    }

    @GetMapping("/register")
    public String mostrarregister() {
        return "register";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
