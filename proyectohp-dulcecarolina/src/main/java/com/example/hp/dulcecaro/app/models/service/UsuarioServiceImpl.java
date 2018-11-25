/*package com.example.hp.dulcecaro.app.models.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IUsuarioDao;
import com.example.hp.dulcecaro.app.models.entity.Cliente;
import com.example.hp.dulcecaro.app.models.entity.Rol;
import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;
import com.example.hp.dulcecaro.app.validations.UsuarioExisteException;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public Usuario registrarNuevoUsuario(UsuarioDTO cuentaDTO) 
		throws UsuarioExisteException{
			
			if(usuarioExiste(cuentaDTO.getUsername())) {
				throw new UsuarioExisteException("Ya existe un Usuario registrado con ese Email. Por favor, intente con otro nuevamente.");
			};
					
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		Rol rol = new Rol();
		rol.setAuthorityUser();//para que por defecto sea ROLE_USER
		
				
		usuario.setUsername(cuentaDTO.getUsername());
		usuario.setPassword(passwordEncoder.encode(cuentaDTO.getPassword()));
		usuario.setEnabled(true); //deberia habilitarse cuando se manda confirmacion de cuenta!
		usuario.setRoles(Arrays.asList(rol));
		
		cliente.setNom(cuentaDTO.getCliente().getNom());
		cliente.setTel(cuentaDTO.getCliente().getTel());
		cliente.setEmail(usuario.getUsername());
		cliente.setApe(cuentaDTO.getCliente().getApe());
		cliente.setDir(cuentaDTO.getCliente().getDir());
		usuario.setCliente(cliente);
		
		return usuarioDao.save(usuario);
	}
		

	private boolean usuarioExiste(String username) {

		Usuario usuario = usuarioDao.findByUsername(username);
		if (usuario!=null) {
			return true;
		}
		return false;
	}
	
}
*/
package com.example.hp.dulcecaro.app.models.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IUsuarioDao;
import com.example.hp.dulcecaro.app.models.dao.IUsuarioDaoCustom;
import com.example.hp.dulcecaro.app.models.entity.Cliente;
import com.example.hp.dulcecaro.app.models.entity.Rol;
import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;
import com.example.hp.dulcecaro.app.validations.UsuarioExisteException;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IUsuarioDaoCustom usuarioDaoCustom;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public Usuario registrarNuevoUsuario(UsuarioDTO cuentaDTO) 
		throws UsuarioExisteException{
			
			if(usuarioExiste(cuentaDTO.getUsername())) {
				throw new UsuarioExisteException("Ya existe un Usuario registrado con ese Email. Por favor, intente con otro nuevamente.");
			};
					
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		Rol rol = new Rol();
		rol.setAuthorityUser();//para que por defecto sea ROLE_USER
		
				
		usuario.setUsername(cuentaDTO.getUsername());
		usuario.setPassword(passwordEncoder.encode(cuentaDTO.getPassword()));
		usuario.setEnabled(true); //deberia habilitarse cuando se manda confirmacion de cuenta!
		usuario.setRoles(Arrays.asList(rol));
		
		cliente.setNom(cuentaDTO.getCliente().getNom());
		cliente.setTel(cuentaDTO.getCliente().getTel());
		cliente.setEmail(usuario.getUsername());
		cliente.setApe(cuentaDTO.getCliente().getApe());
		cliente.setDir(cuentaDTO.getCliente().getDir());
		usuario.setCliente(cliente);
		
		return usuarioDao.save(usuario);
	}
		

	private boolean usuarioExiste(String username) {

		Usuario usuario = usuarioDao.findByUsername(username);
		if (usuario!=null) {
			return true;
		}
		return false;
	}
	
	public Usuario findByUsername(String username) {
		Usuario usuario = usuarioDao.findByUsername(username);
		return usuario;
	}
	
	public void save(Usuario usuario) {
		
		usuarioDao.save(usuario);
	}
	
	public void merge(Usuario usuario) {
		
		usuarioDaoCustom.merge(usuario);
	}
	
	public Usuario cambiarPassword(Usuario usuario, String password) {
		
		
		usuario.setPassword(passwordEncoder.encode(password));
		return usuario;		
	}
	
	public String encriptar(String password) {
		String passEncriptado = passwordEncoder.encode(password);
		return passEncriptado;
	}
}
