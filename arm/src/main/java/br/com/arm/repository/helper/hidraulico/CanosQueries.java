package br.com.arm.repository.helper.hidraulico;

import java.util.List;

import br.com.arm.model.Cano;
import br.com.arm.repository.filter.CanoFilter;

public interface CanosQueries {
	
	public List<Cano> filtrar(CanoFilter filtro);

}
