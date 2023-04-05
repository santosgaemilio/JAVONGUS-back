//package generation.javongus.html.services;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import generation.javongus.html.model.Usuario;
//import generation.javongus.html.repository.UsuarioRepository;
//
//@Service
//public class UserLogService implements UserDetailsService{
//	private UsuarioRepository usuarioRe;
//	@Autowired
//	public UserLogService(UsuarioRepository usuarioRe) {
//		this.usuarioRe = usuarioRe;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
//		Usuario usuario = usuarioRe.findByCorreo(correo)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));
//		return new User(usuario.getCorreo(), usuario.getPassword(), Collections.emptyList());
//	}
//	
//
//}
