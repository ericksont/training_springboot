package br.com.ericksontavares.config.validacao;

public class ErroFormularioDTO {
    
    private String campo;
    private String erro;

    public ErroFormularioDTO(String campo,String erro){
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return this.campo;
    }

    public String getErro() {
        return this.erro;
    }

}
