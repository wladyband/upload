package br.com.arm.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import br.com.arm.model.Usuario;

public interface UsuariosQueries {
	
	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);
}
