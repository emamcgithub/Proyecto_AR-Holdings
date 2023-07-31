package com.ar_holdings.service.impl;

import com.ar_holdings.dao.UsuarioDao;
import com.ar_holdings.domain.Rol;
import com.ar_holdings.domain.Usuario;
import com.ar_holdings.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
// se busca en la tabla de usuarios is existe en esta tabla
        Usuario usuario = usuarioDao.findByUsername(username);

        // se valida 
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        //si existe el usuario
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRuta_imagen());

        //se recupera los roles que tiene el usuario
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        //se retorna un user con la informacion para el sistema de seguridad de Spring
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
