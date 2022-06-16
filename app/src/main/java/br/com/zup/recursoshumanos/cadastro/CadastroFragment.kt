package br.com.zup.recursoshumanos.cadastro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentCadastroBinding
import br.com.zup.recursoshumanos.funcionario.Funcionario

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var funcionario: Funcionario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCalcular = binding.btnCalcularSalario

        btnCalcular.setOnClickListener {
            if (getFuncionario()){
                val bundle = bundleOf("FUNCIONARIO" to funcionario)

                NavHostFragment.findNavController(this).navigate(
                    R.id.action_cadastroFragment_to_detalheFuncionarioFragment, bundle
                )
            }else{
                binding.etNomeFuncionario.error = if (binding.etNomeFuncionario.text.toString().isBlank()) "Digite o nome" else null
                binding.etHorasTrabalhadas.error = if (binding.etHorasTrabalhadas.text.toString().isBlank()) "Digite as horas" else null
                binding.etValorDasHoras.error = if (binding.etValorDasHoras.text.toString().isBlank()) "Digite o valor" else null
            }
        }
    }

    private fun adicionarFuncionario(nome: String, horasTrabalhadas: Int, valorHora: Double): Funcionario{
        funcionario =  Funcionario(nome, horasTrabalhadas, valorHora)
        return funcionario
    }

    private fun getFuncionario(): Boolean {
        val nome = binding.etNomeFuncionario.text.toString()
        val horasTrabalhadas = binding.etHorasTrabalhadas.text.toString()
        val valorHoras = binding.etValorDasHoras.text.toString()
        if(nome.isNotBlank() && horasTrabalhadas.isNotBlank() && valorHoras.isNotBlank()){
            adicionarFuncionario(nome, horasTrabalhadas.toInt(), valorHoras.toDouble())
        }

        return nome.isNotBlank() && horasTrabalhadas.isNotBlank() && valorHoras.isNotBlank()
    }

}