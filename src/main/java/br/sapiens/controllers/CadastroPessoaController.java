package br.sapiens.controllers;

import br.sapiens.MeuException;
import br.sapiens.modelo.CursosEnum;
import br.sapiens.modelo.Pessoa;
import br.sapiens.modelo.ProfissaoEnum;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CadastroPessoaController {

    @FXML
    private TextField nome;
    @FXML
    private TextField sobreNome;
    @FXML
    private TextField email;
    @FXML
    private ChoiceBox curso;
    @FXML
    private ChoiceBox profissao;
    @FXML
    private CheckBox bolsa;



    public void salvar() {
        boolean bolsista = false;
        if(bolsa.isSelected()){
            bolsista = true;
        } else {
            bolsista = false;
        }
        Pessoa pessoa = null;
        try {
            pessoa = new Pessoa(
                    nome.getText(),
                    sobreNome.getText(),
                    email.getText(),
                    (CursosEnum) curso.getValue(),
                    (ProfissaoEnum) profissao.getValue(),
                    bolsista
            );
            String msg = "Cadastrado com sucesso! ";
            var alerta = new Alert(Alert.AlertType.ERROR,msg);
            alerta.setTitle("Cadatrado");
            alerta.show();
        } catch (MeuException e) {
            e.mostrarAlert();
        }

    }
}