package com.example.calcularimc;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calcularimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    function calcularImc(event) {
        // Previne que a tela se recarregue quando a função for executada
        // event.preventDefault()

        console.log("Funcionante!!!");

        // Executa a função pegarValores
        let dadosUsuario = pegarValores();

        // Executa a função calcular e salva seu retorno na variavel imc
        let imc = calcular(dadosUsuario.altura, dadosUsuario.peso);

        // Executa a função classificarImc passando como atributo o valor que esta na variavel imc e salva seu retorno na variavel classificacaoImc
        let classificacaoImc = classificarImc(imc);

        // Executa a função organizarDados passando os atributos: dadosUsuario, imc e classificacaoImc, e salva seu retorno na variavel usuarioAtualizado
        let usuarioAtualizado = organizarDados(dadosUsuario, imc, classificacaoImc);

        // Executa a função cadastrarUsuario passando como parametro o usuarioAtualizado
        cadastrarUsuario(usuarioAtualizado);

    }

    // Passo 1 - Pegar valor
    function pegarValores() {
        // Obtém os valores que foram digitados em cada elemento identificados pelo ID
        let nomeRecebido = document.getElementById("nome").value.trim(); // trim - apaga os possiveis espaços em branco no inicio e fim da string
        let alturaRecebida = parseFloat(document.getElementById("altura").value);
        let pesoRecebido = parseFloat(document.getElementById("peso").value);

        // Cria um objeto salvando os valores obtidos nos atributos
        let dadosUsuario = {
                nome: nomeRecebido,
                altura: alturaRecebida,
                peso: pesoRecebido
    }

        console.log(dadosUsuario);

        // Retorna o objeto dadosUsuario
        return dadosUsuario;
    }


    //Passo 2 - Calcular
    function calcular(altura, peso) {
        // Faz o calculo para encontrar o imc: PESO dividido por(ALTURA vezes ALTURA) e salva na variavel
        let imc = peso / (altura * altura)

        console.log(imc);

        // Retorna a variavel imc
        return imc;
    }


    //Passo 3 - Classificar
    function classificarImc(imc) {
    /*
        Resultado	        Situação
        Abaixo de 18,5      Filezinho!!!
        Entre 18,5 e 24,99	Diliça!!!
        Entre 25 e 29,99	Ta Top!!!
        Acima de 30      	Oh la em casa!!!
    */

        // Avalia o valor que esta dentro da variavel imc e retorna um valor diferente para cada intervalo
        if(imc < 18.5){
            return "Filezinho!!!";

        }else if(imc < 25){
            return "Diliça!!!"

        }else if (imc < 30) {
            return "Ta Top!!!"

        }else{
            return "Oh la em casa!!!"
        }
    }
}