var Arm = Arm || {};

Arm.ComboCategoria	= (function () {

	 function ComboCategoria(){
		this.combo = $('#categoria');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	 }
	 
	 ComboCategoria.prototype.iniciar = function () {
		this.combo.on('change', onCategoriaAlterada.bind(this));
	}
	 
	 function onCategoriaAlterada() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	 return ComboCategoria;
	 
}());

Arm.ComboSubCategoria = (function() {
	
		function ComboSubCategoria(comboCategoria){
			this.comboCategoria =  comboCategoria;
			this.combo = $('#subcategoria');
			this.imgloading = $('.js-img-loading');
		}
	
		ComboSubCategoria.prototype.iniciar = function() {
			reset.call(this);
			this.comboCategoria.on('alterado', onCategoriaAlterada.bind(this));
		}	
		
		function onCategoriaAlterada(evento, codigoCategoria) {
//			console.log('codigo da categória ', codigoCategoria);
			if(codigoCategoria){
				var resposta = $.ajax({
					url: this.combo.data('url'),
					method:'GET',
					contentType:'application/json',
					data:{'categoria': codigoCategoria},
					beforeSend: iniciarRequisicao.bind(this),
					complete: finalizarRequisicao.bind(this)
				});
				resposta.done(onBuscarSubCategoriasFinalizado.bind(this));
			}else {
				reset.call(this);
			}
		}

		function onBuscarSubCategoriasFinalizado(subcategias) {
			var options = [];
			subcategias.forEach(function(subcategoria){
				options.push('<option value"' + subcategoria.codigo + '">' + subcategoria.nome + '</option>');
			});
			this.combo.html(options.join(''));
			this.combo.removeAttr('disabled');
			
		}
		
		
		function reset() {
			this.combo.html('<option value="">Selecione a SubCategoria</option>');
			this.combo.val('');
			this.combo.attr('disabled', 'disabled');
	}
		
		function iniciarRequisicao() {
			reset.call(this);
			this.imgloading.show();
		}
		
		function finalizarRequisicao() {
			this.imgloading.hide();	
		}
		
		return ComboSubCategoria;
}());

$(function(){
		
	var comboCategoria = new Arm.ComboCategoria();
	comboCategoria.iniciar();
	var comboSubCategoria = new Arm.ComboSubCategoria(comboCategoria);
	comboSubCategoria.iniciar(); 
	
});